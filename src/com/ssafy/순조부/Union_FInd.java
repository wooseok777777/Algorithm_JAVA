package com.ssafy.순조부;

import java.util.Arrays;

public class Union_FInd {

	static int[] parent;
	static int[] rank;
	static int n;

	public static int findParent(int x) {
		if (parent[x] == x)
			return x;
		parent[x] = findParent(parent[x]);
		return parent[x];
	}

	public static void union(int x, int y) {
		x = findParent(x);
		y = findParent(y);

		if (x == y)
			return;

		if (rank[x] < rank[y]) {
			parent[x] = y;
		} else {
			parent[y] = x;
			if (rank[x] == rank[y])
				rank[x] += 1;
		}
	}

	public static void main(String[] args) {
		n = 5;
		parent = new int[n];
		rank = new int[n];
		for(int i = 0 ;i<n;i++) {
			parent[i] = i;
		}
		
		union(0,1);
		union(0,2);
		union(2,3);
		
		System.out.println(Arrays.toString(parent));
	}

}
