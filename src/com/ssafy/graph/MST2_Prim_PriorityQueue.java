package com.ssafy.graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MST2_Prim_PriorityQueue {
	static int n,m;
	static ArrayList<ArrayList<Edge>> adj;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n];
		adj = new ArrayList<>();
		for(int i = 0 ;i<n;i++)adj.add(new ArrayList<>());
		
		for(int i =0 ; i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj.get(a).add(new Edge(a,b,c));
			adj.get(b).add(new Edge(b,a,c));
		}
		//선택된 정점들에서 갈 수 있는 모든 Edge를 저장할 PrioirtyQueue
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		
		int cnt = 1;  // 선택된 vertex count
		int result = 0; // MST 값
		
		//선택된 임의의 정점에서 갈 수 있는 모든 정점의 Edge pq에다가 담기
		
		pq.addAll(adj.get(0)); //선택한 0번정점의 모든 edge를 저장
		
		visited[0] = true;//0번 정점 방문체크
		//모든 정점 개수만큼 반복
		while(cnt!=n) {
			Edge now = pq.poll();
			if(visited[now.to]) continue;	
			pq.addAll(adj.get(now.to));
			result += now.weight;
			visited[now.to] = true;
			cnt++;
		}
		System.out.println("min : " + result);

	}

}
