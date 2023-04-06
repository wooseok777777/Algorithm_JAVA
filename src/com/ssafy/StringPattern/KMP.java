package com.ssafy.StringPattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class KMP {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] text = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();
		
		int tlen = text.length;
		int plen = pattern.length;
		
		//Fail 함수 만들기 (부분 일치 문자열의 개수가 몇개인지 카운트)
		int[] fail = new int[plen];
		/*
		 * i : 접미사 포인터
		 * j : 접두사 포인터
		 */
		for(int i = 1,j =0;i<plen;i++) {
			while(j > 0 && pattern[i] != pattern[j]) {
				j = fail[j-1];
			}
			if(pattern[i] == pattern[j]) {
				fail[i] = ++j;
			}
		}
		
		//본문비교
		Deque<Integer> list = new ArrayDeque<>();
		//i : 텍스트 포인터 j : 패턴 포인터
		for(int i = 0 ,j = 0 ;i<tlen;i++) {
			//원문과 패턴이 맞지않으면 j위치로 이동
			while(j > 0 && text[i]!=pattern[j]) {
				j = fail[j-1];
			}
			//두글자가 일치하면
			if(text[i] == pattern[j]) {
				//두글자가 똑같다이거야 본문과 패턴이 일치
				if( j == plen - 1) {
					list.add((i + 1) - plen + 1); //패턴이 일치한 시작 위치
					j = fail[j];
				}else {
					j++;
				}
			}
		}
		int cnt = list.size();
		System.out.println(cnt);
		for(int idx : list) {
			System.out.println(idx);
		}
	}
}
