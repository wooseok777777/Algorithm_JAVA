package com.ssafy.swea;
import java.util.*;

public class Solution_0303_프로세서연결하기_최우석 {

	static int tc,n,poweredcore;
	static int[][] a;
	static List<Point> cores;
	static List<Info> res;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	public static boolean inside(int y,int x) {
		return 0<=y && y<n && 0<=x && x<n;
	}
	
	public static class Point{
		int y;
		int x;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	
	public static class Info implements Comparable<Info>{
		int connected;
		int length;
		public Info(int connected, int length) {
			super();
			this.connected = connected;
			this.length = length;
		}
		@Override
		public int compareTo(Info o) {
			if(connected != o.connected) {
				return o.connected - connected;
			}else {
				if(length != o.length) {
					return length - o.length;
				}
				return 0;
			}
		}
		
		
	}
	public static void disconnect(int y ,int x ,int k) {
		int ny = y;
		int nx = x;
		while(true) {
			ny+=dy[k];
			nx+=dx[k];
			if(!inside(ny,nx))break;
			a[ny][nx] = 0;
		}
	}
	
	public static int connect(int y,int x,int k) {
		int len = 0;
		int ny = y;
		int nx = x;
		while(true) {
			ny+=dy[k];
			nx+=dx[k];
			if(!inside(ny,nx))break;
			a[ny][nx] = 1;
			len+=1;
		}
		return len;
	}
	public static boolean canConnect(int[][] a, int y ,int x ,int k) {
		int ny = y;
		int nx = x;
		
		boolean ok = true;
		while(true) {
			ny+=dy[k];
			nx+=dx[k];
			if(!inside(ny,nx))break;
			if(a[ny][nx] == 1) {
				ok = false;
				break;
			}
		}
		return ok;
	}
	
	public static void simulate(int idx,int connected,int length) {
		if(idx == cores.size()) {
			res.add(new Info(connected,length));
			return;
		}
		
		Point curCore = cores.get(idx);
		int y = curCore.y;
		int x = curCore.x;
		
		//총 5가지 방법
		// 4가지 방향연결
		for(int k = 0 ;k<4;k++) {
			if(!canConnect(a,y,x,k))continue;
			//연결 가능하면 연결해봄
			int l = connect(y,x,k);
			simulate(idx+1,connected+1,length+l);
			//해제
			disconnect(y,x,k);
		}
		// 연결안함
		simulate(idx+1,connected,length);
	}
	
	public static void getCoresLocation(int[][] a) {
		poweredcore = 0 ;
		for(int i = 0 ;i<n;i++) {
			for(int j = 0 ;j<n;j++) {
				if(i == 0 || i == n-1 || j == 0 || j==n-1 && a[i][j] == 1) {
					poweredcore++;
					continue;
				}
				if(a[i][j] == 1)cores.add(new Point(i,j));
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();
		
		for(int t = 1;t<=tc;t++) {
			n = sc.nextInt();
			cores = new ArrayList<>();
			res = new ArrayList<>();
			a = new int[n][n];
			for(int i = 0 ;i<n;i++) {
				for(int j =0 ;j<n;j++) {
					a[i][j] = sc.nextInt();
				}
			}
			//전선의 위치 받아오기
			getCoresLocation(a);
			simulate(0,poweredcore,0);
			Collections.sort(res);
			int ans = res.get(0).length;
			System.out.println("#" + t + " " + ans);
		}

	}

}
