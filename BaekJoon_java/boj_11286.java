package BaekJoon_java;

import java.io.*;
import java.util.*;

public class boj_11286 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        //문제에서 입력되눈 정수는 -2의 31승 ~ +2의 31승 => int범위
        // 우선순위 큐을 Integer타입으로 설정
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) ->{
            int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);

            // 절댓값이 같은 경우 
			if(abs1==abs2)  {
                //o1이 더 크다면 양수 반환 -> o1과 o2의 자리를 바꾼다
                //o1이 더 작다면 음수 반환 -> 지금의 자리를 유지한다
                return o1 > o2 ? 1:-1;
            }
            //절댓값이 같지 않은 경우 절댓값이 작은 순서로 정렬한다
            //'abs1 - abs2'가 양수라면 o1의 절댓값이 더 큰 경우이다 -> o2, o1순으로 정렬
            //'abs1 - abs2'가 음수라면 o2의 절대값이 더 큰 경우이다 -> o1, o2 유지
			return abs1 - abs2;

        });


        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            

            //0이라면 배열에서 절댓값이 가장 작은 값을 출력
            if(num == 0) {
                //배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력
                if(pq.size() == 0) {
                    sb.append(0+"\n");
                }
                else {
                    int removeNum = pq.poll();
                    //절댓값이 가장 작은 값이 여러개일 경우 가장 작은 수 출력
                    sb.append(removeNum+"\n");
                }
                

            }

            //0이 아니라면 배열에 값 추가
            else {
                pq.add(num);
            }
        }

        System.out.println(sb);
        
    }
}
