package com.ssafy.BruteForce;

import java.util.*;

public class Solution_1228_D3_암호문_최우석 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		for(int t = 1 ;t<=10;t++) {
			int n = sc.nextInt();
			List<Integer> codes = new LinkedList<>();
			
			for(int i = 0;i<n;i++)codes.add(sc.nextInt());

			int k = sc.nextInt();
			
			for(int i = 0 ;i<k;i++) {
				sc.next();
				int x = sc.nextInt();
				int y = sc.nextInt();
				ArrayList<Integer> a = new ArrayList<>();
				for(int j = 0 ;j<y;j++) {
					a.add(sc.nextInt());
				}
				Collections.reverse(a);
				for(Integer num : a)codes.add(x, num);
			}
			System.out.print("#"+t+" ");
			for(int i = 0 ;i<10;i++)System.out.print(codes.get(i)+" ");
			System.out.println();
		}
	}
}
