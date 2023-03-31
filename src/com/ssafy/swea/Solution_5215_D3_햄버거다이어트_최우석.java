package com.ssafy.swea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution_5215_D3_햄버거다이어트_최우석 {
	
	public static void solveByknapsack_0_1() {
		Scanner sc= new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1 ;t<=tc;t++) {
			int n,m;
			n = sc.nextInt();
			m = sc.nextInt();
			
			int[][] d = new int[n+1][m+1];
			List<Integer> c = new ArrayList<Integer>();
			List<Integer> v = new ArrayList<Integer>();
			c.add(0);
			v.add(0);
			
			for(int i = 0 ;i<n;i++) {
				int cost,volume;
				cost = sc.nextInt();
				volume = sc.nextInt();
				c.add(cost);
				v.add(volume);
			}
			
			for(int i = 1;i<=n;i++) {
				for(int j = 0;j<=m;j++) {
					d[i][j] = d[i-1][j];
					if(j - v.get(i) >= 0) {
						d[i][j] = Math.max(d[i][j],d[i-1][j-v.get(i)] + c.get(i));
					}
				}
			}
			System.out.println("#" + t + " " + d[n][m]);
		}
		sc.close();
	}
	
	public static void swap(int[] a,int i,int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public static boolean next_permutation(int[] a) {
		int n = a.length;
		int i = n-1;
		
		//꼭지점 찾기
		while(i>0 && a[i-1] >= a[i])i--;
		if(i==0)return false;
		
		//swap i-1 오른쪽 j 찾기
		int j = n-1;
		while(a[i-1] >= a[j])j--;
		
		//swap i-1 , j
		swap(a,i-1,j);
		
		//오른쪽 정렬
		int k = n-1;
		while(i < k) swap(a,i++,k--);
		
		return true;
	}
	public static void solveBycombination() {
		Scanner sc= new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1 ;t<=tc;t++) {
			int n,m;
			n = sc.nextInt();
			m = sc.nextInt();
			
			List<Integer> c = new ArrayList<Integer>();
			List<Integer> v = new ArrayList<Integer>();
			int[] a = new int[n];
			
			// 1~n개 까지 선택해보기
			for(int choice = 1;choice <=n;choice++) {
				
				//1 선택 0비선택

				for(int i = 0 ;i<n - choice;i++)a[i] = 0;
				for(int i = 0 ;i<choice;i++)a[i] = 1;
				
				Arrays.sort(a);
				
				
				do {
					System.out.println(Arrays.toString(a));
				}while(next_permutation(a));
			}
			
			
		}
		sc.close();
	}
	public static void main(String[] args) {
		//solveByknapsack_0_1();
		solveBycombination();
	}

}
