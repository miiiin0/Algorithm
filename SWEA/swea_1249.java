package SWEA;

import java.util.*;
import java.io.*;

public class swea_1249 {
    static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N;
	static int[][] arr;
	static int answer;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			//입력받기
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String line = br.readLine();
				for(int j=0; j<N; j++) {
					//arr[i][j] = line.charAt(j)-'0';
					arr[i][j] = Character.getNumericValue(line.charAt(j));
				}
			}
			
			answer = BFS();
			
			System.out.println("#"+t+" "+answer);
		}
		
		
	}
	
	static public int BFS() {
		int[][] visited = new int[N][N];
		for(int k=0; k<N; k++) {
			Arrays.fill(visited[k], Integer.MAX_VALUE);
		}
		
		Queue<int[]> q = new LinkedList<>();
		int dis =Integer.MAX_VALUE; 
		
		//(0,0)에서 시작하니까
		visited[0][0] = 0;
		q.offer(new int[] {0, 0, 0});
		
		while(!q.isEmpty()) {
			//큐에서 현재 값  poll해오기
			int[] curData = q.poll();
			int curX = curData[0];
			int curY = curData[1];
			int curDis = curData[2];
			
			//도착지점에 도착했을때
            //최소비용 구하기
			if(curX==N-1 && curY==N-1) {
				dis = Math.min(dis, curDis);
				continue;
			}
			
			for(int k=0; k<4; k++) {
				int nextX = curX + dx[k];
				int nextY = curY + dy[k];
				
				if(0<=nextX && nextX<N && 0<=nextY && nextY<N) {
					int distance = curDis + arr[nextX][nextY];
					//이미 지나갔던 최단비용보다 더 작은 비용으로 지나갈 수 있다면
					//값을 바꿔주고 큐에 넣어준다.
					if(visited[nextX][nextY] > distance) {
						visited[nextX][nextY] = distance;
						q.offer(new int[] {nextX, nextY, distance});
					}
				}
			}
		}
		return dis;
	}
}
