package com.ssafy.BinarySearch;

public class BS {
	static int[] a = {1,3,5,7,9,11,13,14,15,16,19,20};
	public static int binarysearch(int[] a, int key,int start,int end) {
		if(start > end) return -1;
		int mid = (start + end) /2;
		if(key == a[mid]) return mid;
		else if(key < a[mid]) return binarysearch(a, key, start, mid-1);
		else return binarysearch(a, key, mid+1, end);
	}
	public static void main(String[] args) {
		int idx = binarysearch(a, 5, 0, a.length-1);
		System.out.println(idx);
	}
}
