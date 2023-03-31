package com.ssafy.BOJ;
import java.util.*;

public class Main_15686_G5_치킨거리_최우석 {
	static class Point{
		public int y;
		public int x;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}	
	}
	static int n,m;
	static Scanner sc = new Scanner(System.in);
	static int [][] a;
	static List<Point> chickens = new ArrayList<>(); 
	static List<Point> stores = new ArrayList<>();
	static List<Point> res = new ArrayList<>();
	static List<Integer> ansList = new ArrayList<>();

	public static int dist(Point p1,Point p2) {
		return Math.abs(p1.y - p2.y) + Math.abs(p1.x - p2.x);
	}
	
	public static void comb(int idx,int cnt,int r) {
		if(cnt == r) {
			int sum = 0;
			for(Point store : stores) {
				List<Integer> dists =new ArrayList<>();
				
				for(Point c : res) {
					dists.add(dist(store,c));
				}
				sum += Collections.min(dists);
			}
			ansList.add(sum);
			return;
		}
		
		if(idx == chickens.size())return;
		
		res.add(chickens.get(idx));
		comb(idx+1,cnt+1,r);
		res.remove(res.size()-1);
		comb(idx+1, cnt, r);
		
	}
	
	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n][n];
		for(int i = 0 ;i<n;i++) {
			for(int j = 0 ;j<n;j++) {
				a[i][j] = sc.nextInt();
				if(a[i][j] == 1)stores.add(new Point(i,j));
				if(a[i][j] == 2)chickens.add(new Point(i,j));
			}
		}
		
		for(int s = 1;s<=m;s++) {
			comb(0,0,s);
		}
		System.out.println(Collections.min(ansList));
	}
	
}
