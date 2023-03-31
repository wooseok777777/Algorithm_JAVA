package com.ssafy.PreFixSum;

import java.util.Scanner;

public class Main_11659_S3_구간합구하기4_최우석 {
	static int n;
	static int query;
	static int a[];
	static int preFixSumArr[];

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();
		query = sc.nextInt();
		a = new int[n + 1];
		preFixSumArr = new int[n + 1];
		
		for (int i = 1; i <= n; i++)a[i] = sc.nextInt();
		
		for (int i = 1; i <= n; i++)preFixSumArr[i] = preFixSumArr[i - 1] + a[i];

		for (int i = 0; i < query; i++) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			int ans = preFixSumArr[r] - preFixSumArr[l-1];
			System.out.println(ans);
		}
	}
}
