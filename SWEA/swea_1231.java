package SWEA;

import java.io.*;
import java.util.*;

public class swea_1231 {
    static int num;
    static char[] arr;
    static int answer;
    static StringBuffer sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        for(int i=1; i<=10; i++) {
            num = Integer.parseInt(br.readLine());
            arr = new char[num+1];
            sb = new StringBuffer();

            //입력값 받기
            for(int j=1; j<=num; j++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                str.nextToken();
                arr[j] = str.nextToken().charAt(0);
                
            }
            
            inOrder(1);

            System.out.println("#"+i+" "+sb.toString());
        }
    }
    static void inOrder(int idx) {
        if(idx>num)
            return;
        inOrder(2*idx);
        sb.append(arr[idx]);
        inOrder(2*idx+1);
    }
}
