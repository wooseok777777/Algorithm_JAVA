package com.ssafy.BruteForce;

import java.util.*;

public class Main_2023_G5_신기한소수_최우석 {
	static Scanner sc = new Scanner(System.in);
	static List<String> res = new ArrayList<>();
	static int n;

	public static boolean isPrime(int num) {
		if (num == 0 || num == 1)
			return false;

		for (int i = 2; i <= Math.sqrt(num); i++)
			if (num % i == 0)
				return false;
		return true;
	}

	public static void rec(int cnt) {

		if (cnt == n) {
			String number = String.join("", res);
			System.out.println(number);
			return;
		}

		for (int i = 0; i < 10; i++) {
//			if (cnt == 0 && i == 0)
//				continue;
			res.add(String.valueOf(i));
			String curnum = String.join("", res);
			if (isPrime(Integer.parseInt(curnum))) {
				rec(cnt + 1);
			}
			res.remove(res.size() - 1);

		}
	}

	public static void main(String[] args) {
		n = sc.nextInt();
		rec(0);
	}
}
