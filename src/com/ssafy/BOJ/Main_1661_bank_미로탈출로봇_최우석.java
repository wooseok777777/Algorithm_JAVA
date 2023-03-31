package com.ssafy.BOJ;

import java.io.IOException;
import java.util.*;

class Point{
	public int y;
	public int x;
	public int cnt;
	
	public Point(int y, int x, int cnt) {
		super();
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
	
}

public class Main_1661_bank_미로탈출로봇_최우석 {
	
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	static int n,m;
	static int sy,sx,ey,ex;
	static int[][] a;
	static int[][] dp;
	
	static boolean[][] visited;

	public static boolean inside(int y , int x) {
		return 0<=y && y<n && 0<=x && x<m;
	}
	
	public static void dfs(int y,int x,int cnt) {
		if(dp[y][x] <= cnt) return;
		dp[y][x] =cnt;
		for(int k = 0;k<4;k++) {
			int ny = y+dy[k];
			int nx = x+dx[k];
			if(!inside(ny,nx))continue;
			if(a[ny][nx] == 1)continue;
			dfs(ny,nx,cnt+1);
		}
	}
	public static int bfs(int sy,int sx) {
		int ans = -1;
		
		ArrayDeque<Point> q = new ArrayDeque<>();
		q.add(new Point(sy,sx,0));
		visited[sy][sx] = true;
		
		while(!q.isEmpty()) {
			
			Point now = q.poll();
			int y,x,cnt;
			y = now.y;
			x = now.x;
			cnt = now.cnt;
			
			if(y == ey && x == ex) {
				ans = cnt;
				break;
			}
			
			for(int k = 0;k<4;k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				
				if(!inside(ny,nx))continue;
				if(visited[ny][nx])continue;
				if(a[ny][nx] == 1)continue;
				
				visited[ny][nx] = true;
				q.add(new Point(ny,nx,now.cnt + 1));
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc= new Scanner(System.in);
		
	
		m = sc.nextInt();
		n = sc.nextInt();
		a = new int[n][m];
		dp = new int[n][m];
		visited = new boolean[n][m];
		sx = sc.nextInt() - 1;
		sy = sc.nextInt() - 1;
		ex = sc.nextInt() - 1;
		ey = sc.nextInt() - 1;
	
		for(int i = 0 ;i<n;i++) {
			char[] row = sc.next().toCharArray();	
			for(int j = 0 ;j<m;j++) {
				a[i][j] = (int)(row[j] - '0');
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		
		dfs(sy,sx,0);
		//int ans1 = bfs(sy,sx);
		int ans2 = dp[ey][ex];
		//System.out.println(ans1);
		System.out.println(ans2);
	}

}
