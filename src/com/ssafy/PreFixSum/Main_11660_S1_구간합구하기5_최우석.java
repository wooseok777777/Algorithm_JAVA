package com.ssafy.PreFixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_11660_S1_구간합구하기5_최우석 {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int q;
	static int[][] a;
	static int[][] d;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		a = new int[n+1][n+1];
		d = new int[n+1][n+1];
		for(int i = 1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ;j<=n;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i =1;i<=n;i++) {
			for(int j =1;j<=n;j++) {
				d[i][j] = d[i-1][j] + d[i][j-1] - d[i-1][j-1] + a[i][j];
			}
		}
		
		for(int i = 0;i<q;i++){
			int y1,x1,y2,x2;
			st = new StringTokenizer(br.readLine());
			y1 = Integer.parseInt(st.nextToken());
			x1 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			int ans = d[y2][x2] - d[y1-1][x2] - d[y2][x1-1] + d[y1-1][x1-1];
			System.out.println(ans);
		}
	}
}
