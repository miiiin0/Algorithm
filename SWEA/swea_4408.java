package SWEA;

import java.util.*;
import java.io.*;

public class swea_4408 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseNum = Integer.parseInt(br.readLine());
        for(int t=1; t<=caseNum; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] corridor = new int[201];
            int answer = 0; 
            
            for(int i=0; i<N; i++) {
                //입력받기
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = (Integer.parseInt(st.nextToken())+1)/2;
                int y = (Integer.parseInt(st.nextToken())+1)/2;

                //계산
                if(x<y) {
                    for(int k=x; k<=y; k++) {
                        corridor[k]++;
                    }
                } else {
                    for(int k=y; k<=x; k++) {
                        corridor[k]++;
                    }
                }
            }

            //corridor 배열의 최댓값이 총 걸리는 시간
            Arrays.sort(corridor);
            answer = corridor[200];
            
            

            //결과 출력
            System.out.println("#"+t+" "+answer);

        }
    }
}
