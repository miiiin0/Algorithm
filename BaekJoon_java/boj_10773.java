package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<k; i++) {
            int next = Integer.parseInt(br.readLine());
            if(next == 0 ) {
                stack.pop();
            }
            else {
                stack.push(next);
            }
        }

        int answer = 0;
        while(!stack.empty()) {
            answer += stack.pop();
        }

        System.out.println(answer);

    }
}
