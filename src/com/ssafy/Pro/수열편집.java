package com.ssafy.Pro;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 수열편집 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1 ;t<=tc;t++) {
			int n,m,l;
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			List<Integer> a = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i<n;i++)a.add(Integer.parseInt(st.nextToken()));
			
			for(int i = 0 ;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				String op = st.nextToken();
				if(op.equals("I")) {
					int idx = Integer.parseInt(st.nextToken());
					int element = Integer.parseInt(st.nextToken());
					a.add(idx, element);
				}else if(op.equals("D")) {
					int idx = Integer.parseInt(st.nextToken());
					a.remove(idx);
		
				}else if(op.equals("C")) {
					int idx = Integer.parseInt(st.nextToken());
					int element = Integer.parseInt(st.nextToken());
					a.set(idx, element);
				}

			}
			

			if(a.size() > l) {
				System.out.println("#"+t+" "+a.get(l));
			}else {
				System.out.println("#"+t+" "+ -1);
			}
		}
	}

}
