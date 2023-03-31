package com.ssafy.swea;

import java.util.*;

public class Solution_2115_모의_벌꿀채취_최우석 {
	static int tc, n, m, c, N;
	static int[][] a;
	static boolean[][] v;
	static List<Point> harvestPoints;
	static List<Point> res;
	static int ans;
	static final int PICK = 2;

	static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Point [y=").append(y).append(", x=").append(x).append("]");
			return builder.toString();
		}

	}

	public static class Info implements Comparable<Info> {
		int honeysum;
		int profit;
		List<Integer> honeys;

		public Info(int honeysum, List<Integer> honeys) {
			super();
			this.honeysum = honeysum;
			this.honeys = honeys;
			for (Integer h : honeys) {
				profit += h * h;
			}
		}

		@Override
		public int compareTo(Info o) {
			return o.profit - profit;
		}

	}

	public static boolean inside(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < n;
	}

	public static boolean pickable(Point p1, Point p2) {
		boolean[][] pick = new boolean[n][n];

		for (int j = p1.x; j < p1.x + m; j++) {
			if (!inside(p1.y, j)) return false;
			pick[p1.y][j] = true;
		}
		for (int j = p2.x; j < p2.x + m; j++) {
			if (!inside(p2.y, j)) return false;
			if (pick[p2.y][j]) return false;
		}
		return true;
	}

	public static List<Integer> getHoneys(Point p) {
		List<Integer> honey = new ArrayList<>();
		for (int j = p.x; j < p.x + m; j++) {
			honey.add(a[p.y][j]);
		}
		return honey;
	}

	public static int sum(List<Integer> honey) {
		int sum = 0;
		for (int i = 0, n = honey.size(); i < n; i++) {
			sum += honey.get(i);
		}
		return sum;
	}

	public static List<Info> getHoneyInfo(List<Integer> honey) {
		List<Info> res = new ArrayList<>();

		for (int subset = 0; subset < 1 << m; subset++) {
			List<Integer> honeys = new ArrayList<>();
			int honeysum = 0;
			for (int i = 0; i < m; i++) {
				if ((subset & 1 << i) != 0) {
					honeysum += honey.get(i);
					honeys.add(honey.get(i));
				}
			}

			if (honeysum > c) continue;

			res.add(new Info(honeysum, honeys));
		}
		return res;
	}

	public static int caculateProfit(List<Integer> honey) {
		int ans = 0;
		for (Integer h : honey) {
			ans += h * h;
		}
		return ans;
	}

	public static void selectPoints(int idx, int cnt, int r) {
		if (cnt == r) {
			if (!pickable(res.get(0), res.get(1)))
				return;

			List<Integer> honeyA = getHoneys(res.get(0));
			List<Integer> honeyB = getHoneys(res.get(1));

			List<Info> InfoA = getHoneyInfo(honeyA);
			List<Info> InfoB = getHoneyInfo(honeyB);

			Collections.sort(InfoA);
			Collections.sort(InfoB);
			List<Integer> A = InfoA.get(0).honeys;
			List<Integer> B = InfoB.get(0).honeys;

			int aprofit = caculateProfit(A);
			int bprofit = caculateProfit(B);

			ans = Math.max(ans, aprofit + bprofit);
			return;
		}
		for (int i = idx; i < N; i++) {
			res.add(harvestPoints.get(i));
			selectPoints(i + 1, cnt + 1, r);
			res.remove(res.size() - 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			ans = Integer.MIN_VALUE;
			n = sc.nextInt();
			m = sc.nextInt();
			c = sc.nextInt();
			a = new int[n][n];
			v = new boolean[n][n];
			N = n * n;
			harvestPoints = new ArrayList<>();
			res = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					a[i][j] = sc.nextInt();
					harvestPoints.add(new Point(i, j));
				}
			}

			selectPoints(0, 0, PICK);
			System.out.println("#" + t + " " + ans);
		}
	}
}
