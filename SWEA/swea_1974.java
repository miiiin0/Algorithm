package SWEA;

import java.util.*;
import java.io.*;

public class swea_1974 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int caseNum = Integer.parseInt(br.readLine());

        for(int t=1; t<=caseNum; t++) {
            int answer=1;
            int[][] arr = new int[9][9];

            // 입력받기
            for(int i=0; i<9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<9; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            //행 체크
            for(int i=0; i<9; i++) {
                int[] check = new int[10];
                for(int j=0; j<9; j++) {
                    check[arr[i][j]] = 1;
                }

                //1~9까지 있는지 확인
                for(int j=1; j<=9; j++) {
                    if(check[j]==0) {
                        answer = 0;
                        break;
                    }
                }
                
            }

            //열 체크
            for(int i=0; i<9; i++) {
                int[] check = new int[10];
                for(int j=0; j<9; j++) {
                    check[arr[j][i]] = 1;
                }

                //1~9까지 있는지 확인
                for(int j=1; j<=9; j++) {
                    if(check[j]==0) {
                        answer = 0;
                        break;
                    }
                }
                
            }


            //사각형 체크
            for(int i=0; i<7; i+=3) {
                for(int j=0; j<7; j+=3) {
                    int[] check = new int[10];

                    int rEnd = i+3; 
                    int cEnd = j+3; 

                    for(int r=i; r<rEnd; r++) {
                        for(int c=j; c<cEnd; c++) {
                            check[arr[r][c]] = 1;
                        }
                    }

                    //1~9까지 있는지 확인
                    for(int k=1; k<=9; k++) {
                        if(check[k]==0) {
                            answer = 0;
                            break;
                        }
                    }
                }

            }


            //결과 출력
            System.out.println("#"+t+" "+answer);
        }
    }
    
}
