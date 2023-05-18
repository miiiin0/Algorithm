package SWEA;

import java.util.*;
import java.io.*;

public class swea_1989 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int caseNum = sc.nextInt();

        for(int t=1; t<=caseNum; t++) {
            int answer = 0; 

            char[] input = sc.next().toCharArray();
            for(int i=0; i<input.length; i++) {
                //양쪽이 대칭이기 때문에 중간까지 온 것
                if(i == (input.length-1)/2) {
                    answer = 1;
                    break;
                }
                if(input[i] != input[input.length-1-i]) {
                    answer = 0;
                    break;
                }

            }

            System.out.println("#"+t+" "+answer);
        }

        sc.close();
    }
}
