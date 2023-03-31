package com.ssafy.swea;
import java.util.*;

public class Solution_9229_D3_한빈이와SpotMart_최우석 {
	
	static List<Integer> res,a,resultSum;
	static int n,m;
	
	public static void comb(int idx,int cnt,int r) {
		if(cnt == r) {
			int s = 0;
			for(Integer x : res)s+=x;
			if(s <=m)resultSum.add(s);
			return;
		}
		if(idx == n)return;
		
		//select
		res.add(a.get(idx));
		comb(idx+1,cnt+1,r);
		res.remove(res.size()-1);
		//not select
		comb(idx+1,cnt,r);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1;t<=tc;t++) {

			n = sc.nextInt();
			m = sc.nextInt();
			a = new ArrayList<>();
			res = new ArrayList<>();
			resultSum = new ArrayList<>();
			for(int i = 0 ;i<n;i++)a.add(sc.nextInt());
			
			comb(0,0,2);
			if(resultSum.size() == 0)System.out.println("#"+t + " " + -1);
			else{
				int ans = Collections.max(resultSum);
				System.out.println("#"+t + " " + ans);
			}

		}
	}
}
