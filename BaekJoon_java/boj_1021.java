package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //큐의 크기
        int m = Integer.parseInt(st.nextToken()); //뽑아내려고 하는 수의 개수
        
        LinkedList<Integer> deque = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int answer = 0;
        for(int i=0; i<m; i++) {
            int next = Integer.parseInt(st.nextToken()); //뽑아야 하는 수
            
            // 덱에서 뽑고자 하는 숫자의 위치(index) 찾기 
			int target_idx = deque.indexOf(next);
            int half_idx = deque.size()/2;

            // 뽑아야 하는 수가 절반보다 작을때는
            // 앞에서 이동하는 것이 효율적임
            if(target_idx <= half_idx) {
                while(deque.getFirst() != next) {
                    deque.addLast(deque.removeFirst()); // 맨 앞 값 빼서 뒤로 넣기
                    answer++;
                }
            }
            // 뽑아야 하는 수가 절반보다 클때는
            // 뒤에서 이동하는 것이 효율적임
            else {
                while(deque.getFirst() != next) {
                    deque.addFirst(deque.removeLast()); // 맨 뒤 값 빼서 앞에 넣기
                    answer++;
                }
            }
            deque.removeFirst();

        }

        System.out.println(answer);

    }
}
