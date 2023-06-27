package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_5568 {
    static int n, k;
    static int[] arr, result;
    static HashSet<String> set;
    static boolean[] visited;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); //카드 개수
        k = Integer.parseInt(br.readLine()); //고르는 카드 개수

        //카드 숫자 입력받기
        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        visited = new boolean[n];
        result = new int[k];
        set = new HashSet<>();
        combi(0);
        
        System.out.println(set.size());
    }

    public static void combi(int depth) {
        if(depth == k) {
            String str = "";
            for(int i=0; i<k; i++) {
                str += result[i];
            }
            set.add(str);
            return;
        }

        for(int i=0; i<arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                combi(depth+1);
                visited[i] = false;
            }
        }
    }
}
