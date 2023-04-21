package Programmers_java;

import java.util.*;

class Solution {
    //가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로로 반환해야 하기 때문에 ArrayList 사용
    //list에는 가능한 경로가 모두 저장된다.
    static ArrayList<String> list = new ArrayList<>();
    //해당 티켓을 사용했는지 안했는지 판단하기 위한 변수
    static boolean useTickets[];

    public String[] solution(String[][] tickets) {

        useTickets = new boolean[tickets.length];

        dfs(0, "ICN", "ICN", tickets);

        Collections.sort(list); //가능한 경로들을 알파벳 순서로 sort

        return list.get(0).split(" "); //제일 처음에 있는 경로(.get(0))만 리턴

    }

    static public void dfs(int depth, String start, String path, String[][] tickets) {
        if(depth == tickets.length) {
            list.add(path);
            return;
        }

        for(int i=0; i<useTickets.length; i++) {
            if(!useTickets[i] && start.equals(tickets[i][0])) {
                useTickets[i] = true;
                //재귀함수 호출
                dfs(depth+1, tickets[i][1], path + " " +tickets[i][1], tickets);
                useTickets[i] = false;
            }
        }
    }
}
