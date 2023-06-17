package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int sum = 0;
        // 0 ~ x-1번째까지 합 구하기
        for(int i=0; i<x; i++) {
            sum += arr[i];
        }

        int maxVisitor = sum;
        int cnt = 1;

        // 가장 첫번째 수(왼쪽)를 빼고
        // x번째 수(오른쪽)를 추가하기
        for(int i=x; i<n; i++) {
            sum = sum - arr[i-x] + arr[i];

            if(maxVisitor < sum) {
                maxVisitor = sum;
                cnt = 1;
            } else if(maxVisitor == sum) {
                cnt++;
            }

        }

        if(maxVisitor == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxVisitor);
            System.out.println(cnt);
        }
        
    }
}
