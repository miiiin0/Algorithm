package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int K = Integer.parseInt(st.nextToken()); //랜선 개수
        int N = Integer.parseInt(st.nextToken()); //필요한 랜선 개수

        int[] arr = new int[K+1];
        long min = 0; 
        long max = 0;

        for(int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            if(max < arr[i]) {
                max = arr[i];
            }
        }

        //입력 받는 랜선의 최대 길이 + 1
        max++;

        while(min < max) {
            long mid = (min+max) / 2;

            int cnt = 0; 

            for(int i=0; i<arr.length; i++) {
                cnt += (arr[i]/mid);
            }

            if(cnt < N) {
                max = mid;
            } else {
                min = mid + 1;
            }

        }
        System.out.println(min-1);
    }
}
