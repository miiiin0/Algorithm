package SWEA;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class swea_15758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(str.nextToken());

        StringBuilder sb = new StringBuilder();
        

        for(int i=1; i<=num; i++) {
            String answer = "no";
            str = new StringTokenizer(br.readLine());
            String a = str.nextToken();
            String b = str.nextToken();

            //최소공배수 구하기
            BigInteger alength = BigInteger.valueOf(a.length());
            BigInteger blength = BigInteger.valueOf(b.length());
            int gcd = alength.gcd(blength).intValue();
            int lcm = (a.length() * b.length()) / gcd;

            //같은 길이(최소공배수만큼)를 갖도록 A, B 문자열 늘리기
            String A = a;
            String B = b;
            while(A.length()!=lcm) {
                A+=a;
            }
            while(B.length()!=lcm) {
                B+=b;
            }

            if(A.equals(B)) {
                answer="yes";
            }

            sb.append("#"+i+" "+answer+"\n");
        }

        System.out.print(sb);

    }
}
