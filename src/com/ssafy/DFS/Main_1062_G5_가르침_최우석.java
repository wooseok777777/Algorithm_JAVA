package com.ssafy.DFS;
import java.util.*;

public class Main_1062_G5_가르침_최우석 {
	static int n,k;
	static List<String> a;
	static List<Character> alpha;
	static List<Character> res;
	static List<Integer> ansList;
	static int innerflag = 0;
	static final char[] inner = {'a','n','t','i','c'};
	
	public static void combination(int idx ,int cnt ,int r) {
		if(cnt == k - 5) {
			int count = 0;
			int flag = innerflag;
			for(char c : res) {
				flag |= 1<<c-'a';
			}
			
			for(String s : a) {
				char[] subs = s.substring(4, s.length()-4).toCharArray();
				int subflag = 0;
				for(char c : subs) {
					subflag |= 1 << c -'a';
				}
				if((flag & subflag) == subflag)
					count++;
			}
			ansList.add(count);
			return;
		}
		for(int i = idx;i<alpha.size();i++) {
			res.add(alpha.get(i));
			combination(i+1, cnt+1, r);
			res.remove(res.size()-1);
		}
	}
	public static void main(String[] args) {
		for(char c : inner) {
			innerflag |= 1 << c -'a';
		}
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		a = new ArrayList<>();
		alpha = new ArrayList<>();
		res = new ArrayList<>();
		ansList = new ArrayList<>();
		for(int i = 0 ;i<n;i++)a.add(sc.next());
		if(k < 5) {
			System.out.println(0);
			System.exit(0);
		}
		String alphabet = "bdefghjklmopqrsuvwxyz";
		for(int i = 0 ;i<alphabet.length();i++) {
			alpha.add(alphabet.charAt(i));
		}
		
		combination(0, 0, k);
		System.out.println(Collections.max(ansList));
	}

}
