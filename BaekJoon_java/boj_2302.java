package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //좌석 개수
        int M = Integer.parseInt(br.readLine()); //고정석 개수 (VIP)

        int[] arr = new int[41]; //이거 처음에 new int[N+1]로 했더니 (ArrayIndexOutOfBounds)에러뜸..
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        for(int i=3; i<=N; i++) {
            arr[i] = arr[i-2] + arr[i-1];
        }
    
        int prev = 0;
        long answer = 1;
        for(int i=0; i<M; i++) {
            int vipNum = Integer.parseInt(br.readLine());
            if(vipNum!=0) {
                answer *= arr[vipNum-prev-1];
                prev = vipNum;
            }
        }
        //마지막 vip 좌석 ~ 좌석 끝
        answer *= arr[N-prev];

        System.out.println(answer);
    
    }
}
