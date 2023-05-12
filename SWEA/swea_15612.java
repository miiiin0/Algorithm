package SWEA;

import java.io.*;
import java.util.*;

public class swea_15612 {

    static char[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(str.nextToken());
        
        
        for(int i=1; i<=testCase; i++) {

            //초기화
            String answer="yes";
            int cnt=0;
            arr = new char[8][8];


            //입력받기
            for(int j=0; j<8; j++) {
                String line = br.readLine();

                for(int k=0; k<8; k++) {
                    arr[j][k]= line.charAt(k);

                    //룩 개수 세기
                    if(arr[j][k]=='O') {
                        cnt++;
                    }
                }
                
            }

            //조건1: 정확히 8개의 룩이 있어야 한다.
            if(cnt!=8) {
                answer="no";
                System.out.println("#"+i+" "+answer);
                continue;
            }


            //조건1을 만족하면 조건2 검사
            //조건2: 모든 룩은 서로 공격할 수 없어야 한다. 
            //즉, 서로 다른 두 룩은 같은 열에 있거나 같은 행에 있으면 안 된다.

            for(int j=0; j<8; j++) {
                
                //가로 먼저 확인
                for(int k=0; k<8; k++) {
                    //룩을 찾았다면
                    if(arr[j][k]=='O') {

                        //세로 확인
                        if(!check2(j, k)) {
                            answer = "no";
                        }
                    }
                }
            }

            System.out.println("#"+i+" "+answer);

        }

    }

    static public boolean check2(int i, int j) {

        for (int x = 0; x < 8; x++) {
            if (x != i && arr[x][j]=='O') return false;
        }
 
        for (int y = 0; y < 8; y++) {
            if (y != j && arr[i][y]=='O') return false;
        }

        return true;

    }
    
}
