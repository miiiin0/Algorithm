package Programmers_java;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder("");

        // 편리함을 위해 String을 CharArray로 변환
        char[] array = number.toCharArray();
        int start=0;
        
        for(int i=0; i<array.length-k; i++) {
            char max='0'; //char는 ""가 아니라 ''으로 선언해야 함
            
            for(int j=start; j<=i+k; j++) {
                if(array[j]>max) {
                    max=array[j];
                    start=j+1; //max에 넣은 글자의 다음 인덱스를 나타냄
                }
            }
            // String형으로 바꿔서 answer에 넣어줌
            answer.append(Character.toString(max)); 
        }

        // StringBuilder 출력시 toString() 해줘야 함
        return answer.toString();
    }
}
