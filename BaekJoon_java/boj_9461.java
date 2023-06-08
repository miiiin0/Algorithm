package BaekJoon_java;

import java.io.*;

public class boj_9461 {
    static long[] arr = new long[101];
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        
        arr[0] = 0;
        arr[1] = arr[2] = arr[3] = 1;
        for(int t=0; t<testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(find(n));
        }
        
    }

    public static long find(int N) {
        if(arr[N]==0) {
            arr[N] = find(N-3) + find(N-2);
        }
        return arr[N];
    }
    
}
