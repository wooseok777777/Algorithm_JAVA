package com.ssafy.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2098_S3_외판원순회_최우석 {
	static int n, ans;
	static long[][] w,d;
	static final int INF = 1000000 * 16;
	static int FINISH;
	// now node =  0
	// d[now][visited] = Current place : now , visited : route seen so far
	public static long dfs(int now,int visited) {
		if(visited == FINISH) {
			if(w[now][0] > 0 )return w[now][0];
			return INF;
		}
		
		if(d[now][visited] != 0) return d[now][visited];
		
		d[now][visited] = INF;
		
		for(int i = 1 ;i<n;i++) {
			if((visited & (1<<i)) != 0 || w[now][i] == 0)continue;
			d[now][visited] = Math.min(d[now][visited], dfs(i,visited | 1 << i) + w[now][i]);
		}
		
		return d[now][visited];
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		w = new long[n][n];
		d = new long[n][1 << n];
		FINISH = (1 << n) - 1;
		StringTokenizer st;
		for(int i = 0 ;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0 ;j<n;j++) {
				w[i][j] =  Integer.valueOf(st.nextToken());
			}
		}
		
		System.out.println(dfs(0,1));
	}

}
