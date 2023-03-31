package com.ssafy.Pro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 공통조상 {
	static ArrayList<Integer> ancesterA;
	static ArrayList<Integer> ancesterB;
	static int[] parent;
	static boolean[] visited;
	static int cnt;
	static List<List<Integer>> graph;
	
	public static void dfs(int now) {
		if(visited[now])return;
		visited[now] = true;
		cnt++;
		for(Integer next : graph.get(now)) {
			dfs(next);
		}
	}
	public static void getParents(ArrayList<Integer> res,int now) {
		res.add(now);
		if(parent[now] == now) return;
		getParents(res,parent[now]);
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			cnt = 0;
			String[] S = br.readLine().split(" ");
			int v, e, a, b;
			
			v = Integer.parseInt(S[0]);
			e = Integer.parseInt(S[1]);
			a = Integer.parseInt(S[2]);
			b = Integer.parseInt(S[3]);
	
		
			graph = new ArrayList<>();
			ancesterA = new ArrayList<>();
			ancesterB = new ArrayList<>();
			
			for(int i = 0;i<v+1;i++)graph.add(new ArrayList<Integer>());
			
			parent = new int[v+1];
			visited = new boolean[v+1];
			for(int i = 0 ;i<v+1;i++)parent[i] = i;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < e; i++) {
				int p, c;
				p = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				graph.get(p).add(c);
				parent[c] = p;
			}
			
			getParents(ancesterA,a);
			getParents(ancesterB,b);
			Collections.reverse(ancesterA);
			Collections.reverse(ancesterB);
			
			int commonNode = 1; 
			for(int i = 0, n = Math.min(ancesterA.size(),ancesterB.size());i<n;i++) {
				if(ancesterA.get(i).equals(ancesterB.get(i))) {
					commonNode = ancesterA.get(i);
				}
			}
			dfs(commonNode);
			System.out.println("#"+t+" "+commonNode + " "+cnt);
		}
	}
}
