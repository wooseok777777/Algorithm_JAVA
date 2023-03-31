package com.ssafy.BruteForce;

import java.util.*;

public class Main_1158_S4_요세푸스문제_최우석 {
	static Scanner sc = new Scanner(System.in);
	static List<Integer> a = new LinkedList<>();
	static ArrayList<Integer> res = new ArrayList<>();
	
	static int n,k;
	
	public static void main(String[] args) {
		n = sc.nextInt();
		k = sc.nextInt();
		a = new ArrayList<>();
		for(int i = 1;i<=n;i++)a.add(i);
		
		int idx = 0;
		while(!a.isEmpty()) {
			idx += k -1;
			idx %= a.size();
			int pop = a.remove(idx);
			res.add(pop);
		}
		String out = res.toString();
		
		out = out.replace('[', '<');
		out = out.replace(']', '>');
		System.out.println(out);
	}
}
