package Programmers_java;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        int sum = brown + yellow; // = 직사각형 면적

        for(int i=1; i<=sum; i++) {
            int col = i; //세로
            int row = sum/col; //가로

            //카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
            if(row < col)
                continue;

            //아래 조건을 만족하면 정답
            if((row-2)*(col-2)==yellow) { 
                answer[0] = col;
                answer[1] = row;
                break;
            }

        }

        return answer;
    }
}
