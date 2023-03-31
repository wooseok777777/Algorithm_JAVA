package com.ssafy.BOJ;

import java.util.*;

public class Main_1600_S3_말이되고픈원숭이_최우석 {
	static int K, n, m;
	static int[][] a;
	static int[][][] d; // y,x,k : (y,x) 위치에 말이동처럼 k 번이동했을때 올 수 있는 경우의 수
	static int[] sy = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] sx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	
	static int ans = -1;
	
	static boolean inside(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < m;
	}

	public static void main(String[] args) {
		// INIT
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		m = sc.nextInt();
		n = sc.nextInt();
		a = new int[n][m];
		d = new int[n][m][K + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int x = 0; x < K + 1; x++) {
					d[i][j][x] = -1;
				}
			}
		}

		// Set the start points
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0, 0 });
		d[0][0][0] = 0;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int y, x, kcnt;
			y = cur[0];
			x = cur[1];
			kcnt = cur[2];
			
			// found answer
			if(y == n-1 && x == m-1) {
				ans = d[y][x][kcnt];
				break;
			}
			// if I can use special movement
			if (kcnt < K) {
				for (int k = 0; k < 8; k++) {
					int ny = y + sy[k];
					int nx = x + sx[k];
					if (!inside(ny, nx))continue;
					if(a[ny][nx] == 1)continue;
					if (d[ny][nx][kcnt + 1] != -1) continue;
					d[ny][nx][kcnt + 1] = d[y][x][kcnt] + 1;
					q.add(new int[] { ny, nx, kcnt + 1 });
				}
			}
			// always can move adjacent direction
			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if (!inside(ny, nx)) continue;
				if(a[ny][nx] == 1)continue;
				if (d[ny][nx][kcnt] != -1) continue;
				d[ny][nx][kcnt] = d[y][x][kcnt] + 1;
				q.add(new int[] { ny, nx, kcnt });
			}
		}

		System.out.println(ans);
	}

}
