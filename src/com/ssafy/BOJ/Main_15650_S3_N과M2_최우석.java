package com.ssafy.BOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_15650_S3_N과M2_최우석 {
	public static List<Integer> a = new ArrayList<>();
	public static List<Integer> res = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);
	public static int r = 0;
	public static int n = 0;
	
	
	public static void rec(int idx, int cnt, int r) {
		if (cnt == r) {
			for (Integer x : res)
				System.out.print(x + " ");
			System.out.println();
			return;
		}
		if (idx == n)
			return;
		res.add(a.get(idx));
		rec(idx + 1, cnt + 1, r);
		res.remove(res.size() - 1);
		rec(idx + 1, cnt, r);
	}
	
	public static void rec2(int idx, int cnt, int r) {
		if (cnt == r) {
			for (Integer x : res)
				System.out.print(x + " ");
			System.out.println();
			return;
		}
		for(int i = idx;i<n;i++) {
			res.add(a.get(i));
			rec2(i+1,cnt+1,r);
			res.remove(res.size()-1);
		}
	}
	public static void main(String[] args) {
		n = sc.nextInt();
		r = sc.nextInt();
		for (int i = 1; i <= n; i++)
			a.add(i);
		rec2(0, 0, r);
	}

}
