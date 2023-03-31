package com.ssafy.BackTracking;
import java.util.*;

public class Main_3109_G2_최우석 {
	static int n,m;
	static int[] dy = {-1,0,1};
	static int[] dx = {1,1,1};
	static boolean[][] v;
	static Character[][] map;
	static int ans;

	public static boolean inside(int y, int x) {
		return 0<=y && y<n && 0<=x && x<m;
	}
	
	public static boolean backtracking(int y, int x) {
		if(x == m-1) {
			ans++;
			return true;
		}
		v[y][x] = true;
	
		for(int k = 0;k<3;k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			if(!inside(ny,nx))continue;
			if(map[ny][nx] == 'x' || v[ny][nx])continue;
			if(backtracking(ny, nx))return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
	
		map = new Character[n][m];
		
		for(int i = 0;i<n;i++) {
			String s = sc.next();
			for(int j = 0 ;j<m;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		v = new boolean[n][m];
		for(int i = 0 ;i<n;i++) {
			backtracking(i, 0);
		}
		System.out.println(ans);
	}

}
