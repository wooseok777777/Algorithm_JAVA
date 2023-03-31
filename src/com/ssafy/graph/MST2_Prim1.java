package com.ssafy.graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MST2_Prim1 {
	static int n;
	static int[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new int[n][n];
		visited = new boolean[n];
		
		StringTokenizer st;
		for(int i = 0 ;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ;j<n;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//선택된 정점을 저장하는 list
		ArrayList<Integer> selected = new ArrayList<>();
		int index;
		int min;  // 갈 수 있는 edge 중에서 최소값
		int result = 0; // MST 값
		
		//0 번 정점선택해서 찾기 시작함.
		selected.add(0);
		visited[0] = true;
		//모든 정점 개수만큼 반복
		for(int i = 0 ;i<n - 1;i++) {
			min = Integer.MAX_VALUE;
			index = 0;
			
			for(Integer v : selected) {
				for(int j = 0 ;j<n;j++) {
					if(graph[v][j]!=0 && !visited[j] && graph[v][j] < min) {
						min = graph[v][j];
						index = j;
					}
				}
			}

			result += min;
			selected.add(index);
			visited[index] = true;
		}
		System.out.println("min : " + result);
		System.out.println(selected);
	}

}
