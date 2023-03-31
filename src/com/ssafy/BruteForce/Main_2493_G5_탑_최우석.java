package com.ssafy.BruteForce;
import java.util.*;

public class Main_2493_G5_탑_최우석 {
	
	static Scanner sc = new Scanner(System.in);

	static int n;
	static int ans[];
	
	
	public static void main(String[] args) {
		
		class Entry{
			int value;
			int idx;
			
			public Entry(int value, int idx) {
				super();
				this.value = value;
				this.idx = idx;
			}	
		}
	
		
		ArrayDeque<Entry> stack1 = new ArrayDeque<>();
		ArrayDeque<Entry> stack2 = new ArrayDeque<>();
		
		n = sc.nextInt();
		ans = new int[n];
		Entry[] heights = new Entry[n];
		
		for(int i = n-1;i>=0;i--) {
			heights[i] = new Entry(sc.nextInt(),i);
		}
			
		
		for(Entry e1 : heights) {
			if(stack2.isEmpty()) stack2.addLast(e1);
			else {
				while(!stack2.isEmpty()) {
					Entry e2 = stack2.peekLast();
		
					if (e1.value > e2.value) {
						ans[e2.idx] = e1.idx + 1;
						stack2.pollLast();
					}else break;
				}
				stack2.addLast(e1);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int x : ans) {
			sb.append(x + " ");
		}
		System.out.println(sb.toString());
	}
}
