package Programmers_java;

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1; //곱셈을 위해 1로 설정
        
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<clothes.length; i++) {
            String type = clothes[i][1];
            map.put(type, map.getOrDefault(type, 1)+1);
        }
        //'안입거나' 라는 옵션이 있기 때문에 
        // map.getOrDefault(type, 1)에서 DefaultValue를 1로 설정하는 것임

        for(String key: map.keySet()) {
            answer *= map.get(key);
        }
        
        return answer-1; //아무것도 안입는 경우 빼주기

    }

}
