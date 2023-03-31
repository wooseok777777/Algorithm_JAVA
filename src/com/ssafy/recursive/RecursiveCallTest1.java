package com.ssafy.recursive;

import java.util.Scanner;

public class RecursiveCallTest1 {
	public static int N = 10;
	
	public static int sum1(int n) {
		if ( n == 1)return n;
		return n + sum1(n-1);
	}
	
	public static int sum2(int n) {
		if(n > 1) return n + sum2(n-1);
		return n;
	}
	public static int sum4(int n) {
		if(n < N) return n + sum4(n+1);
		return n;
	}
	public static void main(String[] args) {
		System.out.println(sum1(10));
		System.out.println(sum2(10));
		System.out.println(sum4(1));
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		int fac = 1;
		for(int i = 1;i<=N;i++) {
			fac *= i;
		}
		System.out.printf("1부터 %d까지의 factorial : %d%n",N,fac);
		
		fac = 1;
		for(int i = N;i>=1;i--) {
			fac *= i;
		}
		System.out.printf("1부터 %d까지의 factorial : %d%n",N,fac);
	}
	
}
