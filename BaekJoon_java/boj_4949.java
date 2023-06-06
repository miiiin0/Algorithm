package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            // 다음 문장 받기
            String str = br.readLine();
            if(str.equals(".")) {
                break;
            }

            sb.append(solve(str)).append('\n');
        }

        System.out.println(sb);
        
    }

    public static String solve(String str) {

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            //여는 괄호일때
            if(str.charAt(i)=='(' || str.charAt(i)=='[') {
                stack.push(str.charAt(i));
            }

            //닫는 괄호일때
            else if(str.charAt(i)==')') {
                if(stack.empty() || stack.peek() != '(') {
                    return "no";
                }
                else {
                    stack.pop();
                }
            }
            //닫는 괄호일때
            else if(str.charAt(i)==']') {
                if(stack.empty() || stack.peek() != '[') {
                    return "no";
                }
                else {
                    stack.pop();
                }
            }
        }

        if(stack.empty()) {
			return "yes";
		}
		else {
			return "no";
		}
    }
}
