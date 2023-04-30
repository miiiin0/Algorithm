package Programmers_java;

import java.util.*;

class Solution {
    static int[][] graph;

    public int solution(int n, int[][] wires) {
        int answer = n;
        graph = new int[n+1][n+1];
        
        for(int i=0; i<wires.length; i++) {
            graph[wires[i][0]][wires[i][1]] = 1;
            graph[wires[i][1]][wires[i][0]] = 1;
        }

        for(int i=0; i<wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];

            graph[a][b]=0;
            graph[b][a]=0;

            //BFS
            answer = Math.min(answer, bfs(n, a));

            graph[a][b]=1;
            graph[b][a]=1;
        }

        //그래프 확인 
        // for(int i=0; i<=wires.length; i++) {
        //     for(int j=0; j<=wires.length; j++) {
        //         System.out.print(graph[i][j]);

        //     }
        //     System.out.println();
        // }

        return answer;
    }

    public int bfs(int n, int start) {
        int cnt=0;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            cnt++;
            
            for(int i=1; i<=n; i++) {
                if(!visited[i] && graph[node][i]==1) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }

        }

        return Math.abs(n-2*cnt);
    }
}
