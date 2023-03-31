package com.ssafy.BFS;

import java.util.*;

public class AdjMatrixTest {

	static List<List<Integer>> graph;
	static int n,m;
	
	static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] v = new boolean[n];
		Arrays.fill(v, false);
		
		v[start] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			System.out.println((char)(now + 65));
			
			for(Integer child : graph.get(now)) {
				if(v[child])continue;
				v[child] = true;
				q.add(child);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		graph = new ArrayList<>();
		for(int i = 0 ;i<n;i++)graph.add(new ArrayList<Integer>());
		
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		
		bfs(0);
	}
	
	
}