package Programmers_java;

import java.util.*;

class Solution {
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int time = 0;

        for(int i=0; i<truck_weights.length; i++) {
            int truck = truck_weights[i];

            while(true) {
                //큐가 비어있다 = 다리 위에 트럭이 없다 -> 다음 트럭 올리기 
                if(queue.isEmpty()) {
                    queue.add(truck);
                    sum+=truck;
                    time++;
                    break; //for문으로 나가기
                } 

                //다리에 올라갈 수 있는 최대 개수의 트럭이 있을때
                else if(queue.size() == bridge_length) {
                    sum-=queue.poll(); //1초뒤에 나갈 트럭 무게 빼주기
                }

                else {
                    //다음 트럭을 올려도 최대 무게보다 적을때
                    if(sum+truck<=weight) {
                        queue.add(truck);
                        sum+=truck;
                        time++;
                    } else {
                        queue.add(0);
                        time++;
                    }
                }
            }
            
        }

        return time+bridge_length;
    }
}
