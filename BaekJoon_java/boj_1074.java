package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_1074 {
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int N = (int)Math.pow(2,n);
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        find(N, r, c);
        System.out.println(cnt);
    }

    // 1 2
    // 3 4
    static void find(int size, int r, int c) {
        if(size == 1)
            return;

        //1
        if(r<size/2 && c<size/2) {
            find(size/2, r, c);
        }
        //2
        else if(r<size/2 && c>=size/2) {
            //1사분면에 해당하는 만큼 cnt에 더해줌
            //(한 사분면의 크기: 전체 배열 크기의 4등분)
            cnt += size*size/4; 
            find(size/2, r, c-size/2);
        }
        //3
        else if(r>=size/2 && c<size/2) {
            cnt += (size*size/4)*2;
            find(size/2, r-size/2, c);
        }
        //4
        else {
            cnt += (size*size/4)*3;
            find(size/2, r-size/2, c-size/2);
        }

    }
}
