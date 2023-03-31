package com.ssafy.recursive;

public class RecursiveCallTest3 {
	
	public static int fibo1(int n) {
		return n <= 2 ? 1 : fibo1(n-1) + fibo1(n-2); 
	}
	
	public static int fibo2(int n) {
		return n > 2 ?  fibo1(n-1) + fibo1(n-2) : 1; 
	}
	public static void main(String[] args) {
		System.out.println(fibo1(10));
		System.out.println(fibo2(10));
		
		int n =7;
		
		int[] memo = new int[n+1];
		memo[1] = 1;
		memo[2] = 1;
		for(int i =3;i<=n;i++) {
			memo[i] = memo[i-1] + memo[i-2];
		}
		System.out.println(memo[n]);
	}
}
