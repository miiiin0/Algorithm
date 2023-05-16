package SWEA;

import java.util.*;

public class swea_14413 {
    static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static char[][] arr;
	static String answer;
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int testCase = Integer.parseInt(sc.next());
		
		for(int t=1; t<=testCase; t++) {
			//입력받기
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			arr = new char[N][M];
			for(int i=0; i<N; i++) {
				arr[i] = sc.next().toCharArray();
			}
			
			answer = "possible";
			
			//. : 흰색
			//# : 검정색
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(arr[i][j]=='?') {
						//비어있는 칸 채우기
						find(i, j, N, M);
					}
				}
			}
			
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<M; j++) {
//					System.out.print(arr[i][j]);
//				}
//				System.out.println();
//			}
			
			
			
			//확인하기
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
                    // 위에서 비어있는 칸을 채웠는데도 ?라는 것은
                    // 모든 입력이 ?라는 뜻
                    // 즉, 격자판 만들 수 있음
					if(arr[i][j]=='?') {
						break;
					} else {
						check(i, j, N, M, arr[i][j]);
					}
					
				}
			}
			
			
			System.out.println("#"+t+" "+answer);
		}
		
		sc.close();
	}
	
	
	
	
	static public void find(int i, int j, int N, int M) {
        //상하좌우 네 방향 모두 확인하기
		for(int k=0; k<4; k++) {
            //어레이의 인덱스가 범위내에 있는지 확인
			if(0<=i+dx[k] && i+dx[k]<N && 0<=j+dy[k] && j+dy[k]<M) {
				if(arr[i+dx[k]][j+dy[k]]=='.') {
					arr[i][j] = '#';
				} else if(arr[i+dx[k]][j+dy[k]]=='#') {
					arr[i][j] = '.';
				} 
			}
		}
	}
	

	static public void check(int i, int j, int N, int M, char temp) {
		//현재 위치 값인 temp와
        //상하좌우 네 방향의 값이 모두 다르면 possible
		for(int k=0; k<4; k++) {
			if(0<=i+dx[k] && i+dx[k]<N && 0<=j+dy[k] && j+dy[k]<M) {
				if(arr[i+dx[k]][j+dy[k]]==temp) {
					answer="impossible";
				}
			}
		}
		
	}
}
