package com.ssafy.BOJ;
import java.util.*;

public class Main_3055_G5_탈출_최우석 {
	static int n,m;
	static char[][] a;

	static int sy,sx;
	static int ey,ex;
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
	static final char WALL = 'X';
	static final char END = 'D';
	static final char START = 'S';
	static final char WATER = '*';
	static ArrayDeque<int[]> bq = new ArrayDeque<>();
	static ArrayDeque<int[]> wq = new ArrayDeque<>();
	static int[][] d;
	
	static boolean inside(int y , int x) {
		return 0<=y && y<n && 0<=x && x<m;
	}
	
	static int bfs() {
		
		d[sy][sx] = 0;
		
		while(!bq.isEmpty()) {
			
			// MOVE WATER
			int watersize = wq.size();
			while(watersize-- > 0) {
				
				int[] wcur = wq.poll();
				int wy = wcur[0],wx = wcur[1];
				
				for(int k = 0 ;k<4;k++) {
					int nwy = wy + dy[k],nwx = wx + dx[k];
					if(!inside(nwy,nwx))continue;
					if(a[nwy][nwx] == WALL || a[nwy][nwx] == WATER || a[nwy][nwx] == END)continue;
					a[nwy][nwx] = WATER;
					wq.add(new int[] {nwy,nwx});
				}
			}
			
			// MOVE BEAVER
			int beaverqsize = bq.size();
			
			while(beaverqsize-- > 0 ) {
				int[] bcur = bq.poll();
				int by = bcur[0],bx = bcur[1];
				if(a[by][bx] == END) return d[by][bx];
				for(int k = 0 ;k<4;k++) {
					int nby = by + dy[k],nbx = bx + dx[k];
					if(!inside(nby,nbx))continue;
					if(d[nby][nbx]!=-1)continue;
					if(a[nby][nbx] == WALL || a[nby][nbx] == WATER)continue;
					d[nby][nbx] = d[by][bx] + 1;
					bq.add(new int[] {nby,nbx});
				}
			}
			
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new char[n][m];
		d = new int[n][m];
		for(int i = 0 ;i<n;i++) {
			String line = sc.next();
			for(int j = 0 ;j<m;j++) {
				a[i][j] = line.charAt(j);
				d[i][j] = -1;
				if(a[i][j] == START) {
					sy = i;
					sx = j;
					bq.add(new int[] {i,j});
				}
				else if(a[i][j] == '*') {
					wq.add(new int[] {i,j});
				}
			}
		}
	
		int ans = bfs();
		if(ans!=-1)System.out.println(ans);
		else System.out.println("KAKTUS");
	}
}
