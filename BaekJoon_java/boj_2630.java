package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_2630 {
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int white=0, blue=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check(0, 0, n);


        System.out.println(white);
        System.out.println(blue);
        
    }

    public static void check(int r, int c, int size) {
        int color = map[r][c];

        for(int i=r; i<r+size; i++) {
            for(int j=c; j<c+size; j++) {
                if(map[i][j] != color) {
                    check(r, c, size/2);
                    check(r+size/2, c, size/2);
                    check(r, c+size/2, size/2);
                    check(r+size/2, c+size/2, size/2);
                    return;
                }
            }
        }

        if(color==1) {
            blue++;
        }
        else if(color==0) {
            white++;
        }
        

    }
}
