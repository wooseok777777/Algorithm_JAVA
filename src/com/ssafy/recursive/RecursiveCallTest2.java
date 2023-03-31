package com.ssafy.recursive;

public class RecursiveCallTest2 {
	public static int N = 10;
	
	public static int f(int n) {
		if(n == 1 || n == 2)return 1;
		return f(n-1) + f(n-2);
	}
	
	public static int f2(int n) {
		return 2<n && n<=N ?  f2(n-1) + f2(n-2): 1;
	}
	
	public static int f3(int n) {
		if(n == 1 || n == 2 )return 1;
		return f3(n+1) + f3(n+2);
	}
	public static void main(String[] args) {
		
		System.out.println(f2(7));
		System.out.println(f3(7));
	}
}
