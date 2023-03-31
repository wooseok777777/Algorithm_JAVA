package com.ssafy.swea;
import java.util.*;

public class Solution_3289_서로소집합_최우석 {
	static int[] parents;
	static int[] rank;
	static int n,m;
	static int tc;
	
	public static int findParent(int x) {
		if(parents[x] == x)return x;
		parents[x] = findParent(parents[x]);
		return parents[x];
	}
	
	public static void union(int x, int y) {
		x = findParent(x);
		y = findParent(y);
		
		if(x == y)return;
		
		if(rank[x] < rank[y]) {
			parents[x] = y;
		}else {
			parents[y] = x;
			if(rank[x] == rank[y])
				rank[x]++;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();
	
		
		for(int t = 1 ;t<=tc;t++) {
			String ans = "";
			n = sc.nextInt();
			m = sc.nextInt();
			parents = new int[n+1];
			rank = new int[n+1];
			for(int i = 0 ;i<n+1;i++)
				parents[i] = i;
			
			for(int i = 0 ;i<m;i++) {
				int op,x,y;
				op = sc.nextInt();
				x = sc.nextInt();
				y = sc.nextInt();
				if(op == 0) union(x,y);
				else {
					x = findParent(x);
					y = findParent(y);
					if(x == y)ans+="1";
					else ans+="0";
				}
			}
			System.out.println("#" + t + " "+ans);
		}

	}

}
