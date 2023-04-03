package com.ssafy.순조부;

import java.util.Arrays;

public class next_permutation {

	public static void swap(int i,int j,int[] a) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public static boolean next_permutation(int[] a) {
		int i = a.length - 1;
		
		while(i > 0 && a[i-1] >= a[i])i--;
		if(i == 0)return false;
		
		int j = a.length - 1;
		while(a[i-1] >= a[j])j--;
		swap(i-1,j,a);
		
		int k = a.length - 1;
		while(i < k) swap(i++,k--,a);
		
		return true;
	}
	public static void main(String[] args) {
		int[] a = {10,4,3,5,6,2,3};
		Arrays.sort(a);
		

	}

}
