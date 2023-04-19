package Programmers_java;

import java.util.*;

class Solution {
    // ArrayList 두개 사용하여 2차원 배열 형태로 사용하기
    static ArrayList<ArrayList<Integer>> list= new ArrayList<>();
    static boolean visited[];

    public int solution(int n, int[][] edge) {
        int answer = 0;

        visited = new boolean[n+1];

        //n번 반복하여 ArrayList만들기
        for(int i=0; i<=n; i++) { 
            list.add(new ArrayList<>());
        }

        //양방향 그래프 표시 
        for(int i=0; i<edge.length; i++){
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }
        
        answer = bfs();
        return answer;
    }

    public static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int cnt = 0;
        int start = 0;

        while(!queue.isEmpty()) {
            start = queue.poll();
            for(int i : list.get(start)) {
                if(!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        return cnt;
    }
}

// 아직 미완성
