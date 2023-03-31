package com.ssafy.StackQueue;

import java.util.*;

public class Main_2164_S4_카드2_최우석 {
	static Scanner sc = new Scanner(System.in);
	static int n;
	
	public static void main(String[] args) {
		n = sc.nextInt();
		Deque<Integer> dq = new ArrayDeque<>();
		for(int i = 1 ; i<=n;i++)dq.add(i);
		
		while(dq.size()!=1) {
			dq.removeFirst();
			
			dq.add(dq.removeFirst());
		}
		System.out.println(dq.getFirst());
	}

}
