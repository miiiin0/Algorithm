package SWEA;

import java.util.*;
import java.io.*;

public class swea_2819 {
    static int[] dx = {-1, 1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1}; 
    static int[][] map;
    static HashSet<String> set;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine());

        for(int t=1; t<=caseNum; t++) {
            
            map = new int[4][4];
            set = new HashSet<>();

            //입력 받기
            for(int i=0; i<4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<4; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //모든 경우의 수를 다 구해야 함
            for(int i=0; i<4; i++) {
                for(int j=0; j<4; j++) {
                    DFS(i, j, 0, ""+map[i][j]);
                }
            }

            //결과 출력
            System.out.println("#"+t+" "+set.size());

        }

        
        
    }

    public static void DFS(int i, int j, int depth, String str) {
		
        if(depth==6) {
            set.add(str);
            return;
        }
		
		
		
		for(int k=0 ; k <4 ; k++) {
			int nextR = i + dx[k];
            int nextC = j + dy[k];

            if(0<=nextR && nextR<4 && 0<=nextC && nextC<4) {
                DFS(nextR, nextC, depth+1, str+map[nextR][nextC]);
            }

		}
		
	}
}
