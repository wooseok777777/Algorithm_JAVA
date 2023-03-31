package com.ssafy.Pro;

import java.util.Arrays;
import java.util.Scanner;

public class 트리순회 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		char[] tree = new char[n+1];
		for(int i = 0 ;i<n;i++) {
			char[] S = sc.nextLine().split(" ").toString().toCharArray();
			int x = (S[0] - 'A');
			System.out.println(x);
		}

	}

}
