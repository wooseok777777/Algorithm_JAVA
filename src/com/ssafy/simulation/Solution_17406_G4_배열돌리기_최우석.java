package com.ssafy.simulation;

import java.util.*;

public class Solution_17406_G4_배열돌리기_최우석 {
	static int n, m, k;
	static int[][] a;
	static int maxDepth;
	public static boolean notend(int r, int c, int s) {
		int ly, lx, ry, rx;
		ly = r - s;
		lx = c - s;
		ry = r + s;
		rx = c + s;
		if (ly > r && lx < c && r < ry && c < rx)
			return true;
		return false;
	}

	private static void simulate(int r, int c, int s,int depth) {
		if(s == 0)return;
		
		int ly, lx, ry, rx;
		ly = r - s;
		lx = c - s;
		ry = r + s;
		rx = c + s;

		List<Integer> a1 = new ArrayList<Integer>();
		List<Integer> a2 = new ArrayList<Integer>();
		List<Integer> a3 = new ArrayList<Integer>();
		List<Integer> a4 = new ArrayList<Integer>();
		for (int j = lx; j < rx; j++)
			a1.add(a[ly][j]);
		for (int i = ly; i < ry; i++)
			a2.add(a[i][rx]);
		for (int j = rx; j > lx; j--)
			a3.add(a[ry][j]);
		for (int i = ry; i > ly; i--)
			a4.add(a[i][lx]);

	
		int idx = 0;
		for(int j = lx + 1;j<=rx;j++)a[ly][j] = a1.get(idx++);
		idx = 0;
		for(int i = ly+1;i<=ry;i++)a[i][rx] = a2.get(idx++);
		idx = 0;
		for(int j = rx -1;j>=lx;j--)a[ry][j] = a3.get(idx++);
		idx = 0;
		for(int i = ry - 1;i>=ly;i--)a[i][lx] = a4.get(idx++);
		
		simulate(r,c,s-1,depth+1);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		a = new int[n][m];
		maxDepth = Math.min(n, m)/2;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < k; i++) {
			int r, c, s;
			r = sc.nextInt() - 1;
			c = sc.nextInt() - 1;
			s = sc.nextInt();
		
			simulate(r, c, s,0);
			
			
		}
		
		List<Integer> res = new ArrayList<>();
		for(int i = 0 ;i<n;i++) {
			int sum = 0;
			for(int j = 0 ;j<m;j++) {
				sum+=a[i][j];
			}
			res.add(sum);
		}
		System.out.println(Collections.min(res));
	}

}
