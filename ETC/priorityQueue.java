package ETC;

import java.util.*;

public class priorityQueue {
    public static void main(String[] args) {

        //우선순위 큐 설정
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			// 파라미터로 받은 o1, o2는 기본적으로 object 형이기 때문에
			// string으로 변환 후, int형으로 다시 변환
            int x = Integer.parseInt(o1.toString());
            int y = Integer.parseInt(o2.toString());

            // x, y가 들어왔을 때, x(o1)에 높은 우선순위를 주고 싶다면 음수값 return
            if(x % 2 == y % 2) {
                            // 오름차순 정렬
                    return x - y;
            } else {
                if(x % 2 == 1 && y % 2 == 0) {
                                    // 홀수가 우선순위가 더 높으므로 음수 리턴
                            return -1;
                } else {
                    return 1;
                }
            }
        });

        //입력
        for(int i = 1 ; i <= 10 ; i ++) {
            pq.add(i);
        }

        //출력
        for(int i = 1 ; i <= 10 ; i ++) {
            System.out.print(pq.poll() + " ");
        }



    }
}
