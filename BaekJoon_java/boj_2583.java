package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_2583 {
    static int m;
    static int n;
    static int k;

    static int[][] graph;
    static boolean[][] visited;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        m = Integer.parseInt(str.nextToken()); //5
        n = Integer.parseInt(str.nextToken()); //7 
        k = Integer.parseInt(str.nextToken()); //3

        graph = new int[m][n];
        visited = new boolean[m][n];
        
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i=0; i<k; i++) {
            str = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(str.nextToken()); //0
            int y1 = Integer.parseInt(str.nextToken()); //2
            int x2 = Integer.parseInt(str.nextToken()); //4
            int y2 = Integer.parseInt(str.nextToken()); //4

            //그래프에 표시하기
            for(int x=x1; x<x2; x++) {
                for(int y=y1; y<y2; y++) {
                    graph[y][x] = 1; //어레이는 왼쪽 위에서 시작하기 때문에
                }
            }
        }

        // bfs를 이용하여 면적 구하기
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && graph[i][j]==0) { //방문한적 없고 직사각형 내부 좌표가 아닐때
                    int data = bfs(i, j); //해당 좌표 bfs함수로 보내기
                    list.add(data); //list에 면적의 넓이 넣기
                }
            }
        }

        //결과 출력
        StringBuilder sb = new StringBuilder();
        Collections.sort(list); //list를 오름차순으로 sort하기
        sb.append(list.size() + "\n");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) + " ");
        }
        System.out.print(sb);
    }

    //BFS 함수
    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visited[x][y] = true;
        int cnt = 1;

        while(!q.isEmpty()) {
            int[] curData = q.poll();
            int curX = curData[0];
            int curY = curData[1];

            for(int i=0; i<4; i++){
                //현재 좌표에서 상우하좌로 움직여 다음 좌표 구하기
                // dx = {0,1,0,-1}  
                // dy = {1,0,-1,0}
                int nextX = curX + dx[i]; //다음 x좌표
                int nextY = curY + dy[i]; //다음 y좌표

                if(0<=nextX && nextX<m && 0<=nextY && nextY<n) {
                    //방문한적 없고 직사각형 내부 좌표가 아닐때
                    if(!visited[nextX][nextY] && graph[nextX][nextY]==0) { 
                        visited[nextX][nextY] = true;
                        q.offer(new int[] {nextX, nextY}); //큐에 다음좌표를 넣어서 다음 while문에서 그 좌표를 확인할 수 있게 함 (재귀)
                        cnt++; //면적 +1 해주기
                    }
                }
            }
        }

        return cnt;
    }
}
