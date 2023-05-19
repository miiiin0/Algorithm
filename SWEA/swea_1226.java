package SWEA;

import java.util.*;
import java.io.*;

public class swea_1226 {
    static int[][] map;
    static int[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        for(int t=1; t<=10; t++) {
            int caseNum = Integer.parseInt(br.readLine());
            map = new int[16][16];
            visited = new int[16][16];
            answer = 0;

            //입력받기
            for(int i=0; i<16; i++) {
                String line = br.readLine();
                for(int j=0; j<16; j++) {
                    if(i==0 || i==15 || j==0 || j==15) {
                        visited[i][j] = 1;
                    }
                    map[i][j] = Character.getNumericValue(line.charAt(j));

                    
                }
            }

            BFS();
            
            
            System.out.println("#"+caseNum+" "+answer);
        
        }
    }

    public static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {1, 1});
        visited[1][1]=1;


        while(!queue.isEmpty()) {
            int[] curData = queue.poll();
            int curR = curData[0];
            int curC = curData[1];

            for(int i=0; i<4; i++) {
                int nextR = curR + dx[i];
                int nextC = curC + dy[i];

                //다음 좌표가 범위내에 있다면
                if(0<=nextR && nextR<16 && 0<=nextC && nextC<16) {
                    //다음 좌표로 움직일 수 있다면
                    if(visited[nextR][nextC]==0 && map[nextR][nextC]==0) {
                        queue.offer(new int[] {nextR, nextC});
                        visited[nextR][nextC]=1;
                        
                    }
                    if(map[nextR][nextC]==3) {
                        answer = 1;
                        break;
                    }

                }
            }

        }

    }
}
