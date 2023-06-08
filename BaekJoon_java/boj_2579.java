package BaekJoon_java;

import java.io.*;

public class boj_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }
    
        for(int i=1; i<=n; i++) {
            if(i==1) 
                dp[1] = stair[1];
            else if(i==2)
                dp[2] = stair[1] + stair[2];
            else if(i==3)
                dp[3] = Math.max(stair[1], stair[2]) + stair[3];
            else
                dp[i] = Math.max(dp[i-3] + stair[i-1], dp[i-2]) + stair[i];
            
        }

        System.out.println(dp[n]);
    }
}
