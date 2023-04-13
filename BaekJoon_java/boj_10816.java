// 숫자카드2
package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_10816 {
    static int N;
    static int M;
    static HashMap<Integer, Integer> map;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        //입력 버퍼
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        
		StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
    		int num = Integer.parseInt(st.nextToken());
    		
    		// 처음 들어오는 숫자
    		if(!map.containsKey(num)) {
    			map.put(num, 1);
    		}
    		// 이미 있는 숫자라면 +1
    		else {
    			map.put(num, map.get(num) + 1);
    		}
    	}


        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
    		int num = Integer.parseInt(st.nextToken());
    		
    		if(map.containsKey(num)) {
    			sb.append(map.get(num)+" ");
    		}
    		
    		else {
    			sb.append(0+" ");
    		}
    	}

        System.out.println(sb.toString());
    }
}
