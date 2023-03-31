package com.ssafy.swea;
import java.util.*;

public class Solution_1238_D3_Contact_최우석 {
	static int n,start;
	static final int TC = 10;
	static final int N = 100;
	static List<List<Integer>> graph;
	static boolean[] v;
	
	static class Node{
		int node;
		int cnt;
		public Node(int node, int cnt) {
			super();
			this.node = node;
			this.cnt = cnt;
		}
	}
	public static int[] bfs(int start){
		int[] d = new int[N+1];
		ArrayDeque<Node> q = new ArrayDeque<>();
		q.add(new Node(start,0));
		v[start] = true;
		
		while(!q.isEmpty()) {
			Node now = q.pollFirst();
			d[now.node] = now.cnt;
			
			for(Integer next : graph.get(now.node)) {
				if(v[next])continue;
				v[next] = true;
			
				q.add(new Node(next,now.cnt+1));
			}
		}
		return d;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1 ;t<=TC;t++) {
			n = sc.nextInt();
			start = sc.nextInt();
			
			graph = new ArrayList<>();
			for(int i = 0 ;i<N+1;i++)
				graph.add(new ArrayList<>());
			v = new boolean[N+1];
		
			for(int i = 0 ;i<n/2;i++) {
				int from,to;
				from = sc.nextInt();
				to = sc.nextInt();
				graph.get(from).add(to);
			}
			int[] res = bfs(start);
			int maxcnt = Arrays.stream(res).max().getAsInt();
			List<Integer> endNodes = new ArrayList<>();
			for(int i = 0 ;i<N+1;i++) {
				if(res[i] == maxcnt)
					endNodes.add(i);
			}
			int ans = Collections.max(endNodes);
			
			System.out.println("#" + t + " " + ans);
		}
	}

}
