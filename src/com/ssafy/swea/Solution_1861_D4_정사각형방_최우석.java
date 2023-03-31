package com.ssafy.swea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution_1861_D4_정사각형방_최우석 {
	static int[][] a;
	static int[][] dp;
	static int n;
	static int[] dy = { 0, 0, -1, 1 };
	static int[] dx = { -1, 1, 0, 0 };
	static boolean[][] v;
	static List<Info> res;
	static int maxcnt;

	static class Info implements Comparable<Info> {
		public int y;
		public int x;
		public int cnt;

		public Info(int y, int x, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Info o) {
			if (this.cnt == o.cnt) {
				return a[this.y][this.x] - a[o.y][o.x];
			} else {
				return o.cnt - this.cnt;
			}
		}

	}

	static boolean inside(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < n;
	}

	static void backtracking(int y, int x, int cnt) {
		if (v[y][x])return;
		if(dp[y][x] >= cnt)return;
		
		v[y][x] = true;
		
		maxcnt = Math.max(maxcnt, cnt);
		dp[y][x] = maxcnt;
		
		for (int k = 0; k < 4; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			if (!inside(ny, nx))
				continue;
			if (a[ny][nx] != a[y][x] + 1)
				continue;

			backtracking(ny, nx, cnt + 1);

		}

		v[y][x] = false;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			res = new ArrayList<Info>();
			n = sc.nextInt();
			a = new int[n][n];
			dp = new int[n][n];
			v = new boolean[n][n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					a[i][j] = sc.nextInt();
					dp[i][j] = 0;
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					maxcnt = 1;
					backtracking(i, j, 1);
					res.add(new Info(i, j, maxcnt));
				}
			}
			
			Collections.sort(res);
			Info ans = res.get(0);
			int y, x, count;
			y = ans.y;
			x = ans.x;
			count = ans.cnt;
			System.out.println("#" + t + " " + a[y][x] + " " + count);
		}
		sc.close();
	}
}
