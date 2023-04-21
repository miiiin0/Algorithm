package Programmers_java;

import java.util.*;

class Solution {
    static char[] arr;
    static HashSet<Integer> set = new HashSet<>();
    static boolean[] visited;

    public int solution(String numbers) {
        int answer = 0;
        arr = numbers.toCharArray();
        visited = new boolean[numbers.length()];

        DFS("", 0);
        


        answer = set.size();
        
        return answer;
    }

    public void DFS(String str, int index) {
        int num=0;

        if(!str.equals("")) {
            num = Integer.parseInt(str);
            if(isPrime(num))
                set.add(num);
            
        }

        //끝까지 다 했을때
        if(index == arr.length)
            return;

        for(int i=0; i<arr.length; i++) {

            if(!visited[i]) {
                visited[i] = true;
                DFS(str+arr[i], index+1);
                visited[i] = false;
            }
        }

    }

    // 소수 판별
    public boolean isPrime(int num){
        if(num==0||num==1) return false;
        for(int i=2; i<num; i++){
            if(num%i==0) return false;
        }
        return true;
    }
    
}
