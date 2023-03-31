package com.ssafy.BOJ;
import java.util.*;

public class Main_6443_G5_애너그램_최우석 {
	static int n;
	
	public static void swap(char[] a,int x, int y) {
		char tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}
	
	public static boolean next_permutation(char[] a,int start, int n) {
		int i = n-1;
		while(i > start && a[i-1] >= a[i])i--;
		if( i == start) return false;
		
		int j = n-1;
		while(a[i-1] >= a[j])j--;
		swap(a,i-1,j);
		
		int k = n-1;
		while(i < k) {
			swap(a,i++,k--);
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i = 0 ;i<n;i++) {
			char[] a = sc.next().toCharArray();
			Arrays.sort(a);
			do {
				String ans = "";
				for(char c : a) {
					ans += c;
				}
				System.out.println(ans);
			}while(next_permutation(a,0,a.length));
		}
	}
}
