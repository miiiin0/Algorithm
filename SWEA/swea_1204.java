package SWEA;

import java.util.*;
import java.io.*;

public class swea_1204 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int caseTotal = sc.nextInt();

        for(int i=1; i<=caseTotal; i++) {
            int caseNum = sc.nextInt();
            
            //초기화
            int answer =0;
            int max =0;
            int[] arr = new int[101];

            //어레이에 점수 저장
            for(int k = 0; k < 1000; k++) {
                int score = sc.nextInt();
                arr[score]++;
            }

            for(int k = 0; k < 101; k++) {
                if(max<=arr[k]) {
                    max = arr[k];
                    answer = k;
                }

            }

            System.out.println("#"+caseNum+" "+answer);

        }
    }
}
