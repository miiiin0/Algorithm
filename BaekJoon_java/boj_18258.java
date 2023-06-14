package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_18258 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        StringBuffer sb = new StringBuffer();
        int back = 0;

        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            
            if(str.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                back = num;
                q.offer(num);
            }
            else if(str.equals("pop")) {
                if(q.size()==0) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(q.poll()).append("\n");
                }
            }
            else if(str.equals("front")) {
                if(q.size()==0) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(q.peek()).append("\n");
                }

            }
            else if(str.equals("back")) {
                if(q.size()==0) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(back).append("\n");
                }
            }
            else if(str.equals("size")) {
                sb.append(q.size()).append("\n");
            }
            else if(str.equals("empty")) {
                if(q.size()==0) {
                    sb.append(1).append("\n");
                }
                else {
                    sb.append(0).append("\n");
                }

            }
        }
        System.out.println(sb);
    }
}
