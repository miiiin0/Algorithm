package SWEA;

import java.util.*;

public class swea_1209 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        for(int i=1; i<=10; i++) {
            int[][] arr = new int[100][100];
            int caseNum = sc.nextInt();

            //어레이 저장
            for(int k=0; k<100; k++) {
                for(int j=0; j<100; j++) {
                    arr[k][j] = sc.nextInt();
                }
            }


            int sum1=0;
            int sum2=0;
            int sum3=0;
            int sum4=0;
            int answer=0;

            for(int k=0; k<100; k++) {
                sum1 = 0;
                sum2 = 0;
                sum3 += arr[k][k];
                sum4 += arr[k][99-k];

                for(int j=0; j<100; j++) {
                    sum1 += arr[k][j];
                    sum2 += arr[j][k];
                }

                answer = Math.max(answer, sum1);
                answer = Math.max(answer, sum2);
            }

            answer = Math.max(answer, sum3);
            answer = Math.max(answer, sum4);

            System.out.println("#"+caseNum+" "+answer);
        }

        sc.close();
    }
    
}
