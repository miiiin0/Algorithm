package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_1010 {

    private static final int[][] dp = new int[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());


        for(int t=0; t<testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            
            int m = Integer.parseInt(st.nextToken());
            

            System.out.println(combination(m, n));


        }
        
    }


    public static int combination(int m, int n) {
        // 이미 계산된 값일 경우
        if (dp[m][n] > 0)
        {
            return dp[m][n];
        }

        // 원소의 갯수가 조합의 갯수와 동일하거나 0일 경우
        else if (m == n || n == 0)
        {
            return dp[m][n] = 1;
        }
        
        // 일반적인 경우
        else
        {
            return dp[m][n] = combination(m - 1, n - 1) + combination(m - 1, n);
        }

    }
}
