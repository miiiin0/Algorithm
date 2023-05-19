package SWEA;

import java.util.*;

public class swea_1946 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
		int caseNum = sc.nextInt(); 
        
        for(int t=1; t<=caseNum; t++) {
            int N = sc.nextInt(); 
            int col=0;
            System.out.println("#"+t+" ");
            
            
            for(int i=0; i<N; i++) {
                String alpabet = sc.next();
                int num = sc.nextInt();
                

                for(int k=0; k<num; k++) {
                    System.out.print(alpabet);
                    col++;
                    if(col==10) {
                        col=0;
                        System.out.println();
                    }
                }
            }
            System.out.println();
        }

        sc.close();
    }
}
