package com.ssafy.BOJ;
import java.util.*;

public class Main_2636_G3_치즈_최우석 {
	static int n,m;
	static int[][] a;
	static int time,cheese;
	static List<Integer> remainCheese;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	public static boolean inside(int y , int x) {
		return 0<= y && y<n && 0<=x && x <m;
	}
	
	
	public static void bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		boolean[][] v = new boolean[n][m];
		boolean[][] melted = new boolean[n][m];
	
		v[0][0] = true;
		q.add(new int[] {0,0});
		List<int[]> meltingCheeseLocation = new ArrayList<>();
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0], x = cur[1];
			
			for(int k = 0 ;k<4;k++) {
				int ny = y + dy[k],nx = x +dx[k];
				
				if(!inside(ny,nx))continue;
				if(v[ny][nx])continue;
				if(a[ny][nx] == 1) {
					if(!melted[ny][nx]) {
						meltingCheeseLocation.add(new int[] {ny,nx});
						melted[ny][nx] = true;
					}
					continue;
				}
				v[ny][nx] = true;
				q.add(new int[] {ny,nx});
			}
		}
		for(int[] location : meltingCheeseLocation) {
			int y = location[0],x = location[1];
			a[y][x] = 0;
		}
		remainCheese.add(cheese);
		cheese-=meltingCheeseLocation.size();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		n+=2;
		m+=2;
		a = new int[n][m];
		remainCheese = new ArrayList<>();
		for(int i = 1;i<n-1;i++) {
			for(int j = 1;j<m-1;j++) {
				a[i][j] = sc.nextInt();
				if(a[i][j] == 1)cheese++;
			}
		}
		
		while(cheese!=0) {
			bfs();
			time++;
		}
		System.out.println(time);
		System.out.println(remainCheese.get(remainCheese.size()-1));
	}

}
