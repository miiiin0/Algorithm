package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_2798 {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(str.nextToken());
        int[] arr = new int[N];
        int M = Integer.parseInt(str.nextToken());

        str = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        int max = 0; 

        for (int i = 0; i < N - 2; i++) {
            for (int j = i+1; j < N - 1; j++) {
                for (int k = j+1; k < N; k++) {
                    int sum = arr[i] + arr[j] + arr[k];  //세 수의 합
                    if (sum <= M) {  //합이 m보다 작으면 갱신할 수 있는지 확인
                        max = Math.max(max, sum);
                    }
                }
            }
        }

        System.out.print(max);
    }
}
