package com.ssafy.DFS;

import java.util.Scanner;

public class Main_10026_G5_적록색약_최우석 {
	static int n,cnt1,cnt2;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static boolean[][] v;
	static Character[][] map;
	
	static void dfs(int y , int x,char color) {
		if(v[y][x]) return;
		v[y][x] = true;
		
		for(int k = 0 ; k<4;k++) {
			int ny = y+dy[k];
			int nx = x+dx[k];
			if(!inside(ny,nx))continue;
			if(map[y][x] != map[ny][nx])continue;
			dfs(ny,nx,color);
		}
	}
	

	static boolean inside(int y ,int x) {
		return 0<=y && y<n && 0<=x && x<n;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new Character[n][n];
		for(int i = 0;i<n;i++) {
			String s = sc.next();
			for(int j = 0 ;j<n;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		//일반인
		v = new boolean[n][n];
		for(int i = 0 ;i<n;i++) {
			for(int j =0 ;j<n;j++) {
				if(!v[i][j]) {
					cnt1++;
					dfs(i,j,map[i][j]);
				}
			}
		}
		
		//적록
		for(int i = 0 ;i<n;i++) {
			for(int j = 0;j<n;j++) {
				if(map[i][j] == 'G')
					map[i][j] = 'R';
			}
		}
		v = new boolean[n][n];
		for(int i = 0 ;i<n;i++) {
			for(int j =0 ;j<n;j++) {
				if(!v[i][j]) {
					cnt2++;
					dfs(i,j,map[i][j]);
				}
			}
		}
		
		System.out.println(cnt1 + " " + cnt2);
	}

}
