package com.ssafy.BOJ;
import java.util.*;

public class Main_16236_G5_아기상어_최우석{
	static int n;
	static int[][] a;
	static int anstime = 0;
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
	static int sy,sx,sharksize,sharkeat;
	
	public static class Info implements Comparable<Info>{
		int time;
		int y;
		int x;
		public Info(int time, int y, int x) {
			super();
			this.time = time;
			this.y = y;
			this.x = x;
		}
		@Override
		public int compareTo(Info o) {
			return time != o.time ? time - o.time : y != o.y ? y - o.y : x != o.x ? x - o.x : 1;
		}
	}
	
	public static boolean inside(int y ,int x) {
		return 0<=y && y<n && 0<=x && x <n;
	}
	
	public static List<Info> search(int sy,int sx) {
		List<Info> fishList = new ArrayList<>();
		ArrayDeque<Info> q = new ArrayDeque<>();
		q.add(new Info(0,sy,sx));
		boolean[][] v = new boolean[n][n];
		v[sy][sx] = true;
		
		while(!q.isEmpty()) {
			Info now = q.poll();
			
			if(a[now.y][now.x]!=0) {
				fishList.add(new Info(now.time,now.y,now.x));
			}
			
			for(int k = 0;k<4;k++) {
				int ny = now.y + dy[k];
				int nx = now.x + dx[k];
				if(!inside(ny,nx))continue;
				if(v[ny][nx])continue;
				if(sharksize < a[ny][nx])continue;
				v[ny][nx] = true;
				q.add(new Info(now.time + 1,ny,nx));
			}
		}
		return fishList;
	}
	
	//시뮬레이션
	public static void simulate() {
		while(true){
			//생선 위치들 찾기
			List<Info> fishlist = search(sy,sx);
			if(fishlist.isEmpty())break;
			//생선 먹기
			if (eatFish(fishlist))continue;
			else break;
		}
	}
	
	public static boolean eatFish(List<Info> fishList) {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.addAll(fishList);
		
		while(!pq.isEmpty()) {
			Info fish = pq.poll();
			
			if(a[fish.y][fish.x] < sharksize) {
				sharkeat++;
				if(sharkeat == sharksize) {
					sharksize++;
					sharkeat = 0;
				}
				a[fish.y][fish.x] = 0;
				sy = fish.y;
				sx = fish.x;
				anstime += fish.time;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n][n];
		sharksize = 2;
		sharkeat = 0;
		
		for(int i = 0 ;i<n;i++) {
			for(int j = 0 ;j<n;j++) {
				a[i][j] = sc.nextInt();
				if(a[i][j] == 9) {
					sy = i;
					sx = j;
					a[i][j] = 0;
				}
			}
		}
		
		simulate();
		System.out.println(anstime);
	}
}
