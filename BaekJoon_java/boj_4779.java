package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_4779 {

    static char c[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null) {
            int n = Integer.parseInt(str);
            int N = (int)Math.pow(3,n);
            c = new char[N];
            
            for(int i=0; i<N; i++) {
                c[i] = '-';
            }

            dfs(0, N);

            StringBuilder sb = new StringBuilder();

            for(int i=0; i<N; i++) {
                //System.out.print(c[i]); <- 이거 사용하면 시간초과
                sb.append(c[i]);
            }
            System.out.println(sb);
        }
    }
    public static void dfs(int start, int length) {
        //이미 다 나누어진 상태이므로 리턴
        if(length<3) {
            return;
        }
        //중간부분 공백으로 바꾸기
        for(int i=start+length/3; i<start+(length/3)*2; i++) {
            c[i] = ' ';
        }
        //앞부분
        dfs(start, length/3);
        //뒷부분
        dfs(start+(length/3)*2, length/3);

    }
}
