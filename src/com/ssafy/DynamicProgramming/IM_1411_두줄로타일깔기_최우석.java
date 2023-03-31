package com.ssafy.DynamicProgramming;
import java.util.*;

public class IM_1411_두줄로타일깔기_최우석 {
	
	static int[] d;
	
	static int solve(int n) {
		if(n<=0)return n;
		if(d[n]!=-1)return d[n];

		d[n] = solve(n-1) + 2*solve(n-2);
		d[n]%=20100529;
		return d[n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		d = new int[n+1];
		Arrays.fill(d, -1);
		d[0] = 0;
		d[1] = 1;
		d[2] = 3;
		System.out.println(solve(n));
	}

}
