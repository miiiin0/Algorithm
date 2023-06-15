package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); 

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine()); 

            if(num == 0) {
                if(pq.size()==0) {
                    sb.append(0+"\n");

                } else {
                    sb.append(pq.poll()+"\n");
                }

            }
            else {
                pq.add(num);
            }
        }

        System.out.println(sb);

    }
}
