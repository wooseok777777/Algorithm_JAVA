package com.ssafy.DynamicProgramming;

import java.util.*;

public class Main_1463_S3_1로만들기_최우석 {
	static int[] d;
	static int n;
	static final int MAX = 987654321; 
	public static int solve(int x) {
		if (d[x] != MAX) return d[x];
		if (x <= 1) return 0;
		if (x % 3 == 0) d[x] = solve(x/3) + 1;
		
		if (x % 2 == 0) d[x] = Math.min(d[x], solve(x/2) + 1);
		
		d[x] = Math.min(d[x], solve(x-1) + 1);
		return d[x];
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		d = new int[n + 1];
		Arrays.fill(d, MAX);
		System.out.println(solve(n));
	}
}
