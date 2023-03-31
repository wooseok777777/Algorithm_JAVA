package com.ssafy.combination;

import java.util.*;


public class Combination {
	static int n,m;
	static List<Integer> a;
	static List<Integer> res;
	
	
	public static void combination(int idx,int cnt , int r) {
		if(cnt == r) {
			System.out.println(res);
			return;
		}
		for(int i = idx ; i < n;i++) {
			res.add(a.get(i));
			combination(i + 1, cnt + 1, r);
			res.remove(res.size()-1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new ArrayList<>();
		res = new ArrayList<>();
		for(int i = 0 ;i<n;i++)a.add(i+1);
		combination(0, 0, m);
	}
}