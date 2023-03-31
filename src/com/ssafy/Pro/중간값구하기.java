package com.ssafy.Pro;
import java.util.*;

public class 중간값구하기 {
	static final int MOD = 20171109;
	static int tc;
	static int n;
	static int a;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();
		for(int t = 1 ; t <= tc;t++) {
			n = sc.nextInt();
			a = sc.nextInt();
			int ans = 0;
			PriorityQueue<Integer> maxheap = new PriorityQueue<>((i1,i2) -> i2 - i1);
			PriorityQueue<Integer> minheap = new PriorityQueue<>((i1,i2) -> i1 - i2);
			maxheap.add(a);
			
			for(int i = 0 ;i<n;i++) {
				int x,y;
				x = sc.nextInt();
				y = sc.nextInt();
			
				if(x > y) {
					minheap.add(x);
					maxheap.add(y);
				}
				else {
					maxheap.add(x);
					minheap.add(y);
				}
				
				while(maxheap.peek() > minheap.peek()) {
					int maxElement,minElement;
					maxElement = maxheap.poll();
					minElement = minheap.poll();
					maxheap.add(minElement);
					minheap.add(maxElement);
				}
				ans += maxheap.peek();
				ans %= MOD;
			}
			System.out.println("#" + t+ " "+ans);
		}
	}
}
