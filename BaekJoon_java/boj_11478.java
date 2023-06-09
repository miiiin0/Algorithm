package BaekJoon_java;

import java.util.*;
import java.io.*;

public class boj_11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        HashSet<String> map = new HashSet<String>();
        
        for(int i=0; i<=str.length(); i++) {
            for(int j=i+1; j<=str.length(); j++) {
                //System.out.println(str.substring(i, j));
                map.add(str.substring(i, j));
                
            }
        }
        System.out.println(map.size());
    }
}
