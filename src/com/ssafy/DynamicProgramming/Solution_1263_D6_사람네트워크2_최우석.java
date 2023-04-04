package com.ssafy.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1263_D6_사람네트워크2_최우석 {
	static int n, tc;
	static final int INF = Integer.MAX_VALUE >> 2;
	static int[][] d,a;

	public static void Floyd() {
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
				}
			}
		}
	}

	public static int getMinNetwork() {
		int[] c = new int[n];
		for (int i = 0; i < n; i++) {
			int csum = 0;
			for (int j = 0; j < n; j++) {
				if (i == j) continue;
				csum += d[i][j];
			}
			c[i] = csum;
		}
		return Arrays.stream(c).min().getAsInt();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt();
			d = new int[n][n];
			a = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					a[i][j] = sc.nextInt();
					if(a[i][j] == 0)d[i][j] = INF;
					else d[i][j] = a[i][j];
				}
			}
			Floyd();
			int ans = getMinNetwork();
			System.out.printf("#%d %d\n", t, ans);
		}
		sc.close();
	}

}
