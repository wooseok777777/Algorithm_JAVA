package com.ssafy.BruteForce;

import java.util.*;

public class Solution_2001_D2_파리퇴치_최우석 {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int m;
	static int[][]a;
	static boolean inArea(int y , int x) {
		return y+m <= n && x+m <= n;
	}
	static int getFlies(int y ,int x) {
		if(!inArea(y,x))return -1;
		int fly = 0;
		for(int i = y ;i<y+m;i++) {
			for(int j = x;j<x+m;j++) {
				fly+=a[i][j];
			}
		}
		return fly;
	}
	public static void main(String[] args) {
		int tc = sc.nextInt();
		for(int t = 1 ; t<=tc;t++) {
			n = sc.nextInt();
			m = sc.nextInt();
			a = new int[n][n];
			List<Integer> res = new ArrayList<>();
			
			for(int i = 0;i<n;i++) {
				for(int j =0 ;j<n;j++) {
					a[i][j] = sc.nextInt();
				}
			}
			for(int i = 0 ;i<n;i++) {
				for(int j = 0;j<n;j++) {
					int fly = getFlies(i,j);
					if(fly!=-1)res.add(fly);
				}
			}
			int ans = Collections.max(res);
			System.out.println("#"+t+" "+ans);
		}
	}

}
