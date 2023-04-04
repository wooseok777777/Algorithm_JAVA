package com.ssafy.BOJ;

import java.util.*;

public class Main_17472_G1_다리만들기2_최우석 {
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int n, m;
	static int[][] a;
	static int[][] groupmap;
	static boolean[][] groupcheck;
	static int[] parent;
	static int[] rank;

	static Scanner sc = new Scanner(System.in);
	static PriorityQueue<int[]> edges;

	static int groupnum;
	static final int ISLAND = 1;
	static final int WATER = 0;

	static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n][m];
		groupmap = new int[n][m];
		groupcheck = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = sc.nextInt();
			}
		}
	}

	static boolean inside(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < m;
	}

	static void markGroup(int y, int x, boolean[][] v) {
		v[y][x] = true;
		groupmap[y][x] = groupnum;
		for(int k = 0;k<4;k++) {
			int ny = y + dy[k],nx = x+dx[k];
			if(!inside(ny,nx))continue;
			if(v[ny][nx] || a[ny][nx] == WATER)continue;
			markGroup(ny, nx, v);
		}
	}

	static void makeGroup() {
		boolean[][] v = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!v[i][j] && a[i][j] == ISLAND) {
					groupnum++;
					markGroup(i, j, v);
				}
			}
		}
	}

	static void makeEdges() {
		edges = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (groupmap[i][j] == 0)
					continue;
				int gnum = groupmap[i][j];

				for (int k = 0; k < 4; k++) {
					int y = i, x = j;
					int bridgelen = 0;
					int adjacentNum = 0;

					while (true) {
						y += dy[k];
						x += dx[k];
						if (!inside(y, x))
							break;
						if (groupmap[y][x] != 0) {
							adjacentNum = groupmap[y][x];
							break;
						}
						bridgelen++;
					}
					if (adjacentNum != 0 && adjacentNum != gnum && bridgelen > 1) {
						edges.add(new int[] { bridgelen, gnum, adjacentNum });
					}
				}
			}
		}
	}

	static void makeSet() {
		parent = new int[groupnum + 1];
		rank = new int[groupnum + 1];
		for (int i = 0; i < groupnum + 1; i++)
			parent[i] = i;
	}

	static int getParent(int x) {
		if (parent[x] == x)
			return x;
		parent[x] = getParent(parent[x]);
		return parent[x];
	}

	static void union(int x, int y) {
		x = getParent(x);
		y = getParent(y);

		if (x == y)
			return;

		if (rank[x] < rank[y]) {
			parent[x] = y;
		} else {
			parent[y] = x;
			if (rank[x] == rank[y])
				rank[x]++;
		}
	}

	static int Kruskal() {
		int ans = 0;
		int edgecnt = 0;
		while (!edges.isEmpty()) {
			int[] edge = edges.poll();
			int cost = edge[0], x = edge[1], y = edge[2];
			if (getParent(x) != getParent(y)) {
				union(x, y);
				ans += cost;
				edgecnt++;
			}
		}
		return edgecnt == groupnum - 1 ? ans : -1;
	}

	public static void main(String[] args) {
		input();
		makeGroup();
		makeEdges();
		makeSet();
		int ans = Kruskal();
		System.out.println(ans);
	}
}
