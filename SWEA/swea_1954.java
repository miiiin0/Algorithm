package SWEA;

import java.util.*;

public class swea_1954 {
    //오른쪽 -> 아래 -> 왼쪽 -> 위
	static int[] dr = { 0, 1, 0, -1 }; // 우하좌상 순서
	static int[] dc = { 1, 0, -1, 0 };
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int caseNum = sc.nextInt(); 
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=caseNum; t++) {
			int arrNum = sc.nextInt(); 
			int[][] arr = new int[arrNum][arrNum];
			
			int way=0; 
			int row=0, col=0;
			
			for(int i=1; i<=arrNum*arrNum; i++) {
				arr[row][col] = i;
				
				//어레이 인덱스가 범위내에 있고
				//어레이 값이 이미 있을때
				if(row+dr[way]<0 || arrNum<=row+dr[way] || col+dc[way]<0 || arrNum<=col+dc[way]
						|| arr[row+dr[way]][col+dc[way]]!=0) {
					way = (way + 1) % 4; // 방향전환
				}
				row += dr[way];
				col += dc[way];
			}
			
			//결과값 StringBuilder에 넣기
			sb.append("#"+t+"\n");
			for(int i=0; i<arrNum; i++) {
				for(int j=0; j<arrNum; j++) {
					sb.append(arr[i][j]+" ");
				}
				sb.append("\n");
			}
			
		}
		
		//결과값 출력
		System.out.print(sb.toString());
		
		sc.close();
	}
}
