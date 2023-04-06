package com.ssafy.StringPattern;
import java.util.*;

public class RobinKarpPattern {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1 ; t<=tc ;t++) {
			char[] text = sc.next().toCharArray();
			char[] pattern = sc.next().toCharArray();
			
			long pHash = 0,tHash = 0 , power = 1;
			long base = 2;
			long mod = 1000000009;
			int tlen = text.length;
			int plen = pattern.length;
			Deque<Integer> list = new ArrayDeque<>();
			
			//pattern의 개수만큼 본문의 hash와 pattern의 hash 구하기
			for(int i = 0 ;i<plen;i++) {
				pHash = (pHash * base) %mod;
				pHash = (pHash * pattern[i]) %mod;
				tHash = (tHash * base) %mod;
				tHash = (tHash * text[i]) %mod;
				
				if(i < plen - 1) power = (power * base) % mod;
				
			}
		}
	}

}
