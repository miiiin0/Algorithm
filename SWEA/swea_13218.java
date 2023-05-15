package SWEA;

import java.util.*;

public class swea_13218 {
    public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int testCase = Integer.parseInt(sc.next());
		
		for(int t=1; t<=testCase; t++) {
			
			int num = Integer.parseInt(sc.next());
			int answer = num/3;
			
			System.out.println("#"+t+" "+answer);
		}
		
		sc.close();
	}
}
