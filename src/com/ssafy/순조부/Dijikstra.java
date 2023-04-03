package com.ssafy.순조부;
import java.util.*;

public class Dijikstra {
	static final int INF = (int) 10e8;
	static int n,m;
	static List<List<int[]>> g;
	
	//                                            graph[i] = {edgecost,nextnode}, {} , {} ....
	public static int[] dijikstra(int start,int n,List<List<int[]>> graph) {
		int[] d = new int[n];
		Arrays.fill(d, INF);
		d[start] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[0] - o2[0]);
		pq.add(new int[] {0,start});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int cost = cur[0],node = cur[1];
			
			if(d[node] < cost)continue;
			
			for(int[] next : graph.get(node)) {
				int edgeCost = next[0];
				int nextNode = next[1];
				
				int nextCost = cost + edgeCost;
				if(nextCost < d[nextNode]) {
					d[nextNode] = nextCost;
					pq.add(new int[] {nextCost,nextNode});
				}
			}
		}
		
		return d;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		g = new ArrayList<>();
		for(int i = 0 ;i<n;i++)g.add(new ArrayList<>());
		
		for(int i = 0 ;i<m;i++) {
			int x,y,c;
			x = sc.nextInt();
			y = sc.nextInt();
			c = sc.nextInt();
			g.get(x).add(new int[] {c,y});
			g.get(y).add(new int[] {c,x});
		}
		
		int[] d = dijikstra(0, n, g);
		System.out.println(Arrays.toString(d));
	}

}
