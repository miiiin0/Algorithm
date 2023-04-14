package Programmers_java;

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        //최소힙 선언
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }
        
        while(queue.peek() < K) {
            if (queue.size() == 1)
                return -1;
            queue.add(queue.poll() + queue.poll() * 2);
            answer++;
        }

        return answer;
    }
}