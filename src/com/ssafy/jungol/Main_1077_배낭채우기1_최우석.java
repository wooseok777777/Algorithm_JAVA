package com.ssafy.jungol;

import java.util.*;

public class Main_1077_배낭채우기1_최우석 {

	static int n, w;
	static int[][] d;
	static int[] v;
	static int[] c;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		w = sc.nextInt();
		d = new int[n][w + 1];
		v = new int[n];
		c = new int[n];

		for (int i = 0; i < n; i++) {
			v[i] = sc.nextInt();
			c[i] = sc.nextInt();
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= w; j++) {
				d[i][j] = d[i - 1][j];
				if (j - v[i] > 0)
					d[i][j] = Math.max(d[i][j], d[i - 1][j - v[i]] + c[i]);

			}
		}
		System.out.println(d[n - 1][w]);
	}

}
