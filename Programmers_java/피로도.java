package Programmers_java;

// 모든 경우의 수를 확인해봐야 한다.
class Solution {
    static boolean[] visited;
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];

        DFS(dungeons, k, 0);

        return answer;
    }

    public void DFS(int[][] dungeons, int k, int depth) {

        for(int i=0; i<dungeons.length; i++) {

            // 현재 피로도(k)가 최소 필요 피로도보다 클때
            if(k>=dungeons[i][0] && !visited[i]) {
                visited[i] = true;
                DFS(dungeons, k-dungeons[i][1], depth+1);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, depth);
    }
}
