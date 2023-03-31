package com.ssafy.Dijkstra;
import java.util.*;

public class Main_1753_G4_최단경로_최우석 {
	static int n,m,start;
	static List<List<Edge>> g;
	
	static class Edge{
		int node;
		int cost;
		public Edge(int node, int cost) {
			super();
			this.node = node;
			this.cost = cost;
		}
	}
	
	static int[] dijkstra(int start) {
		int[] d = new int[n+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		d[start] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.cost, o2.cost));
		pq.add(new Edge(start,0));
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if(d[now.node] < now.cost) continue;
			
			for(Edge next : g.get(now.node)) {
				int nextCost = now.cost + next.cost;
				
				if(nextCost < d[next.node]) {
					d[next.node] = nextCost;
					pq.add(new Edge(next.node,nextCost));
				}
			}
		}
		return d;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();
		g = new ArrayList<>();
		for(int i = 0 ;i<n+1;i++)g.add(new ArrayList<>());
		
		for(int i = 0 ;i<m;i++) {
			int u,v,c;
			u = sc.nextInt();
			v = sc.nextInt();
			c = sc.nextInt();
			g.get(u).add(new Edge(v,c));
		}
		
		int[] dists = dijkstra(start);
		for(int i = 1;i<=n;i++) {
			if(dists[i] == Integer.MAX_VALUE)System.out.println("INF");
			else System.out.println(dists[i]);
		}
	}
}
