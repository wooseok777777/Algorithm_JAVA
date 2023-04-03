package com.ssafy.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Floyd {
	static int n;
	static final int INF = Integer.MAX_VALUE >> 2;
	static int[][] a;

	public static int[][] Floyd() {
		int[][] d = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i == j)continue;
				d[i][j] = (a[i][j] == 0 ? INF : a[i][j]);
			}
			
		}
		
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
				}
			}
		}
		return d;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n][n];
		for(int i = 0 ;i<n;i++) {
			for(int j =0;j<n;j++) {
				a[i][j] = sc.nextInt();
			}
		}
		int[][] d = Floyd();
		System.out.println(Arrays.deepToString(d));
	}

}
