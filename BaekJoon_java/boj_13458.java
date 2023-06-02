package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_13458 {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //시험장 개수
        
        // 각 시험장에 있는 응시자 수 
        int[] arr = new int[N];
        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }
        
        str = new StringTokenizer(br.readLine());
        
        int B = Integer.parseInt(str.nextToken()); //총감독관이 감시할 수 있는 응시자 수
        int C = Integer.parseInt(str.nextToken()); //부감독관이 감시할 수 있는 응시자 수

        long answer = 0; 
        for(int i=0; i<N; i++) {
            arr[i] -= B;
            if(arr[i]<=0) {
                answer++;
                continue;
            } 
            long temp = (long)Math.ceil((double)arr[i]/(double)C);
            answer = answer + (1+temp);
        }
        System.out.println(answer);
    }
}
