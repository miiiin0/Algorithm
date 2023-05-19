package SWEA;

import java.util.*;
import java.io.*;

public class swea_1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(int t=1; t<=10; t++) {
            int caseNum = Integer.parseInt(br.readLine()); 
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> list = new ArrayList<Integer>();

            for(int i=0; i<8; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            Boolean go = true;

            while(go) {
                for(int c=1; c<=5; c++) {
                    int temp = list.remove(0);
                    if(temp-c<=0) {
                        list.add(0);
                        go = false;
                        break;
                    }
                    else {
                        list.add(temp-c);
                    }
                    
                }
            }
        
            System.out.print("#"+caseNum+" ");

            // for each 반복문 이용 데이터 출력
            for (int value : list) { 
                System.out.print(value+" ");
            }
            System.out.println();


        }
        
    }
}
