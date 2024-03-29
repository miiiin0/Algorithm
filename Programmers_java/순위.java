package Programmers_java;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] graph = new boolean[n+1][n+1];

        for(int i=0; i<results.length; i++) {
            graph[results[i][0]][results[i][1]] = true;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                for(int k=1; k<=n; k++) {
                    if(graph[j][i] && graph[i][k]) {
                        graph[j][k] = true;
                    }
                }
            }
        }

        for(int i=1; i<=n; i++) {
            int cnt=0;

            for(int j=1; j<=n; j++) {
                // i:j 의 경기결과를 알고 있을때
                if(graph[i][j] || graph[j][i])
                    cnt++;
            }
            
            // 경기결과==n-1 라면, 순위 확정할 수 있음
            if(cnt==n-1)
                answer++;
        }

        return answer;
    }
}
