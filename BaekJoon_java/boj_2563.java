package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_2563 {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[100][100];
        int answer = 0;

        int caseNum = Integer.parseInt(br.readLine());
        
        for(int t=0; t<caseNum; t++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(str.nextToken());
            int y = Integer.parseInt(str.nextToken());

            for(int i=x; i<x+10; i++) {
                for(int j=y; j<y+10; j++) {
                    if(map[j][i] == 0) {
                        answer++;
                        map[j][i] = 1;
                    }
                
                }
            }
        }
        
       
        System.out.println(answer);
    }
}
