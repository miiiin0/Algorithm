package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_2597 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double left = 0;
        double right = Double.parseDouble(br.readLine());

        double[] red = new double[2];
        double[] blue = new double[2];
        double[] yellow = new double[2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        red[0] = Double.parseDouble(st.nextToken());
        red[1] = Double.parseDouble(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        blue[0] = Double.parseDouble(st.nextToken());
        blue[1] = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());
        yellow[0] = Double.parseDouble(st.nextToken());
        yellow[1] = Double.parseDouble(st.nextToken());


        double tempLeft = 0; 
        double mid = 0; 
        if(Double.compare(red[0], red[1]) != 0) {
            mid = (red[1]+red[0])/2;
            tempLeft = mid - left; //접힌 부분 왼쪽 길이

            //접힌 선보다 왼쪽에 있으면 좌표를 바꿔줌
            if(blue[0] < mid) 
                blue[0] = mid + (mid-blue[0]);
            if(blue[1] < mid) 
                blue[1] = mid + (mid-blue[1]);
            if(yellow[0] < mid) 
                yellow[0] = mid + (mid-yellow[0]);
            if(yellow[1] < mid) 
                yellow[1] = mid + (mid-yellow[1]);

            //접힌 자의 정보 구하기
            left = mid;
            right = Math.max(right, (mid+tempLeft));
        }
        
        if(Double.compare(blue[0], blue[1]) != 0) {
            mid = (blue[1]+blue[0])/2;
            tempLeft = mid - left;

            //접힌 선보다 왼쪽에 있으면 좌표를 바꿔줌
            if(yellow[0] < mid) 
                yellow[0] = mid + (mid-yellow[0]);
            if(yellow[1] < mid) 
                yellow[1] = mid + (mid-yellow[1]);

            //접힌 자의 정보 구하기
            left = mid;
            right = Math.max(right, (mid+tempLeft));
        }

        if(Double.compare(yellow[0], yellow[1]) != 0) {
            mid = (yellow[1]+yellow[0])/2;
            tempLeft = mid - left;

            //접힌 자의 정보 구하기
            left = mid;
            right = Math.max(right, (mid+tempLeft));
        }
        
        System.out.println(right-left);

    }
}
