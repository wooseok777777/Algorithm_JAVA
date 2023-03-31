package com.ssafy.swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_3124_D4_최소스패닝트리_최우석 {
	static int tc;
	static List<List<Edge>> graph;
	static int n,m;
	static boolean[] visited;
	
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		long cost;
		public Edge(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return (int) (this.cost - o.cost);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t = 1 ;t<=tc;t++) {
			st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			graph = new ArrayList<>();
			visited = new boolean[n+1];
			
			for(int i = 0 ;i<n+1;i++)graph.add(new ArrayList<>());
			for(int i = 0 ;i<m;i++) {
				st = new StringTokenizer(br.readLine()," ");
				int from,to,cost;
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				cost = Integer.parseInt(st.nextToken());
				graph.get(from).add(new Edge(from,to,cost));
				graph.get(to).add(new Edge(to,from,cost));
			}
			
			long cost = 0;
			int cnt = 1;
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.addAll(graph.get(1));
			visited[1] = true;
			
			
			while(cnt!=n) {
				Edge now = pq.poll();
				if(visited[now.to])continue;
				
				cost += now.cost;
				pq.addAll(graph.get(now.to));
				visited[now.to] = true;
				cnt++;
			}
			System.out.println("#"+t+" "+cost);
		}
	}
}
