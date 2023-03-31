package com.ssafy.BFS;
import java.awt.Point;
import java.util.*;

public class BFS {
	

	static List<List<Integer>> graph;
	static int n,m;
	
	public static void bfs(int start) {
		boolean[] v = new boolean[n];
		v[start] = true;
		Queue<Point> q= new ArrayDeque<>();
		q.add(new Point(start,0));
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			int now = cur.x;
			int cost = cur.y;
			
			for(Integer child : graph.get(now)) {
				if(v[child])continue;
				v[child] = true;
				q.add(new Point(child,cost+1));
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		graph = new ArrayList<>();
		for(int i = 0 ;i<n;i++)graph.add(new ArrayList<>());
		
		for(int i = 0 ;i<m;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		
	}
}
