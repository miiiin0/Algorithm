package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        HashSet<String> nStr = new HashSet<String>();
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> mStr = new HashSet<String>();

        for(int i=0; i<n; i++) {
            nStr.add(br.readLine());
        }

        for(int i=0; i<m; i++) {
            mStr.add(br.readLine());
        }

        //동일한 것만 남기고 삭제
        nStr.retainAll(mStr);
        
        //사전순으로 정렬하기 위해 ArrayList 사용
        ArrayList<String> answer = new ArrayList<String>(nStr);
        Collections.sort(answer);

        System.out.println(answer.size());

        Iterator iter = answer.iterator(); // Iterator 선언
        while (iter.hasNext()) { // 다음값이 있는지 체크
            System.out.println(iter.next()); // 값 출력
        }
        
    }
}
