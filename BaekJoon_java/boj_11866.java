package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
			q.add(i);
		}

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while(!q.isEmpty()) {
            for(int i=1; i<k; i++) {
                int temp = q.poll(); //맨앞 값 빼기
                q.offer(temp); //뒤로 보내기
            }
            sb.append(q.poll()+", ");
        }


        //마지막 두문자 제거 "," & " "
        sb.deleteCharAt(sb.length() - 2);
        sb.deleteCharAt(sb.length() - 1); 
        sb.append(">");

        System.out.print(sb);
    }
}
