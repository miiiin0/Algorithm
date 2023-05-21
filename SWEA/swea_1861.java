package SWEA;

import java.io.*;
import java.util.*;

public class swea_1861 {

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int[][] arr;
    static int N;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine());
        
        for(int t=1; t<=caseNum; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];

            //입력받기
            for(int i=0; i<N; i++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(str.nextToken());
                }
            }


            //모든 경우의 수 계산해야 함
            int maxCnt = 0;
            int answer = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    cnt=1;
                    DFS(i, j, 1);

                    if(maxCnt < cnt) {
                        maxCnt = cnt;
                        answer = arr[i][j];
                    }
                    if(maxCnt == cnt && answer>arr[i][j]) {
                        maxCnt = cnt;
                        answer = arr[i][j];
                    }
                    
                }
            }


            System.out.println("#"+t+" "+answer+" "+maxCnt);
        }
        
    }

    public static void DFS(int i, int j, int depth) {
        

        for(int k=0; k<4; k++) {
            int nextX = i + dr[k];
            int nextY = j + dc[k];
            
            
            if(0<=nextX && nextX<N && 0<=nextY && nextY<N) {
                if(arr[nextX][nextY] == arr[i][j]+1) {
                    cnt++;
                    DFS(nextX, nextY, depth+1);
                }
            }

        }

    }
}
