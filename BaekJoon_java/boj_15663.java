package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_15663 {
    static int n, m;
    static int[] arr, used;
    static HashSet<String> set = new HashSet<String>();
    static boolean[] visited;
    static String answer = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        used = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        permutation(0);
        
    }

    //순열 (순서를 고려하여 뽑기)
    public static void permutation(int depth) {
        
        //출력
        if(depth == m) {
            StringBuilder temp = new StringBuilder();
			for(int i=0;i<m;i++) {
				temp.append(used[i]).append(' ');
			}
            
			String str = temp.toString();
            if(!set.contains(str)) {
                set.add(str);
                System.out.println(str);
            }
            
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true; 
                used[depth] = arr[i];
                permutation(depth+1); //재귀 부르기

                //다시 초기화
                visited[i] = false; 
            }
        }
    }
}
