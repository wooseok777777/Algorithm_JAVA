package com.ssafy.unionfind;
import java.util.*;

public class UnionFind {
	static int n;
	static int[] parent;
	static int[] rank;
	
	public static int getParent(int x) {
		if(parent[x] == x)return x;
		return parent[x] = getParent(parent[x]);
	}
	
	public static void union(int x,int y) {
		x = getParent(x);
		y = getParent(y);
		
		if(x == y) return;
		
		if(rank[x] < rank[y]) {
			parent[x] = y;
		}else {
			parent[y] = x;
			if(rank[x] == rank[y])rank[x]++;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		parent = new int[n];
		rank = new int[n];
		for(int i = 0 ;i<n;i++)parent[i] = i;
		
	}
}
