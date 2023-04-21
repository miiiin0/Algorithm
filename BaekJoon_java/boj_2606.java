package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_2606 {
    
    static int[][] graph;
    static boolean[] visited;
    static int node;
    static int line;
    static int answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine()); //7
        line = Integer.parseInt(br.readLine()); //6

        graph = new int[node+1][node+1];
        visited = new boolean[node+1];
       

        for(int i=0; i<line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(str.nextToken());
            int end = Integer.parseInt(str.nextToken());

            //양방향 간선이므로
            graph[start][end] = 1;
            graph[end][start] = 1;
            
        }

        BFS(1);

        
        System.out.println(answer);
    }

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {

            start = queue.poll();

            for(int i = 1; i <= node; i++) {
				if(graph[start][i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
                    answer++;
				}
			}
        }
    }
}
