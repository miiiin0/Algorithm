package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-"); // 빼기를 기준으로 분리
        
        int answer = Integer.MAX_VALUE;

        while(st.hasMoreTokens()) {
            int sum = 0;

            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+"); // 더하기를 기준으로 분리
            while(st2.hasMoreTokens()) {
                sum += Integer.parseInt(st2.nextToken());
            }

            if(answer == Integer.MAX_VALUE) {
                answer = sum;
            }
            else {
                answer -= sum;
            }
        }
        
        System.out.println(answer);
        
        
    }
}
