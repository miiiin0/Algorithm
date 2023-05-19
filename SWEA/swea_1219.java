package SWEA;

import java.util.*;
import java.io.*;

public class swea_1219 {
    static int[] arr1;
    static int[] arr2;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        for(int t=1; t<=10; t++) {
            arr1 = new int[100];
            arr2 = new int[100];
            answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int caseNum = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            //간선 저장하기
            for(int i=0; i<edge; i++) {
                
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());

                if(arr1[n1]==0) {
                    arr1[n1] = n2;
                } else {
                    arr2[n1] = n2;
                }
                
            }

            BFS();

            System.out.println("#"+caseNum+" "+answer);
        }

    }

    public static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0); //A(0)에서 시작

        while(!queue.isEmpty()) {
            
            int node = queue.poll();

            if(arr1[node]==99 || arr2[node]==99) {
                answer = 1;
                break;
            }
            
            if(arr1[node]!=0) {
                queue.offer(arr1[node]);
            }
            if(arr2[node]!=0) {
                queue.offer(arr2[node]);
            }
            
            
             
        }
    }
}
