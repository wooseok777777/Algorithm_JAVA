package com.ssafy.swea;

import java.util.*;

public class Solution_1949_등산로조성_최우석 {
	static int tc,maxheight,n,k;
	static int[][] a;
	static List<Integer> res;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int ans;
	static boolean[][] v;
	
	static class Point{
		int y;
		int x;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	public static boolean inside(int y , int x) {
		return 0<=y && y<n && 0<=x && x<n;
	}
	
	public static void dfs(int y , int x, int cnt,int[][] a) {
		if(v[y][x])return;
		v[y][x] = true;
		ans = Math.max(cnt, ans);
		for(int k = 0 ;k<4;k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			if(!inside(ny,nx))continue;
			if(v[ny][nx] || a[y][x] <= a[ny][nx])continue;
			dfs(ny,nx,cnt+1,a);
		}	
	}
	
	public static int[][] copy(int[][] a){
		int[][] cpya = new int[n][n];
		for(int i = 0 ;i<n;i++) {
			for(int j = 0 ;j<n;j++) {
				cpya[i][j] = a[i][j];
			}
		}
		return cpya;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();
		for(int t = 1 ; t<= tc; t++) {
			n = sc.nextInt();
			k = sc.nextInt();
			res = new ArrayList<>();
			a = new int[n][n];
			maxheight = 1;
			ans = 1;
			for(int i = 0 ;i<n;i++) {
				for(int j = 0 ;j<n;j++) {
					a[i][j] = sc.nextInt();
					maxheight = Math.max(maxheight, a[i][j]);
				}
			}
			// 가장 높은값 찾기

			for(int i = 0 ;i<n;i++) {
				for(int j = 0 ;j<n;j++) {
					if(a[i][j] == maxheight) {
				
						int[][] Initiala = copy(a);
						v = new boolean[n][n];
						dfs(i,j,1,Initiala);
						for(int ii = 0 ;ii<n;ii++) {
							for(int jj =0;jj<n;jj++) {
								for(int kk = 1 ;kk<=k;kk++) {
									int[][] cpya = copy(a);
									cpya[ii][jj]-=kk;
									if(cpya[ii][jj] < 0) cpya[ii][jj] = 0;
									v = new boolean[n][n];
									dfs(i,j,1,cpya);
								}
							}
						}
					}
				}
			}
			System.out.println("#" + t + " " + ans);
		}

	}

}
