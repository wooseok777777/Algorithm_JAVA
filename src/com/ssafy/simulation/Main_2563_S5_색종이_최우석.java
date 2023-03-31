package com.ssafy.simulation;

import java.util.Scanner;

public class Main_2563_S5_색종이_최우석 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] a = new int[101][101];
		int k = sc.nextInt();
		int n = 10;
		for(int t = 0 ;t<k;t++) {
			int x,y;
			x = sc.nextInt();
			y = sc.nextInt();
			
			for(int i = x ;i<x+n;i++) {
				for(int j = y;j<y+n;j++) {
					a[i][j] = 1;
				}
			}
		}
		int ans = 0;
		for(int i =1;i<=100;i++) {
			for(int j =1;j<=100;j++) {
				ans+=a[i][j];
			}
		}
		System.out.println(ans);
	}
}
