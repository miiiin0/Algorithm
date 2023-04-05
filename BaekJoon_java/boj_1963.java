package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_1963 {
    static int caseNum;
    static boolean[] primeNum = new boolean[10000]; //false로 초기화됨
    static boolean[] check; //방문여부 체크
    static int[] cnt; //최소횟수 저장
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        findPrimeNumber(); //에라토스테네스의 체

        //입력 버퍼
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //공백 기준으로 문자열 자르기
        caseNum = Integer.parseInt(br.readLine());


        for(int i=0; i<caseNum; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());

            //하나의 case를 할때마다 check, cnt를 초기화해야 함
            check = new boolean[10000];
            cnt = new int[10000];

            if(a == b) {
                sb.append(0).append("\n");
                continue;
            } 

            bfs(a, b);
            
            if(!check[b]) {
                sb.append("Impossible").append("\n");
                
            } else {
                sb.append(cnt[b]).append("\n");
            }

        }

        System.out.println(sb);
    }

    // 에라토스테네스의 체를 이용하여 1~9999까지 소수 찾기
    public static void findPrimeNumber() {
        primeNum[0] = primeNum[1] = true; //0과 1은 소수가 아니기 때문에 true로 

        for(int i=2; i<10000; i++) { 
            if(primeNum[i] == false) {
                for(int j=i*2; j<10000; j+=i) {
                    primeNum[j] = true;
                }
            }
        }
    }

    public static void bfs(int a, int b) {
        Queue<Integer> q = new LinkedList<>();
        q.add(a); 
        check[a] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            // 최종 숫자 b까지 도달했을 때 bfs 종료
            if(cur == b) { 
                return;
            }

            // 1000의 자리, 100의 자리, 10의 자리, 1의 자리 각각 구하기
            int[] word = {cur/1000, (cur/100)%10, (cur/10)%10, cur%10}; 

            for(int i=0; i<4; i++) {
                for(int j=0; j<10; j++) {
                    if(i==0 && j==0) { //천의 자리는 0으로 바꿀 수 없기 때문에 
                        continue;
                    }

                    ///////// 다음 숫자 구하기 //////////
                    int temp = word[i]; 
                    word[i] = j; //word[i]을 j로 바꾸고 
                    int next = change(word); //change함수를 통해 다음 숫자 구하기
                    word[i] = temp; //현재 숫자 돌려놓기
                    

                    // 다음 숫자를 방문하지 않았고 소수일때
                    if(!check[next] && !primeNum[next]) { 
                        q.add(next); //큐에 넣기
                        check[next] = true; //방문여부 true로 바꾸기
                        cnt[next] = cnt[cur] + 1; 
                    }
                    
                }
            }
        }
    }

    // i자리 숫자를 j로 바꾼 어레이를 받아서 다음 숫자 구하기
    static int change(int[] arr) {
        int num = arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3];
        return num;
    }
}