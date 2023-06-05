package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_1063 {

    static int kingC;
    static int kingI;
    static int stoneC;
    static int stoneI;
    static char[] king, rock;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        king = st.nextToken().toCharArray(); 
        rock = st.nextToken().toCharArray(); 
        int n = Integer.parseInt(st.nextToken());

        
        for(int t=0; t<n; t++) {
            String next = br.readLine();
            char[] next_king = move(next, king);

            // 킹 움직였더니 범위 안에는 있음
            if('A'<=next_king[0] && next_king[0]<='H' && '0'<next_king[1] && next_king[1]<'9') {
                // 킹 움직였더니 돌이랑 겹칠때
                if(next_king[0]==rock[0] && next_king[1]==rock[1]) {
                    char[] next_rock = move(next, rock);
                    // 움직인 돌도 범위 안에 있으면
                    if('A'<=next_rock[0] && next_rock[0]<='H' && '0'<next_rock[1] && next_rock[1]<'9'){ 
                        king = next_king;
                        rock = next_rock;
                    }
                    else    continue; // 돌이 범위 밖으로 나가면 이번 명령 무시
                }
                // 킹 움직였더니 돌이랑 겹치진 않으면 킹만 움직이면 됨
                else{ 
                    king = next_king;
                }
                
            }

            
            
        }
        System.out.println(king[0]+""+king[1]);
        System.out.println(rock[0]+""+rock[1]);

        
    }

    static public char[] move(String next, char[] target) {
        char[] result = target.clone(); //복사
        switch(next){
            case "R":
                result[0]++;
                break;
            case "L":
                result[0]--;
                break;
            case "B":
                result[1]--;
                break;
            case "T":
                result[1]++;
                break;
            case "RT":
                result[0]++;    result[1]++;
                break;
            case "LT":
                result[0]--;    result[1]++;
                break;
            case "RB":
                result[0]++;    result[1]--;
                break;
            case "LB":
                result[0]--;    result[1]--;
        }
        return result;
    }
    
    
}
