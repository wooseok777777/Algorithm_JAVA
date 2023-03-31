package com.ssafy.recursive;

import java.util.ArrayList;

public class RecursiveCallTest4 {
	public static ArrayList<Integer> a = new ArrayList<>();
	
	public static ArrayList<Integer> res = new ArrayList<>();
	
	public static void comb(int idx,int cnt) {
		if(idx == a.size())return;
		
		if(cnt == res.size()) {
			System.out.println(res);
			return;
		}
		
		
		res.add(a.get(idx));
		comb(idx+1,cnt+1);
		res.remove(res.size()-1);
		comb(idx+1,cnt);
	}
	public static void main(String[] args) {
		for(int i = 1;i<=10;i++)a.add(i);
		comb(0,3);
	}
	
}
