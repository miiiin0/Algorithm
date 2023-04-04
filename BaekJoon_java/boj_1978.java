//소수 찾기

package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine());
        int num;
        int result=0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<caseNum; i++) {
            num = Integer.parseInt(st.nextToken());
            for(int j=2; j<=num; j++) {
                if(j==num) {
                    result++;
                }
                else if (num%j == 0) {
                    break;
                }

            }
        }
        System.out.println(result);
    }
}
