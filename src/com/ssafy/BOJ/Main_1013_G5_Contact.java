package com.ssafy.BOJ;
import java.util.*;

public class Main_1013_G5_Contact {
    static String pattern = "(100+1+|01)+";
    static int tc;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tc = sc.nextInt();
        for(int i = 0 ;i<tc;i++){
            String seq = sc.next();
            if(seq.matches(pattern)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
