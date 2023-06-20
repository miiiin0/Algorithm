package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_17086 {
    //대각선으로도 움직이기 때문에
    static int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};
    
    static int N, M;
    static int[][] arr, dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dis = new int[N][M];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dis[i][j] = Integer.MAX_VALUE;

                //상어가 있는 칸이라면 큐에 넣기
                if(arr[i][j] == 1) {
                    q.add(new int[] {i, j}); 
                    dis[i][j] = 0;
                }
            }
        }
        
        
        int answer = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i=0; i<8; i++) {
                int nextRow = cur[0] + dx[i];
                int nextCol = cur[1] + dy[i];

                if(0<=nextRow && nextRow<N && 0<=nextCol && nextCol<M) {
                    if(dis[nextRow][nextCol] > dis[cur[0]][cur[1]] + 1) {
                        dis[nextRow][nextCol] = dis[cur[0]][cur[1]] + 1;
                        q.add(new int[] {nextRow, nextCol});
                        answer = Math.max(answer, dis[nextRow][nextCol]);

                    }
                }
                
                
            }
        }
        System.out.println(answer);
    }

}
