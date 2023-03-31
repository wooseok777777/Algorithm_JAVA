package com.ssafy.BOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_2309_B1_최우석 {
	static int n = 9;
	static List<Integer> a = new ArrayList<>();
	static List<Integer> res = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	public static void comb(int idx, int cnt, int r) {
		if (cnt == r) {

			if (res.stream().mapToInt(Integer::intValue).sum() == 100) {
				Collections.sort(res);
				for (Integer x : res) {
					System.out.println(x);
				}
				System.exit(0);
			}

			return;

		}
		if (idx == a.size())return;
		res.add(a.get(idx));
		comb(idx + 1, cnt + 1, r);
		res.remove(res.size() - 1);
		comb(idx + 1, cnt, r);
	}

	public static void main(String[] args) {
		for (int i = 0; i < n; i++)
			a.add(sc.nextInt());
		
		comb(0, 0, 7);
	}

}
