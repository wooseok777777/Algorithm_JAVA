package com.ssafy.BOJ;
import java.util.*;

public class Main_17471_G4_게리맨더링_최우석 {
	static int n;
	static int[] population;
	static List<List<Integer>> graph;
	static List<Integer> res;
	
	static int acnt,bcnt;
	static boolean[] v;
	
	//갈 수 있는 총 Node를 Return
	static int dfs(int now,List<Integer> group) {
		if(v[now]) return 0;
		v[now] = true;
		int count = 1;

		for(Integer next : graph.get(now)) {
			if(!group.contains(next))continue;
			count += dfs(next,group);
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		population = new int[n];
		graph = new ArrayList<>();
		res = new ArrayList<>();
		for(int i = 0 ;i<n;i++)population[i] = sc.nextInt();
		for(int i = 0 ;i<n;i++)graph.add(new ArrayList<>());
		
		for(int i = 0 ;i<n;i++) {
			int m = sc.nextInt();
		
			for(int j = 0 ;j<m;j++) {
				int adjnode = sc.nextInt();
				adjnode--;
				graph.get(i).add(adjnode);
				graph.get(adjnode).add(i);
			}
		}
		
		// 전체 집합
		for(int s = 1 ;s < (1 << n) -1;s++) {
			
			//두 팀으로 나누기
			List<Integer> agroup = new ArrayList<>();
			List<Integer> bgroup = new ArrayList<>();
			for(int i = 0 ;i<n;i++) {
				if((s&1<<i)!=0) agroup.add(i);
				else bgroup.add(i);
			}
			
			//두팀의 dfs가 성공인지 확인
			
			v = new boolean[n];
			acnt = dfs(agroup.get(0),agroup);
			bcnt = dfs(bgroup.get(0),bgroup);

			//성공했다면 두 인구수의 차이
			if(acnt == agroup.size() && bcnt == bgroup.size()) { 
				int apopulation = 0;
				int bpopulation = 0;
				for(Integer a : agroup) {
					apopulation += population[a];
				}
				for(Integer b : bgroup) {
					bpopulation += population[b];
				}
				res.add(Math.abs(apopulation - bpopulation));
			}
		}
		
		if(res.isEmpty())System.out.println(-1);
		else System.out.println(Collections.min(res));
	}
}
