package com.ssafy.graph;

import java.util.Scanner;

public class DisjointSetTest {
	static int[] parents; // 원소의 부모를 저장하는 배열
	static int[] rank;
	
	// init 
	public static void makeSet(int v) {
		parents[v] = v;
	}
	
	public static int findParent(int x) {
		if(parents[x] == x)return x;
		parents[x] = findParent(x);
		return parents[x];
	}
	
	public static void uniont(int x, int y) {
		x = findParent(x);
		y = findParent(y);
		
		if(x == y)return;
		
		if(rank[x] < rank[y]) {
			parents[x] = y;
		}else {
			parents[y] = x;
			if(rank[x]==rank[y]) {
				rank[x]++;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		parents = new int[n];
		rank = new int[n];
		for(int i = 0 ;i<n;i++) {
			makeSet(i);
		}
	}
}
