package com.ssafy.swea;
import java.util.*;

public class Solution_5656_모의sw역량테스트_최우석 {
	static int k,n,m;
	static int tc;
	static int[][] a;
	static List<Integer> blocks;
	static List<Integer> result;
	static int ans;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	
	public static class Point{
		int y;
		int x;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	
	public static boolean inside(int y,int x) {
		return 0<=y && y<n && 0<=x && x<m;
	}
	
	public static int[][] copy(int[][] a){
		int[][] ret = new int[n][m];
		for(int i = 0 ;i<n;i++) {
			for(int j = 0 ;j<m;j++) {
				ret[i][j] = a[i][j];
			}
		}
		return ret;
	}
	
	public static void dfs(int[][] a,boolean[][] pops,int y, int x) {
		int cnt = a[y][x];
		pops[y][x] = true;
		
		for(int c = 0 ; c < cnt - 1;c++) {
			for(int k = 0 ;k<4;k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if(!inside(ny,nx))continue;
				dfs(a,pops,ny,nx);
			}
		}
	}
	public static void pop(int[][] a,int m) {
		int row = -1;
		for(int i = 0 ;i<n;i++) {
			if(a[i][m] !=0) {
				row = i;
				break;
			}
		}
		if(row == -1)return;
		//터트리는 행위
		boolean[][] pops = new boolean[n][m];
		dfs(a,pops,row,m);
		
		for(int i = 0 ;i<n;i++) {
			for(int j = 0 ;j<m;j++) {
				if(pops[i][j]) {
					a[i][j] = 0;
					ans++;
				}
			}
		}
	}
	
	public static void moveDown(int[][] a) {
		for(int j = 0 ;j<m;j++) {
			List<Integer> ele = new ArrayList<>();
			for(int i = n-1;i>=0;i--) {
				if(a[i][j]!=0)ele.add(a[i][j]);
			}
			for(int i = 0 ;i<n;i++)
				a[i][j] = 0;
			
			int i = n-1;
			for(Integer e : ele) {
				a[i--][j] = e;
			}
		}
	}
	public static void simulate(int[][] a, int m) {
		//터트리고
		pop(a,m);
		//밑으로 움직이고
		moveDown(a);
	}
	public static void simulate(int cnt,int r) {
		if(cnt == r) {
			int[][] cpya = copy(a);
			ans = 0;
			for(Integer j : blocks) {
				simulate(cpya,j);
			}

			result.add(ans);
			return;
		}
		
		for(int i = 0 ;i<m;i++) {
			blocks.add(i);
			simulate(cnt+1,r);
			blocks.remove(blocks.size()-1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();
		
		for(int t = 1 ; t<=tc ;t++) {
			k = sc.nextInt();
			m = sc.nextInt();
			n = sc.nextInt();
			a = new int[n][m];
			result = new ArrayList<>();
			for(int i = 0 ;i<n;i++) {
				for(int j = 0;j<m;j++) {
					a[i][j] = sc.nextInt();
				}
			}
			blocks = new ArrayList<>();
			simulate(0,k);
			System.out.println(Collections.max(result));
		}
	}
}
