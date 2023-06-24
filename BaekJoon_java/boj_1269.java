package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        HashSet<Integer> aSet = new HashSet<>();
        HashSet<Integer> bSet = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<a; i++) {
            aSet.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<b; i++) {
            bSet.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        Iterator<Integer> it = aSet.iterator();
        while(it.hasNext()) {
            if(!bSet.contains(it.next())) {
                answer++;
            }
        }

        Iterator<Integer> it2 = bSet.iterator();
        while(it2.hasNext()) {
            if(!aSet.contains(it2.next())) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
