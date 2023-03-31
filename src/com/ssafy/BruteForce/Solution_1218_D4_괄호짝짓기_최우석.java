package com.ssafy.BruteForce;
import java.util.*;
public class Solution_1218_D4_괄호짝짓기_최우석 {
	
	static Scanner sc = new Scanner(System.in);
	static int n;
	static ArrayList<Character> open = new ArrayList<>();
	static ArrayList<Character> close = new ArrayList<>() ;
	
	public static boolean check(String str) {
		Deque<Character> dq = new ArrayDeque<>();
		
		for(int i = 0,n = str.length();i<n;i++) {
			Character c = str.charAt(i);
			
			//여는괄호일경우
			if(open.contains(c))dq.add(c);
			else {
				//닫힌괄호
				if(dq.isEmpty())return false;	
				Character openCharacter = dq.pollLast();
				int openIdx = open.indexOf(openCharacter);
				int closeIdx = close.indexOf(c);
				if(openIdx != closeIdx)return false;
			}
			
		}
		return true;
	}
	public static void main(String[] args) {
		//add open
		open.add('(');
		open.add('[');
		open.add('{');
		open.add('<');
		//add close
		close.add(')');
		close.add(']');
		close.add('}');
		close.add('>');
		
		for(int t = 1 ;t<=10;t++) {
			n = sc.nextInt();
			
			String str = sc.next();
			
			if( n%2 == 1) {
				System.out.println("#"+t+" "+0);
				continue;
			}
	
			boolean flag = check(str);
			if(flag)System.out.println("#"+t+" "+1);
			else System.out.println("#"+t+" "+0);
			
		}
	}

}
