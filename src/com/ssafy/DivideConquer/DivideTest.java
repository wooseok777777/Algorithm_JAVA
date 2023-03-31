package com.ssafy.DivideConquer;
import java.util.*;

public class DivideTest {
	static long exp(int x,int n) {
		if(n == 1) return x;
		long y = exp(x,n/2);
		return n%2 == 0 ? y*y : y*y*x;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x,n;
		x = sc.nextInt();
		n = sc.nextInt();
		
		long p = exp(x,n);
		System.out.println(p);
	}
}
