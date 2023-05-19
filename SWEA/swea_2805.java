package SWEA;

import java.io.*;

public class swea_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseNum = Integer.parseInt(br.readLine());

        for(int t=1; t<=caseNum; t++) {

            int N = Integer.parseInt(br.readLine()); 
            int half = (N-1)/2;
            int[][] arr = new int[N][N];
            int[] way = new int[N];

            //입력받기
			for(int i=0; i<N; i++) {
                if(i>half) {
                    way[i] = N-1-i;
                } else {
                    way[i] = i;
                }
                
                String line = br.readLine();
                for(int j=0; j<N; j++) {
                    arr[i][j] = Character.getNumericValue(line.charAt(j));
                }
            }


            int answer = 0; 

            for(int i=0; i<N; i++) {
                
                for(int j=half-way[i]; j<=half+way[i]; j++) {
                    answer += arr[i][j];
                }
            }


            System.out.println("#"+t+" "+answer);
        
        }

    }
}
