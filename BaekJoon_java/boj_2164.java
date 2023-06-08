package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            q.add(i);
        }

        while(q.size()>1) {
            for(int i=0; i<2; i++) {
                if(i==0) {
                    q.poll();
                }
                else if(i==1) {
                    int temp = q.poll();
                    q.add(temp);
                }
            }
        }
        System.out.println(q.poll());

    }
}
