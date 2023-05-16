package SWEA;

import java.io.*;

public class swea_15230 {

    static char[] alphabet = {'a','b', 'c', 'd', 'e', 'f','g', 'h', 'i', 'j', 'k', 'l', 'm',
    'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseNum = Integer.parseInt(br.readLine());

        for(int i=1; i<=caseNum; i++) {
            //입력값 받기
            String line = br.readLine();
            char[] arr = line.toCharArray();

            int answer = 0;
            for(int j=0; j<arr.length; j++) {
                if(arr[j]==alphabet[j]) {
                    answer++;
                } else {
                    break;
                }
            }

            

            //결과 출력
            System.out.println("#"+i+" "+answer);
        }
 
    }
    
}
