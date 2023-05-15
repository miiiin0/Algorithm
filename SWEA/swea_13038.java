package SWEA;

import java.util.*;

public class swea_13038 {
    public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int testCase = Integer.parseInt(sc.next());
		
		for(int t=1; t<=testCase; t++) {
			
			//들어야 되는 수업 수
			int classNum = Integer.parseInt(sc.next());
			
			//일주일 수업 일정
			int[] calender = new int[7] ;
			for(int i=0; i<7; i++) {
				calender[i] = sc.nextInt();
			}
			
			// 첫 개강일마다의 최소 일수 계산
			int min = Integer.MAX_VALUE;
			for(int i=0; i<7; i++) {
				if(calender[i]==1) {
					//i요일을 개강일로 할때 최소 일수 구하기
					int start = i;
					int cnt=0;
					while(true) {
						//수업듣기
						if(calender[start%7]==1) 
							cnt++;
						//일수 추가
						start++;
						//수업을 다 들었을때
						if(cnt==classNum) {
							min = Math.min(min, start -i);
							break;
						}
					
					}
				}
				
			}
			
			
			System.out.println("#"+t+" "+min);
		}
		
		sc.close();
	}
}
