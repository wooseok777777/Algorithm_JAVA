package com.ssafy.BOJ;

import java.util.*;

public class Main_2239_G4_스도쿠_최우석 {
	static final int N = 9;
	static final int n = 3;
	static int[][] a = new int[N][N];
	static List<HashSet<Integer>> garoset;
	static List<HashSet<Integer>> seroset;
	static List<HashSet<Integer>> sessionset;

	public static boolean checkGaro(int num, int y, int x) {
		return !garoset.get(y).contains(num);
	}

	public static boolean checkSero(int num, int y, int x) {
		return !seroset.get(x).contains(num);
	}

	public static boolean checkSession(int num, int y, int x) {
		int sy = y / n;
		int sx = x / n;
		int session = sy * n + sx;
		return !sessionset.get(session).contains(num);
	}

	public static boolean solve(int cur) {
		// answer
		if (cur == N * N) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(a[i][j]);
				}
				System.out.println();
			}
			return true;
		}

		int y = cur / N;
		int x = cur % N;

		if (a[y][x] != 0) {
			if (solve(cur + 1))
				return true;
		}

		else {
			for (int num = 1; num < 10; num++) {
				if (checkGaro(num, y, x) && checkSero(num, y, x) && checkSession(num, y, x)) {
					a[y][x] = num;
					int session = (y / n) * n + (x / n);
					garoset.get(y).add(num);
					seroset.get(x).add(num);
					sessionset.get(session).add(num);
					if (solve(cur + 1)) {
						return true;
					}
					a[y][x] = 0;
					garoset.get(y).remove(num);
					seroset.get(x).remove(num);
					sessionset.get(session).remove(num);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		garoset = new ArrayList<>();
		seroset = new ArrayList<>();
		sessionset = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			garoset.add(new HashSet<>());
			seroset.add(new HashSet<>());
			sessionset.add(new HashSet<>());
		}
		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < N; j++) {
				a[i][j] = (int) (line.charAt(j) - '0');
				if (a[i][j] == 0)
					continue;
				garoset.get(i).add(a[i][j]);
				seroset.get(j).add(a[i][j]);
				int si = i / n;
				int sj = j / n;
				int session = si * n + sj;
				sessionset.get(session).add(a[i][j]);
			}
		}

		solve(0);
	}

}
