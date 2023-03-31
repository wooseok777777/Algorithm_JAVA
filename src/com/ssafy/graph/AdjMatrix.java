package com.ssafy.graph;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AdjMatrix {
	
	static boolean map[][];
	static boolean visited[];
	static int n;
	
	static void dfs(int now) {
		if(visited[now])return;
		visited[now] = true;
		System.out.printf("%c -> ",now + 'A');
		for(int j = 0 ;j<n;j++) {
			if(!map[now][j])continue;
			dfs(j);
		}
		
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/AdjMatrix.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1 ; tc<=T;tc++) {
			n = Integer.parseInt(in.readLine());
			map = new boolean[n][n];
			visited = new boolean[n];
			
			for(int i = 0 ;i<n;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine()," ");
				for(int j = 0;j<n;j++) {
					if(Integer.parseInt(st.nextToken())== 1)map[i][j] = true;
					else map[i][j] = false;
					
				}
			}
			
			dfs(0);
			System.out.println();
		}
	}

	private static void bfs(int cur) {
		Deque<Integer> q = new ArrayDeque<Integer>();
		visited[cur] = true;
		q.add(cur);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			System.out.printf("%c -> ",now + 'A');
			
			for(int i = 0 ;i<n;i++) {
				if(map[now][i] == true && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
	}

}
