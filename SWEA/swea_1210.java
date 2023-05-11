package SWEA;

import java.util.*;
import java.io.*;

public class swea_1210 {

    static int[] dx = {0,0,-1}; //좌,우,상
    static int[] dy = {-1,1,0}; //좌,우,상

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=10; i++) {
            int num = Integer.parseInt(br.readLine());

            //초기화
            int[][] arr = new int[100][100];
            int arriveX = 0;
            int arriveY = 0;

            //입력받기
            for(int j=0; j<100; j++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                for(int k=0; k<100; k++) {
                    arr[j][k] = Integer.parseInt(str.nextToken());

                    if(arr[j][k] == 2) {
                        arriveX = j;
                        arriveY = k;
                    }
                }
            }


            

            //경로 찾기
            while(arriveX!=0) {

                for(int n=0; n<3; n++) {

                    int nx = arriveX + dx[n];
                    int ny = arriveY + dy[n];

                    // 다음 방문할 좌표값이 1이고 범위내에 있을때
                    if(arr[nx][ny]==1 && 0<=nx && nx<100 && 0<=ny && ny<100) {
                        arr[arriveX][arriveY]=0; //현재 좌표 0으로 바꾸기
                        arriveX = nx;
                        arriveY = ny;
                    }
                }    
                    
                
            }
            sb.append("#").append(num).append(" ").append(arriveY).append("\n");
            
        }

        //정답 출력
        System.out.println(sb);

    }
    
}
