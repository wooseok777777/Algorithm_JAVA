package com.ssafy.BruteForce;

import java.util.*;

public class Solution_1225_D3_암호생성기_최우석 {
	static Scanner sc = new Scanner(System.in);
	static int N = 8;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int t = 1 ;t<=10;t++) {
			int tc = sc.nextInt();
			Deque<Integer> q = new ArrayDeque<>();
			for(int i = 0 ;i<8;i++)q.add(sc.nextInt());
			int cnt = 1;
			while(true) {
				int front = q.pollFirst();
				front-=cnt;
				if(front <=0)front = 0;
				q.add(front);
				if(front == 0)break;
				cnt+=1;
				if(cnt == 6)cnt = 1;
			}
			System.out.print("#"+tc+" ");
			for(Integer x : q) {
				System.out.print(x+" ");
			}System.out.println();
		}
	}

}
