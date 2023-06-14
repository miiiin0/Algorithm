package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());


        int a3 = (a1*b2) + (b1*a2);
        int b3 = b1*b2;

        int gcd = GCD(a3, b3);
        // gcd=1 이면 a3과 b3는 서로소
        System.out.println(a3/gcd+" "+b3/gcd);
        
    }

    public static int GCD(int a, int b) {
        if(b==0)
            return a;
        return GCD(b, a%b);
    }
}
