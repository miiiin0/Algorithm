package SWEA;

import java.util.*;
import java.io.*;

public class swea_5432 {
    public static void main(String[] args) throws IOException {
       
        Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
            int answer = 0, cnt = 0;
			String s = sc.next();

            for(int i=0; i<s.length(); i++) {
                //레이저 확인
                if(s.charAt(i) == '(' && s.charAt(i + 1) == ')') { // 레이저가 나오면 반으로 가른다.(현재 있는 막대들의 개수만큼 증가된다.)
					answer += cnt;
					i++;
				} 
                //막대 추가
                else if(s.charAt(i) == '(') {
                    cnt++;
                }
                //막대 끝
                else {
                    cnt--;
                    answer++;
                }
            }

            System.out.println("#" + t + " " + answer);
        }

        sc.close();
    }
}
