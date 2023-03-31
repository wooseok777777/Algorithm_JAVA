package com.ssafy.Pro;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 암호문3 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1;t<=10;t++) {
			int n = Integer.parseInt(br.readLine());
			List<Integer> a = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ;i<n;i++)a.add(Integer.parseInt(st.nextToken()));
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreElements()) {
				String S = st.nextToken();
				if(S.equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					ArrayList<Integer> tmp = new ArrayList<>();
					for(int j = 0 ;j<y;j++)tmp.add(Integer.parseInt(st.nextToken()));
					Collections.reverse(tmp);
					for(Integer s : tmp)a.add(x, s);
				}else if(S.equals("D")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int j = 0 ;j<y;j++)a.remove(x+1);
				}else if(S.equals("A")) {
					int y = Integer.parseInt(st.nextToken());
					for(int j = 0 ;j<y;j++)a.add(Integer.parseInt(st.nextToken()));
				}
			}
			
			System.out.print("#" + t + " ");
			for(int i = 0;i<10;i++) {
				System.out.print(a.get(i) + " ");
			}System.out.println();
		}
	}
}
