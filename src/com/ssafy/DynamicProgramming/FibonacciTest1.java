package com.ssafy.DynamicProgramming;
import java.util.*;

public class FibonacciTest1 {
	
	static long callcnt1,callcnt2;
	static long[] d;
	
	static long fibo1(int n) {
		callcnt1++;
		if(n<=1) return n;
		
		return fibo1(n-1) + fibo1(n-2);
		
	}
	
	static long fibo2(int n) {
		if(d[n]!=-1) return d[n];
		callcnt2++;
		d[n] = fibo2(n-1) + fibo2(n-2);
		return d[n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		d = new long[n + 1];
		Arrays.fill(d, -1);
		d[0] = 0;
		d[1] = 1;
		d[2] = 1;
		
		//System.out.println(fibo1(n));
		System.out.println(fibo2(n));
		System.out.println(callcnt1 + " " + callcnt2);
	}

}
