package com.ssafy.BruteForce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
	
	public static Scanner sc = new Scanner(System.in);
	public static List<Integer> a = new ArrayList<>();
	public static List<Integer> res = new ArrayList<>();
	public static boolean[] v;
	//permutation
	public static void p(int cnt,int r) {
		//answer
		if(cnt == r) {
			System.out.println(res);
			return;
		}
		
		for(int i = 0 ;i<a.size();i++){
			if(v[i])continue;
			v[i] = true;
			res.add(a.get(i));
			p(cnt+1,r);
			res.remove(res.size()-1);
			v[i] = false;
		}
	}
	//permutation with replacement
	public static void p2(int cnt,int r) {
		//answer
		if(cnt == r) {
			System.out.println(res);
			return;
		}
		
		for(int i = 0 ;i<a.size();i++){
			res.add(a.get(i));
			p2(cnt+1,r);
			res.remove(res.size()-1);
		}
	}
	
	//combination
	public static void c(int idx,int cnt,int r) {
		if(cnt == r) {
			System.out.println(res);
			return;
		}
		for(int i = idx;i<a.size();i++) {
			res.add(a.get(i));
			c(i+1,cnt+1,r);
			res.remove(res.size()-1);
		}
	}
	
	//combination2
		public static void comb(int idx,int cnt,int r) {
			if(cnt == r) {
				System.out.println(res);
				return;
			}
			if(idx == a.size()) return;
			
			//뽑기
			res.add(a.get(idx));
			comb(idx+1,cnt+1,r);
			res.remove(res.size()-1);
			
			//안뽑기
			comb(idx+1,cnt,r);
		}
	//combination with replacement
	public static void c2(int idx,int cnt,int r) {
		if(cnt == r) {
			System.out.println(res);
			return;
		}
		for(int i = idx;i<a.size();i++) {
			res.add(a.get(i));
			c2(i,cnt+1,r);
			res.remove(res.size()-1);
		}
	}
	public static void main(String[] args) {
		System.out.print("뽑을 1부터 n 까지 입력 :" );
		int n = sc.nextInt();
		System.out.print("뽑을 개수 입력 : ");
		int r = sc.nextInt();
		System.out.println();
		for(int i =1;i<=n;i++)a.add(i);
		v = new boolean[n];
		
		comb(0,0,r);
	}
}
