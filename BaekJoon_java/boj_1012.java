package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_1012 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int row;
    static int col;
    static int[][] arr;
    static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int t=0; t<testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken()); //가로
            col = Integer.parseInt(st.nextToken()); //세로
            arr = new int[row][col];
            visited = new boolean[row][col];

            int cnt = Integer.parseInt(st.nextToken()); //배추가 심어져 있는 위치의 개수

            for(int i=0; i<cnt; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }

            int answer = 0;
            for(int i=0; i<row; i++) {
                for(int j=0; j<col; j++) {
                    if(arr[i][j] == 1 && !visited[i][j]) {
                        answer += BFS(i, j);
                    }
                }
            }
            System.out.println(answer);

        }
        

    }

    public static int BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            int[] curData = q.poll();
            int curX = curData[0];
            int curY = curData[1];

            for(int i=0; i<4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(0<=nextX && nextX<row && 0<=nextY && nextY<col) {
                    if(arr[nextX][nextY]==1 && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        q.add(new int[] {nextX, nextY});
                    }
                }

                
            }
        }

        return 1;
    }
}