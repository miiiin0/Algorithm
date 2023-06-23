package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); //나무 개수
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N+1];
        int min = 0; 
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());

            if(max < tree[i]) {
                max = tree[i];
            }
        }

        while(min < max) {
            int mid = (min + max) / 2;
            long sum = 0;

            for(int i=0; i<tree.length; i++) {
                //나무를 잘랐을때 윗 부분이 있을때
                if(tree[i] - mid > 0) { 
                    sum += (tree[i]-mid);
                }
            }

            // 자른 나무의 길이의 합이 M보다 작은 경우
            // 절단기의 높이를 낮춰야 한다는 뜻 
            if(sum < M) {
                max = mid;
            }

            // 자른 나무의 길이의 합이 M보다 큰 경우
            // 절단기의 높이를 높여야 한다는 뜻 
            else {
                min = mid+1;
            }
        }

        // sum == M일때 else문때문에 +1해서 나오기 때문에 -1해준다
        System.out.print(min-1);
        
    }
}
