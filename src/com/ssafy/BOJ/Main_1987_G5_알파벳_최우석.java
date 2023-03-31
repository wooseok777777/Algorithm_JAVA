package com.ssafy.BOJ;
import java.util.*;

public class Main_1987_G5_알파벳_최우석 {
	static int n,m;
	static Character[][] map;
	static boolean[][] v;
	static List<Character> res;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int ans;
	

	static boolean inside(int y , int x) {
		return 0<=y && y<n && 0<=x && x<m;
	}
	
	static void backtracking(int y ,int x) {
		if(!inside(y,x))return;
		if(v[y][x])return;
		if(res.contains(map[y][x]))return;
		
		v[y][x] = true;
		res.add(map[y][x]);
		ans = Math.max(ans, res.size());
		for(int k = 0;k<4;k++) {
			int ny,nx;
			ny = y +dy[k];
			nx = x +dx[k];
			backtracking(ny,nx);
		}
		v[y][x] = false;
		res.remove(res.size()-1);
		return;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new Character[n][m];
		res = new ArrayList<>();
		v = new boolean[n][m];
		for(int i = 0 ;i<n;i++) {
			String s = sc.next();
			for(int j = 0 ;j<m;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		backtracking(0, 0);
		System.out.println(ans);
	}
}
