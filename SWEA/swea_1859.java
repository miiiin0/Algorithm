package SWEA;

import java.io.*;
import java.util.*;

public class swea_1859 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int caseNum = Integer.parseInt(str.nextToken());
        int[] arr = {};
        long answer;

        for(int i=1; i<=caseNum; i++) {
            str = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(str.nextToken());
            arr = new int[day];

            str = new StringTokenizer(br.readLine());
            for(int j=0; j<day; j++) {
                arr[j] = Integer.parseInt(str.nextToken());
            }

            answer = 0;

            // for(int j=0; j<day; j++) {
            //     int max = 0;

            //     for(int k=j+1; k<day; k++) {
                    
            //         if(max < (arr[k]-arr[j])) {
            //             max = (arr[k]-arr[j]);
            //         }
                    
            //     }
            //     answer += max;
                
            // }
            int max = arr[day-1];
            for(int j=day-2; j>=0; j--) {
                if(max < arr[j]) {
                    max = arr[j];
                }
                answer += max-arr[j];
                
            }
            System.out.println("#"+i+" "+answer);
        }


    }
}
