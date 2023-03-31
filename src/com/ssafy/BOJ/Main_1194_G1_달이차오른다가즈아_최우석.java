package com.ssafy.BOJ;

import java.util.*;

public class Main_1194_G1_달이차오른다가즈아_최우석 {
	static final int KEY_N = 6;
	static int n, m;
	static char[][] a;
	static int[][][] d;
	static final char start = '0';
	static final char end = '1';
	static final char wall = '#';
	static final char road = '.';
	static int sy, sx, ey, ex;
	static int ans = -1;

	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };
	
	static char[] rooms = {'A','B','C','D','E','F'};
	static char[] keys = {'a','b','c','d','e','f'};

	static boolean inside(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < m;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new char[n][m];
		d = new int[n][m][1 << KEY_N];

		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < m; j++) {
				a[i][j] = line.charAt(j);
				if (a[i][j] == start) {
					sy = i;
					sx = j;
					a[i][j] = road;
				}
				for (int k = 0; k < (1 << KEY_N); k++) {
					d[i][j][k] = -1;
				}
			}
		}

		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { sy, sx, 0 });
		d[sy][sx][0] = 0;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			int y = cur[0], x = cur[1], key = cur[2];
			if(a[y][x] == end) {
				ans = d[y][x][key];
				break;
			}
			

			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if (!inside(ny, nx))
					continue;
				if (a[ny][nx] == wall)
					continue;

				// 문을 만났을 경우
				if (Arrays.binarySearch(rooms, a[ny][nx]) >= 0) {
					// 키가 있고, 방문 x
					if ((key & (1 << a[ny][nx] - 'A')) != 0 && d[ny][nx][key] == -1) {
						d[ny][nx][key] = d[y][x][key] + 1;
						q.add(new int[] { ny, nx, key });
					}

				}
				// 키를 만났을 경우
				else if (Arrays.binarySearch(keys, a[ny][nx]) >= 0) {
					int nextKey = key | (1 << a[ny][nx] - 'a');
					if(d[ny][nx][nextKey] == -1) {
						d[ny][nx][nextKey] = d[y][x][key] + 1;
						q.add(new int[] {ny,nx,nextKey});
					}
				} else if(a[ny][nx] == road || a[ny][nx] == end){
					if (d[ny][nx][key] == -1) {
						d[ny][nx][key] = d[y][x][key] + 1;
						q.add(new int[] { ny, nx, key });
					}
				}
			}

		}

		System.out.println(ans);
	}

}
