package com.ssafy.Pro;
import java.util.*;

public class 축구전술 {
	static int tc;
	static int n,m;
	static int[] parents;
	static int id;
	static boolean[] finished;
	static Stack<Integer> stack;
	static List<List<Integer>> graph;
	static List<List<Integer>> SCC;
	
	static int dfs(int x) {
		parents[x] = ++id;
		stack.add(x);
		int parent = parents[x];
		
		for(Integer child : graph.get(x)) {
			if(parents[child] == 0) {
				parent = Math.min(parent,dfs(child));
			}else if(!finished[child]) {
				parent = Math.min(parent, parents[child]);
			}
		}
		
		if(parent == parents[x]) {
			List<Integer> scc = new ArrayList<>();
			while(true) {
				int top = stack.pop();
				scc.add(top);
				parents[top] = parent;
				finished[top] = true;
				if(top == x)break;
			}
			SCC.add(scc);
		}
		return parent;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();
		while(tc-- != 0) {
			id = 0;
			n = sc.nextInt();
			m = sc.nextInt();
			parents = new int[n];
			graph = new ArrayList<>();
			SCC = new ArrayList<>();
			finished = new boolean[n];
			stack = new Stack<>();
			
			for(int i = 0 ;i<n;i++) graph.add(new ArrayList<>());
			for(int i = 0 ;i<m;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				graph.get(a).add(b);
			}
			
			for(int i = 0 ;i<n;i++) {
				if(parents[i]!=0)continue;
				dfs(i);
			}
			
			for(int i = 0 ;i<n;i++) {
				System.out.println(graph.get(i));
			}
		}
		
	}
}
