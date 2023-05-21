package SWEA;

import java.io.*;

public class swea_1215 {
    static char[][] map = new char[8][8]; // 8*8 배열 생성
    static int len;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        for (int t = 1; t <= 10; t++) {
             
            len = Integer.parseInt(br.readLine()); // 찾아야하는 회문의 길이

            // 입력받기
            for (int i = 0; i < 8; i++) {
                map[i] = br.readLine().toCharArray(); 
            }

            int answer = Find();

            System.out.printf("#%d %d\n", t, answer);
        }
    }

    public static int Find() {

        int ans =0;

        // 가로줄 회문 찾기
        for(int i=0; i<8; i++) {
            StringBuffer rowSb = new StringBuffer();
            StringBuffer colSb = new StringBuffer();
            
            for(int j=0; j<8; j++) {
                rowSb.append(map[i][j]);
                colSb.append(map[j][i]);

                // len보다 길면 맨앞 문자 빼기
                if(rowSb.length() > len) {
                    rowSb.delete(0, 1); 
                }
                if(colSb.length() > len) {
                    colSb.delete(0, 1); 
                }

                // len과 회문을 만족할때
                if(rowSb.length() == len && palindrome(rowSb)) {
                    ans++;
                }
                if(colSb.length() == len && palindrome(colSb)) {
                    ans++;
                }
            }
        }

        return ans;

    }

    public static boolean palindrome(StringBuffer sb) {
        String str1 = sb.toString();
        String str2 = sb.reverse().toString();
		sb.reverse();
        
        if (str1.equals(str2)) {
            return true;
        }
        return false;
    }
}
