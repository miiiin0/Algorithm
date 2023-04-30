package Programmers_java;

import java.util.*;

class Solution {
    // int[][]로 만들면 테스트8,9에서 메모리 초과가 뜬다.
    // boolean[][]을 사용하자.
    static boolean[][] graph;
    static boolean[] visited;

    public int solution(int n, int[][] edge) {
        int answer = 0;
        graph = new boolean[n+1][n+1];
        visited = new boolean[n+1];

        //양방향 그래프 표시 
        for(int i=0; i<edge.length; i++){
            graph[edge[i][0]][edge[i][1]] = true;
            graph[edge[i][1]][edge[i][0]] = true;
        }
        
        answer = bfs();
        return answer;
    }

    // queue 1
    // queue 2, 3
    // queue 4, 5, 6

    public static int bfs() {
        Queue<Integer> queue = new LinkedList<>();

        // 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return하는 문제이므로
        queue.add(1);
        visited[1] = true;

        int start = 0;
        int size = 0;

        while(!queue.isEmpty()) {
            size = queue.size(); //현재 큐 사이즈(=depth) 구하기

            for(int k=0; k<size; k++) {
                start = queue.poll();

                for(int i=0; i<graph.length; i++) {
                    if(!visited[i] && graph[start][i]) {
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }
            
        }

        return size;
    }
}

