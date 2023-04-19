package Programmers_java;

import java.util.*;

class Solution {
    static int[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public int solution(int[][] maps) {
        int answer = 0;

        visited = new int[maps.length][maps[0].length];

        bfs(maps, visited);
        
        answer = visited[maps.length - 1][maps[0].length - 1]; // 상대 팀 진영 좌표

        if (answer == 0) { // 상대 팀 진영에 도달하지 못한 경우
            answer = -1;
        }

        return answer;

        
    }


    public static void bfs(int[][] maps, int[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0}); //(0,0)에서 시작하니까
        visited[0][0] = 1;

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

                if(0<=nextX && nextX<maps.length && 0<=nextY && nextY<maps[0].length) {
                    //방문한적 없고 직사각형 내부 좌표가 아닐때
                    if(visited[nextX][nextY]==0 && maps[nextX][nextY]==1) { 
                        visited[nextX][nextY] = visited[curX][curY]+1;
                        q.offer(new int[] {nextX, nextY}); //큐에 다음좌표를 넣어서 다음 while문에서 그 좌표를 확인할 수 있게 함 (재귀)
                        
                    }
                }
            }
        }

    }
}
