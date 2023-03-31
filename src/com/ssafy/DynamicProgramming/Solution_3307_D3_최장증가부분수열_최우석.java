package com.ssafy.DynamicProgramming;

import java.util.*;

public class Solution_3307_D3_최장증가부분수열_최우석 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1 ; t<= tc; t++) {
			int n = sc.nextInt();
			int[] a = new int[n];
	
			for(int i = 0 ;i<n;i++) {
				a[i] = sc.nextInt();
			}
			List<Integer> result = new ArrayList<>();
			
			for(int i = 0 ;i<n;i++) {
				if(result.isEmpty() || result.get(result.size()-1) < a[i]) {
					result.add(a[i]);
				}
				int idx = Collections.binarySearch(result, a[i]);
				if(idx < 0) {
					idx = -1*idx - 1;
				}
				result.set(idx, a[i]);
			}
			
			System.out.printf("#%d %d\n",t,result.size());
		}
		
	}
}
