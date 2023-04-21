package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_2169 {
    static int N, M;
    static int[][] graph;
    static boolean[][] visited;

    static int[] dx = {-1,1,0};
    static int[] dy = {0,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken()); //5
        M = Integer.parseInt(str.nextToken()); //5

        graph = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=1; i<=N; i++) {
            str = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                graph[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        // 그래프 확인
        // for(int i=0; i<=N; i++) {
        //     for(int j=0; j<=M; j++) {
        //         System.out.print(graph[i][j]);
        //     }
        //     System.out.println();
        // }

    }


    public static void DFS() {

    }
}
