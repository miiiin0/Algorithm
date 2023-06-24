package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //국가의 수
            int[][] map = new int[N+1][N+1];
            int M = Integer.parseInt(st.nextToken()); //비행기의 종류

            for(int j=0; j<M; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
                map[y][x] = 1;
            }
            
            // 입력값이 항상 연결 그래프이기 때문에
            // 결국은 '나라수-1'만큼의 비행을 하면
            // 모든 나라를 여행할 수 있다
            System.out.println(N-1);
        }
        
    }
}
