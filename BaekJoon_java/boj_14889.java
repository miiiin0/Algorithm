package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_14889 {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); 
        arr = new int[N][N];
        visited = new boolean[N];

        //입력받기
        for(int i=0; i<N; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }
        
        
        find(0,0);
        
        System.out.print(answer);
    }
    static void find(int depth, int idx) {
        if(depth == N/2) {
            compare();
            return;
        }

        //각 조합을 구하기 위해 find 함수 호출
        for(int i=idx; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                find(depth+1, i+1);
                visited[i] = false;
            }
        }
    }

    static void compare() {
        int start=0; 
        int link=0;
        for(int i=0; i<N; i++) {
            for(int j=i; j<N; j++) {
                if (visited[i] == true && visited[j] == true) {
                    start += arr[i][j];
                    start += arr[j][i];
                } else if (visited[i] == false && visited[j] == false) {
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }
        int val = Math.abs(start - link);
        answer = Math.min(val, answer);
    }
}
