package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //칭호개수
        int M = Integer.parseInt(st.nextToken()); //개수

        String[] name = new String[N];
        int[] power = new int[N];

        //칭호개수 입력받기
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            name[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            int level = Integer.parseInt(br.readLine());

            //이진탐색
            int start = 0;
            int last = N-1;

            while(start <= last) {
                int mid = (start+last) / 2;

                if(power[mid] < level) {
                    start = mid + 1; 
                } 
                else {
                    last = mid - 1;
                }
            }
            sb.append(name[start]+"\n");

        }

        System.out.println(sb);
    }
}
