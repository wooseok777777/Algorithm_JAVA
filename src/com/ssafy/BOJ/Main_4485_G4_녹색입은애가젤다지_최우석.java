package com.ssafy.BOJ;

import java.util.*;

public class Main_4485_G4_녹색입은애가젤다지_최우석 {
	static int n;
	static int[][] a;
	static int[][] d;
	static int INF = 9 * 125 * 125;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static boolean inside(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < n;
	}

	public static void dijikstra() {

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
		pq.add(new int[] { a[0][0], 0, 0 });
		d[0][0] = a[0][0];

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int cost = cur[0], y = cur[1], x = cur[2];

			if (d[y][x] < cost)
				continue;

			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if (!inside(ny, nx))
					continue;
				int nextCost = cost + a[ny][nx];
				if (nextCost < d[ny][nx]) {
					d[ny][nx] = nextCost;
					pq.add(new int[] { nextCost, ny, nx });
				}

			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 0;
		while (true) {
			n = sc.nextInt();
			if (n == 0)
				break;
			a = new int[n][n];
			d = new int[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(d[i], INF);
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					a[i][j] = sc.nextInt();
				}
			}
			dijikstra();
			tc++;
			System.out.println("Problem " + tc + ": " + d[n - 1][n - 1]);
		}
	}

}
