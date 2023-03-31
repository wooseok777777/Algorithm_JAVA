package com.ssafy.permutation;
import java.util.*;

public class Permutation {
	static int n,m;
	static List<Integer> a;
	static List<Integer> res;
	
	public static void permutation(int cnt , int r, int flag) {
		if(cnt == r) {
			System.out.println(res);
			return;
		}
		for(int i = 0 ;i<n;i++) {
			if((flag & 1 << i)!=0)continue;
			res.add(a.get(i));
			permutation(cnt + 1 , r, flag | 1 << i);
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
		
		permutation(0,m,0);
	}
}
