package com.ssafy.BOJ;

import java.util.Scanner;

public class Main_1074_S1_Z_최우석 {
	
	static int row,col;
	static int n;
	static int ans;
	
	public static void solve(int y ,int x ,int n,int startnumber) {
		if(n == 1) {
			if(y == row && x == col) {
				ans = startnumber;
			}
			return;
		}
		
		int t = n >> 1;
		if(y <= row && row < y + t && x<=col && col < x + t)solve(y,x,t,startnumber);
		else if(y <= row && row < y + t && x + t<=col && col < x + n)solve(y,x+t,t,startnumber + t*t);
		else if(y + t<= row && row < y + n && x<=col && col < x + t)solve(y+t,x,t,startnumber + t *t*2);
		else if(y + t<= row && row < y + n && x + t<=col && col < x + n)solve(y+t,x+t,t,startnumber + t*t*3);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		row = sc.nextInt();
		col = sc.nextInt();
		solve(0,0,(int)Math.pow(2,n),0);
		System.out.println(ans);
	}

}
