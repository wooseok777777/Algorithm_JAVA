package com.ssafy.swea;
import java.util.*;

public class Solution_0220_요리사_최우석 {
	static int tc;
	static int a[][];
	static List<Integer> res;
	static int n;
	
	static int getScore(List<Integer> food) {
		int sum = 0;
		int n = food.size();
		for(Integer foodnum1 : food) {
			for(Integer foodnum2 : food) {
				sum += a[foodnum1][foodnum2];
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();
		for(int t = 1 ; t<=tc;t++) {
			res = new ArrayList<>();
			n = sc.nextInt();
			a = new int[n][n];
			for(int i = 0;i<n;i++) {
				for(int j =0;j<n;j++) {
					a[i][j] = sc.nextInt();
				}
			}
			
			for(int s = 1;s<1<<n-1;s++) {
				ArrayList<Integer> food1 = new ArrayList<>();
				ArrayList<Integer> food2 = new ArrayList<>();
				for(int i = 0 ;i<n;i++) {
					if((s & 1<<i)!=0)food1.add(i);
					else food2.add(i);
				}
				
				int food1Score = getScore(food1);
				int food2Score = getScore(food2);
				
				res.add(Math.abs(food1Score - food2Score));
			}
			int ans = Collections.min(res);
			System.out.println("#"+t + " "+ans);
		}
	}
}
