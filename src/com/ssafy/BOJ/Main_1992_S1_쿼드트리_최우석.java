package com.ssafy.BOJ;
import java.util.*;

public class Main_1992_S1_쿼드트리_최우석 {
	static int N;
	static String[][] map;
	
	static String solve(int y , int x,int n) {
		if(n == 1)return map[y][x];
		
		int sum = 0;
		for(int i = y ;i< y + n;i++) {
			for(int j = x ; j <x+n;j++) {
				sum += Integer.parseInt(map[i][j]);
			}
		}
			
		if(sum == 0) return "0";
		if(sum == n*n) return "1";
		int t = n/2;
		return "(" + solve(y,x,t) + solve(y,x+t,t) +solve(y+t,x,t) + solve(y+t,x+t,t) +")";
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new String[N][N];
		
		for(int i = 0 ;i<N;i++) {
			String[] s = sc.next().split("");
			for(int j = 0 ;j<N;j++) {
				map[i][j] = s[j];
			}
		}
		
		String ans = solve(0,0,N);
		System.out.println(ans);
		

	}

}
