package com.ssafy.BackTracking;

import java.util.*;
	
public class NQueen {
	static int N;
	static int col[]; // index가 행이다 행check x, col check + 대각선 check
	static int ans;
	
	//여기준으로 판단
	static void backtracking(int rowNo) {
		if(!isAvailable(rowNo)) return;
		if(rowNo == N) {
			ans++;
			return;
		}
		
		for(int i = 0 ;i<N;i++) {
			col[rowNo] = i;
			backtracking(rowNo + 1);
		}
	}
	
	private static boolean isAvailable(int rowNo) {
		for(int r = 0; r<rowNo;r++) {
			if(col[r] == col[rowNo - 1] || Math.abs(col[r] - col[rowNo - 1]) == Math.abs(rowNo -1 - r)) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N];
		backtracking(0);
		System.out.println(ans);
	}
}
