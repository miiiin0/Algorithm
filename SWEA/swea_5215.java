package SWEA;

import java.util.*;
import java.io.*;

public class swea_5215 {
    static int[] score;
	static int[] kcal;
	static int N, L, answer;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//입력받기
			N = Integer.parseInt(st.nextToken()); //재료의 수 
			L = Integer.parseInt(st.nextToken()); //제한 칼로리
			
			score = new int[N];
			kcal = new int[N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken()); //점수
				kcal[i] = Integer.parseInt(st.nextToken()); //칼로리
			}

			answer = 0;
			dfs(0,0,0);
			
			
			System.out.println("#"+t+" "+answer);
		}
		
		
	}
	static public void dfs(int cnt, int s, int k) {
		//칼로리 제한을 초과했을때
		if(k>L) 
			return;
		
		//마지막인 N번째일때
		if(cnt == N) {
			answer = Math.max(answer, s);
			return;
		}
		
		//재귀함수 호출
		dfs(cnt+1, s+score[cnt], k+kcal[cnt]); //현재 cnt 선택하는 경우  score[cnt], kcal[cnt] 각각 더해서 넘겨주기
		dfs(cnt+1, s, k); //현재 cnt 선택하지 않는 경우
	}
}
