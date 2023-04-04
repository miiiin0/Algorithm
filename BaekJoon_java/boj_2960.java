//에라토스테네스의 체

package BaekJoon_java; 

import java.util.*;
import java.io.*;

public class boj_2960 {
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(str.nextToken());
        int K = Integer.parseInt(str.nextToken());


        for(int p=2; p<=N; p++) {

            //이미 지운 숫자인지 확인
            if(q.contains(p) == true) { 
                continue;
            }

            else {
                q.add(p); //숫자 지우기 (큐에 넣기)

                //배수 지우기
                for(int i=p*2; i<=N; i+=p) {

                    //이미 지운 숫자인지 확인
                    if(q.contains(i) == true) { 
                        continue;
                    }

                    else {
                        q.add(i); //숫자 지우기 (큐에 넣기)
                    }
                }
            }
            
        }

        for(int i=1; i<=N; i++) {

            // K번째 지워진 수인지 확인
            if(i == K) { 
                System.out.print(q.poll());  
            }

            else {
                q.poll();
            }
        	
        }
    }

}
