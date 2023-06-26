package BaekJoon_java;

import java.io.*;

public class boj_3085 {
    static int N;
    static char[][] map;
    static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<N; j++) {
				map[i][j] = line.charAt(j);
			}
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                // 세로 (아래에 있는 값이랑 swap)
                if(i+1 < N) {
                    char temp = map[i][j];
                    map[i][j] = map[i+1][j];
                    map[i+1][j] = temp;

                    max = Math.max(max, countRow(i));
					max = Math.max(max, countRow(i + 1));
					max = Math.max(max, countCol(j));

                    
                    temp = map[i][j];
                    map[i][j] = map[i+1][j];
                    map[i+1][j] = temp;
                }

                // 가로 (오른쪽에 있는 값이랑 swap)
                if(j+1 < N) {
                    char temp = map[i][j];
                    map[i][j] = map[i][j+1];
                    map[i][j+1] = temp;

                    max = Math.max(max, countRow(i));
					max = Math.max(max, countCol(j));
					max = Math.max(max, countCol(j + 1));

                    
                    temp = map[i][j];
                    map[i][j] = map[i][j+1];
                    map[i][j+1] = temp;
                }
            }
        }

        System.out.println(max);
    }

    public static int countRow(int a) {
        int ans = 1;
        int temp = 1;

        //해당 줄의 첫 문자(0)를 ch에 넣고
        //for문에서는 인덱스 1부터 탐색
        char ch = map[a][0];

        for(int i=1; i<N; i++) {
            if(map[a][i] != ch) {
                ch = map[a][i]; 
                //ch값이 바뀌었기 때문에
                //지금까지 카운트한 temp값이랑 ans값중에 큰 값으로 ans값 업데이트
                ans = Math.max(ans, temp);  
                temp = 1;

            }
            else {
                temp++;
            }
        }

        return Math.max(ans, temp);
    }

    public static int countCol(int b) {
        int ans = 1;
        int temp = 1;

        char ch = map[0][b]; 

        for(int i=1; i<N; i++) {
            if(map[i][b] != ch) {
                ch = map[i][b]; 
                ans = Math.max(ans, temp);
                temp = 1;
            }
            else {
                temp++;
            }
        }

        return Math.max(ans, temp);
    }

}
