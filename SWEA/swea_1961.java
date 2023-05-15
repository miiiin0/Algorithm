package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1961 {
    static int arrLength;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseNum = Integer.parseInt(br.readLine());

        for(int i=1; i<=caseNum; i++) {
            //입력값 받기
            arrLength = Integer.parseInt(br.readLine());
            int[][] arr = new int[arrLength][arrLength];

            for(int j=0; j<arrLength; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0; k<arrLength; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }


            int[][] arr_90 = Rotation(arr);
            int[][] arr_180 = Rotation(arr_90);
            int[][] arr_270 = Rotation(arr_180);

			//결과 출력
            System.out.println("#"+i);
            for(int j=0; j<arrLength; j++) {
                for(int k=0; k<arrLength; k++) {
                    System.out.print(arr_90[j][k]);
                }
                System.out.print(" ");

                for(int k=0; k<arrLength; k++) {
                    System.out.print(arr_180[j][k]);
                }
                System.out.print(" ");

                for(int k=0; k<arrLength; k++) {
                    System.out.print(arr_270[j][k]);
                }
                System.out.println();
            }
        }
    }

	//90도 회전 함수
    public static int[][] Rotation(int[][] arr) {
        int[][] result = new int[arrLength][arrLength];

        for(int j=0; j<arrLength; j++) {
            for(int k=0; k<arrLength; k++) {
                result[j][k] = arr[arrLength-1-k][j];
            }
        }

        return result;
    }
}