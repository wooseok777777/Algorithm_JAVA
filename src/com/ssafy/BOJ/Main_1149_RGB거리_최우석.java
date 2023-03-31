package com.ssafy.BOJ;
import java.util.*;

public class Main_1149_RGB거리_최우석 {
	static final int N = 3;
	static int n;
	static int[][] a,d;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n][N];
		d = new int[n][N];
		
		for(int i = 0 ;i<n;i++) {
			for(int j = 0 ;j<N;j++) {
				a[i][j] = sc.nextInt();
			}
		}
		for(int j = 0 ;j<N;j++)
			d[0][j] = a[0][j];
		
		for(int i = 1;i<n;i++) {
			d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + a[i][0];
			d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + a[i][1];
			d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + a[i][2];
		}
		int ans = Math.min(d[n-1][0], d[n-1][1]);
		ans = Math.min(ans, d[n-1][2]);
		System.out.println(ans);
	}

}
