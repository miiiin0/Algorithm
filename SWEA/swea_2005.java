package SWEA;

import java.util.*;
import java.io.*;

public class swea_2005 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int caseNum = sc.nextInt();

        for(int t=1; t<=caseNum; t++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];

            for(int i=0; i<N; i++) {
                for(int j=0; j<i+1; j++) {
                    //양끝일때
                    if(j==0 || j==i) {
                        arr[i][j]=1;
                    }

                    //가운데 숫자일때
                    else {
                        //어레이 인덱스가 범위내에 있을때
                        if(0<=i && i<N && 0<=j && j<N) {
                            arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                        }
                        
                    }
                }
            }



            //결과 출력
            System.out.println("#"+t);
            for(int i=0; i<N; i++) {
                for(int j=0; j<i+1; j++) {
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
        }


        


        sc.close();
    }
}
