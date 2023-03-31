package com.ssafy.BOJ;
import java.util.*;

public class Main_3040_B2_최우석 {
	static List<Integer> res = new ArrayList<>();
	static List<Integer> a = new ArrayList<>();
	
	public static void combination(int idx,int cnt,int r) {
		if(cnt == r) {
			int sum = 0;
			for(Integer i : res) {
				sum+=i;
			}
			if(sum == 100) {
				for(Integer i : res) {
					System.out.println(i);
				}
				System.exit(0);
			}
			return;
		}
		for(int i = idx;i<a.size();i++) {
			res.add(a.get(i));
			combination(i+1,cnt+1,r);
			res.remove(res.size()-1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0 ;i<9;i++)a.add(sc.nextInt());
		combination(0, 0, 7);
		
	}
}
