package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); //문서의 개수
            int m = Integer.parseInt(st.nextToken()); //궁금한 문서의 현재 위치

            Queue<int[]> q = new LinkedList<>(); //문서번호, 우선순위 저장
            
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                q.add(new int[] {j, Integer.parseInt(st.nextToken())});
                
            }
            
            int cnt = 0;
            while(true) {
                int[] now = q.poll(); //가장 앞에 있는 문서정보
                boolean check = true;

                for(int temp[]: q) {
                    if(now[1] < temp[1]) {
                        check = false;
                        break;
                    }
                }

                if(check) {
                    cnt++;
                    if(now[0] == m) {
                        break;
                    }
                }
                else {
                    q.add(now); //뒤로 보내기
                }
            }
            
            System.out.println(cnt);

        }

    }
}
