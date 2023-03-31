package com.ssafy.permutation;
import java.util.*;


public class NextPermutation {
	static int n;
	static int[] a;
	
	public static void swap(int x, int y,int [] a) {
		a[x] = a[x] + a[y];
		a[y] = a[x] - a[y];
		a[x] = a[x] - a[y];
	}
	public static boolean next_permutation(int[] a) {
		int i = n - 1;
		while(i > 0 && a[i-1] >= a[i])i--;
		if(i == 0)return false;
		
		int j = n-1;
		while(a[i-1] >= a[j])j--;
		swap(i-1,j,a);
		
		int k = n-1;
		while(i < k) swap(i++,k--,a);
		
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		n = sc.nextInt();
		a = new int[n];
		for(int i = 0 ;i<n;i++) {
			a[i] = rand.nextInt(20);
		}
		Arrays.sort(a);
		do {
			System.out.println(Arrays.toString(a));
		}while(next_permutation(a));
	}
}
