package com.ssafy.Pro;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 힙 {
	static int tc;
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tc = Integer.parseInt(br.readLine());
		
		for(int t = 1 ;t<=tc;t++) {
			System.out.print("#"+t+" ");
			n= Integer.parseInt(br.readLine());
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			
			
			for(int i = 0 ;i<n;i++) {
				String[] ops = br.readLine().split(" ");
			if(ops[0].equals("1")) {
				int num = Integer.parseInt(ops[1]);
				pq.add(num);
			}else {
					if(pq.isEmpty())System.out.print(-1 +" ");
					else System.out.print(pq.poll() + " ");
				}
			}
			System.out.println();
		}

	}

}
