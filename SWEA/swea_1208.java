package SWEA;

import java.util.*;
import java.io.*;

public class swea_1208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=1; i<=10; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            //덤프 횟수
            int cnt = Integer.parseInt(str.nextToken()); 

            //입력값 어레이에 넣기
            str = new StringTokenizer(br.readLine()," ", false);
            int[] arr = new int[100];
            int j=0;
            while(str.hasMoreTokens()) {
                arr[j] = Integer.parseInt(str.nextToken());
                j++;
            }

            //어레이넘버가 중요하진 않으니까
            //정렬해서 최대값, 최소값 구하기
            Arrays.sort(arr);
            while(cnt>0) {
                arr[0]++;
                arr[99]--;

                Arrays.sort(arr);
                cnt--;
            }
            

            System.out.println("#"+i+" "+(arr[99]-arr[0]));

        }
    }
}
