package SWEA;

import java.util.*;
import java.io.*;

public class swea_2806 {
    static int N;
    static int[][] arr; // 퀸의 위치를 담는다. (arr[0]=1 -> (0,1)에 하나의 퀸이 있다.)
    static int answer;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int caseNum = sc.nextInt();

        for(int t=1; t<=caseNum; t++) {
            answer = 0;
            N = sc.nextInt();
            arr = new int[N][N];

            DFS(0);
            
            
            System.out.println("#"+t+" "+answer);
        }

        sc.close();
    }


    // cur = 현재 놓인 퀸 개수
    public static void DFS(int cur) {
        

        if(cur == N) {
            answer++;
            return;
        }
        

        for(int i=0; i<N; i++) {
            
            if(IsPossible(cur, i)) {
                arr[cur][i] = 1;
                DFS(cur+1); //재귀함수 부르기

                arr[cur][i] = 0; //다시 초기화
            }
        }
    }


    public static boolean IsPossible(int r, int c) {
        int nr;
        int nc;
        
        //수직
        for (int i = 1; i <= r; i++) {
            nr = r-i;
            nc = c;

            //경계 안이고, 놓을 수 없을 때
            if(nr>=0 && nr<N && nc>=0 && nc<N) {
                if(arr[nr][nc]!=0) {
                    return false;
                }
            }
        }

        //좌상 대각선
        for (int i = 1; i <= r; i++) {
            nr = r-i;
            nc = c-i;
            //경계 안이고, 놓을 수 없을 때
            if(nr>=0 && nr<N && nc>=0 && nc<N) {
                if(arr[nr][nc]!=0) {
                    return false;
                }
            }
        }
        //우상 대각선
        for (int i = 1; i <= r; i++) {
            nr = r-i;
            nc = c+i;
            //경계 안이고, 놓을 수 있을 때
            if(nr>=0 && nr<N && nc>=0 && nc<N) {
                if(arr[nr][nc]!=0) {
                    return false;
                }
            }
        }
        return true;
    }
}
