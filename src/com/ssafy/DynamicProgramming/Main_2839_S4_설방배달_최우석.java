package com.ssafy.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;


public class Main_2839_S4_설방배달_최우석 {
	static int[] d;
	static int n;
	static final int MAX = 987654321;
	
	public static int solve(int x) {
		if(x <= 0 )return -1;
		if(x == 3 || x == 5)return 1;
		if (d[x] != -1) return d[x];
		
		int x1 = solve(x-3);
		int x2 = solve(x-5);
		
		if(x1!=-1 && x2 !=-1) d[x] = Math.min(x1, x2) + 1;
		else if(x1!= -1 && x2 == -1)d[x] = x1 + 1;
		else if(x1==-1 && x2 != -1)d[x] = x2 + 1;
		
		return d[x];
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		d = new int[n + 1];
		Arrays.fill(d, -1);
		System.out.println(solve(n));
	}

}
