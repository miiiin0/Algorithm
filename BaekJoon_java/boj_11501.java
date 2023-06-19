package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        //답은 부호있는 64bit 정수형으로 표현 가능하다.
        long[] ans = new long[t]; 

        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            //입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            long max = 0;
            // 뒤에서부터 탐색
            for(int k=n-1; k>=0; k--) {
                // 더 큰 금액으로 판매할 수 있을때 
                if(max < arr[k]) {
                    max = arr[k];
                } else { // 판 금액 - 산 금액
                    ans[i] += (max - arr[k]);
                }
            }

        
        }

        //결과 출력
        for(int i=0; i<t; i++) {
            System.out.println(ans[i]);
        }

    }
}
