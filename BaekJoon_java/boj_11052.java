package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_11052 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int card = Integer.parseInt(br.readLine()); //민규가 구매하려고 하는 카드의 개수
        arr = new int[card+1];
        int[] dp = new int[card+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=card; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        dp[1] = arr[1];
        dp[2] = Math.max(arr[2], arr[1]+arr[1]);

        // for(int i=3; i<=card; i++) {
        //     dp[i] = Math.max(dp[i], dp[card-i]+arr[i]);
            
        // }
        for (int i = 3; i <= card; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + arr[j]);
            }
        }
        
        System.out.println(dp[card]);
        
    }
    
}
