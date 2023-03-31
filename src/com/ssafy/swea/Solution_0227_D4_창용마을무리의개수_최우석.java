package com.ssafy.swea;

import java.util.*;

public class Solution_0227_D4_창용마을무리의개수_최우석 {
	static int[] parents;
	static int[] rank;
	static Set<Integer> jointset;
	static int n, m;
	static int tc;

	public static int findParent(int x) {
		if (parents[x] == x)
			return x;
		parents[x] = findParent(parents[x]);
		return parents[x];
	}

	public static void union(int x, int y) {
		x = findParent(x);
		y = findParent(y);

		if (x == y)
			return;

		if (rank[x] < rank[y]) {
			parents[x] = y;
		} else {
			parents[y] = x;
			if (rank[x] == rank[y])
				rank[x]++;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt();
			m = sc.nextInt();
			parents = new int[n + 1];
			for (int i = 0; i < n + 1; i++)
				parents[i] = i;
			rank = new int[n + 1];
			jointset = new HashSet<>();

			for (int i = 0; i < m; i++) {
				int x, y;
				x = sc.nextInt();
				y = sc.nextInt();
				union(x, y);
			}
			for (int i = 1; i <= n; i++) {
				findParent(i);
			}

			for (int i = 1; i <= n; i++) {
				jointset.add(parents[i]);
			}

			int ans = jointset.size();
			System.out.println("#" + t + " " + ans);
		}
	}
}
