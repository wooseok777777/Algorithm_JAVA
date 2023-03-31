package com.ssafy.DFS;


import java.util.*;

public class Main_13023_G5_ABCDER_최우석 {
	static int n,m;
	static List<List<Integer>>g;
	static boolean[] v;
	
	public static boolean dfs(int x , int cnt) {
		if(cnt == 4)return true;
		v[x] = true;
		for(Integer child : g.get(x)) {
			if(v[child])continue;
			boolean flag = dfs(child,cnt+1);
			if(flag) return true;
		}
		v[x] = false;
		return false;
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		g = new ArrayList<>();
		for(int i = 0 ;i<n;i++)g.add(new ArrayList<>());
		for(int i = 0 ;i<m;i++) {
			int a,b;
			a = sc.nextInt();
			b = sc.nextInt();
			g.get(a).add(b);
			g.get(b).add(a);
		}
		
		for(int i = 0 ;i<n;i++) {
			v = new boolean[n];
			boolean flag = dfs(i,0);
			if(flag) {
				System.out.println(1);
				System.exit(0);
			}
		}
		System.out.println(0);
	}
}
