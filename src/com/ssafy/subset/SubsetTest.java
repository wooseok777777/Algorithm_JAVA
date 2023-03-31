package com.ssafy.subset;

import java.util.*;

public class SubsetTest {
	static List<Integer> a = new ArrayList<>();
	static List<List<Integer>> res = new ArrayList<>();
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		n = sc.nextInt();

		for (int i = 0; i < n; i++)
			a.add(rand.nextInt(100));

		System.out.print("전체 원소 : ");
		System.out.println(a);
		System.out.print("전체 부분 집합들 : ");

		for(int s = 0 ;s < 1 << n; s ++ ) {
			List<Integer> subset = new ArrayList<>();
			for(int i = 0 ;i <n;i++) {
				if((s & 1 << i)!=0)subset.add(a.get(i));
			}
			res.add(subset);
		}
		
		System.out.println(res);
	}
}
