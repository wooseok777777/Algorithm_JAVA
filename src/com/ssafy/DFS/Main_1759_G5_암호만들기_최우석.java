package com.ssafy.DFS;
import java.util.*;

public class Main_1759_G5_암호만들기_최우석 {
	static int l,c;
	static List<String> a;
	static List<String> res;
	static String moum;
	
	public static void combination(int idx ,int cnt,int r) {
		if(cnt== r) {

			int zaum = 0;
			int moum = 0;
			for(String s : res) {
				if(s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u"))moum++;
				else zaum++;
			}
			
			if(moum >=1 && zaum>=2) {
				String ans = "";
				for(String s : res)ans+=s;
				System.out.println(ans);
			}
			return;
		}
		for(int i = idx;i<a.size();i++) {
			res.add(a.get(i));
			combination(i+1, cnt+1, r);
			res.remove(res.size()-1);
		}
	}
	public static void main(String[] args) {
		moum = "aeiou";
		Scanner sc = new Scanner(System.in);
		l = sc.nextInt();
		c = sc.nextInt();
		a = new ArrayList<>();
		res = new ArrayList<>();
		
		for(int i = 0 ;i<c;i++)
			a.add(sc.next());
	
		Collections.sort(a);
		combination(0, 0, l);
		
	}
}
