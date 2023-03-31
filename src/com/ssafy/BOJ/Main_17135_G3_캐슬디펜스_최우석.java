package com.ssafy.BOJ;
import java.util.*;

public class Main_17135_G3_캐슬디펜스_최우석 {
	static int n,m,d;
	static final int R = 3;
	static int[][] map;
	static List<Integer> archers;
	static List<Integer> selectedArchers;
	static List<Integer> res;
	static Comparator<Info> comp;
	
	public static class Point{
		int y;
		int x;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	public static class Info{
		public int dist;
		public Point point;
		public Info(int dist, Point point) {
			super();
			this.dist = dist;
			this.point = point;
		}	
	}
	
	static int mDist(Point p1,Point p2) {
		return Math.abs(p1.y-p2.y) + Math.abs(p1.x - p2.x);
	}
	
	static void combination(int idx,int cnt,int r) {
		if(cnt == r) {
			res.add(simulate(selectedArchers));
			return;
		}
	
		for(int i = idx;i<archers.size();i++) {
			selectedArchers.add(archers.get(i));
			combination(i+1, cnt+1, r);
			selectedArchers.remove(selectedArchers.size()-1);
		}
	}
	
	static List<Point> getEnemyPoints(int[][] map){
		List<Point> enemyPoints = new ArrayList<>();
		for(int i = 0 ;i<n;i++) {
			for(int j =0 ;j<m;j++) {
				if(map[i][j] == 1)
					enemyPoints.add(new Point(i,j));
			}
		}
		return enemyPoints;
	}
	

	static int simulate(List<Integer> selectedArchers) {
		int killed = 0;
		//copy map for simulation
		int[][] cpymap = new int[n][m];
		for(int i = 0 ;i<n;i++) {
			for(int j = 0 ;j<m;j++) {
				cpymap[i][j] = map[i][j];
			}
		}
		List<Point> archersPoints = new ArrayList<>();
		
		for(Integer x : selectedArchers)
			archersPoints.add(new Point(n,x));
		

		for(int time = 0;time < n;time++) {
	
			List<Point> enemys = getEnemyPoints(cpymap);
			List<Point> deadEnemy = new ArrayList<>(); //이번에 죽일애들

			for(Point archer : archersPoints) {	
				List<Info> killpoint = new ArrayList<>();
				for(Point enemy : enemys) {
					int mdist = mDist(archer,enemy);
					if(mdist <= d) {
						killpoint.add(new Info(mdist,enemy));
					}
	
				}
				if(killpoint.isEmpty())continue;
				killpoint.sort(comp);
				deadEnemy.add(killpoint.get(0).point);
			}
			// kill
			for(Point killspot : deadEnemy) {
				int y = killspot.y;
				int x = killspot.x;

				if(cpymap[y][x] == 1) {
					killed++;
					cpymap[y][x] = 0;
				}
			}
			
			//  move
			int[][] tmp = new int[n][m];
			for(int i = 0;i<n;i++) {
				for(int j = 0 ;j<m;j++) {
					if(i + 1 == n)continue;
					tmp[i + 1][j] = cpymap[i][j];
				}
			}
			for(int i = 0 ;i<n;i++) {
				for(int j = 0 ;j<m;j++) {
					cpymap[i][j] = tmp[i][j];
				}
			}
		}

		return killed;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		d = sc.nextInt();
		map = new int[n][m];
		archers = new ArrayList<>();
		selectedArchers = new ArrayList<>();
		res = new ArrayList<>();
		for(int i = 0 ;i<m;i++)archers.add(i);
		for(int i = 0 ;i<n;i++) {
			for(int j =0  ;j<m;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		comp = new Comparator<Info>() {
			@Override
			public int compare(Info o1, Info o2) {
				// TODO Auto-generated method stub
				return o1.dist!=o2.dist ? o1.dist - o2.dist : o1.point.x - o2.point.x;
			}
		};
		
		combination(0, 0, R);
		System.out.println(Collections.max(res));
	}
}
