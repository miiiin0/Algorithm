package SWEA;

import java.io.*;
import java.util.*;

public class swea_1206 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = {};
       
        for(int i=1; i<=10; i++) {
            
            StringTokenizer str = new StringTokenizer(br.readLine());
            int arrLength = Integer.parseInt(str.nextToken()); //100
            int answer = 0;

            arr = new int[arrLength];
            str = new StringTokenizer(br.readLine()," ", false); //0 0 225 214 82 73 241 233...
            int j=0;
            while(str.hasMoreTokens()) {
                arr[j] = Integer.parseInt(str.nextToken());
                j++;
            }

            for(int k=2; k<arrLength-2; k++) {
                int max = Math.max(arr[k-2], Math.max(arr[k-1], Math.max(arr[k+1], arr[k+2])));
                if(arr[k] - max > 0) {
                    answer += arr[k] - max;
                }
            }
            System.out.println("#"+i+" "+answer);
            
        }

    }
}