package com.ssafy.swea;
import java.sql.Array;
import java.util.*;

public class Solution_2014_모의_활주로건설_최우석 {
    static int tc,n,x,ans;
    static int[][] a;

    static boolean possibleAirstrip(int[] a){
        boolean[] v = new boolean[n];

        for(int i = 0 ;i<n-1;i++){
            int left = a[i];
            int right = a[i+1];
            if(left!=right && Math.abs(left - right)!=1)return false;

            if(left + 1 == right){
                if(i  + 1 - x < 0 )return false;
                for(int j = i; j>=i + 1- x;j--){
                    if(left != a[j])return false;
                    if(v[j])return false;
                    v[j] = true;
                }
            }
            else if(left == right + 1){
                if(i  + x >= n)return false;
                for(int j = i + 1 ; j<= i + x;j++){
                    if(right != a[j])return false;
                    if(v[j])return false;
                    v[j] = true;
                }
            }
        }


        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tc = sc.nextInt();
        for(int t = 1;t<=tc;t++){
            n = sc.nextInt();
            x = sc.nextInt();
            a = new int[n][n];
            ans = 0;

            for(int i = 0 ;i<n;i++){
                for(int j = 0 ; j<n;j++){
                    a[i][j] = sc.nextInt();
                }
            }
            int g = 0;
            int s = 0;

            for(int i = 0 ;i<n;i++){

                if(possibleAirstrip(a[i])){
                    g++;
                }
            }


            for(int j = 0 ;j<n;j++){
                int[] sero = new int[n];

                for(int i = 0 ; i <n;i++){
                    sero[i] = a[i][j];
                }
                if(possibleAirstrip(sero)){
                    s++;
                }
            }

            System.out.printf("#%d %d\n",t,g + s);
        }
    }
}
