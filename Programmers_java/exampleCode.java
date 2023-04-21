package Programmers_java;

import java.io.*;

public class exampleCode {
    public static void main(String[] args) throws IOException {
        String input = "1 2 3 4 5 6 5 4 3 2 1";
        String[] arr = input.split(" ");
        int answer = 0;

        for(int i=0; i<arr.length; i++) {
            

            for(int j=0; j<arr.length; j++) {
                if(i == j) {
                    continue;
                }
                if(arr[i].equals(arr[j]))
                    break;
                if(j==arr.length-1 && !(arr[i].equals(arr[j]))) {
                    answer = Integer.parseInt(arr[i]);
                    System.out.println(answer);
                }
            }
        }
        System.out.println(answer);
    }
}
