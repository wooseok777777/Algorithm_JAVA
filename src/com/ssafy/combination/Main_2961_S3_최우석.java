package com.ssafy.combination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Dish{
	double s;
	double b;
	public Dish(double s, double b) {
		this.s = s;
		this.b = b;
	}
}

public class Main_2961_S3_최우석 {
	static int n;
	static List<Dish> a = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	
	public static double caculateDishes(List<Dish> a) {
		double s = 1;
		double b = 0;
		for(Dish d : a) {
			s *= d.s;
			b += d.b;
		}
		return Math.abs(s - b);
	}

	public static void main(String[] args) {
		n = sc.nextInt();
		List<Double> res = new ArrayList<>();
		
		for(int i = 0;i<n;i++) {
			double s,b;
			s = sc.nextDouble();
			b = sc.nextDouble();
			a.add(new Dish(s,b));
		}
		for(int s = 1 ;s<(1<<n);s++) {
			List<Dish> selectedDish = new ArrayList<>();
			//select dish
			for(int i = 0 ;i<n;i++) {
				if((s & 1<<i) !=0) {
					selectedDish.add(a.get(i));
				}
			}
			//caculate s and b
		
			res.add(caculateDishes(selectedDish));
		}
		double ans = Collections.min(res);
		System.out.println((int)ans);
	}
}
