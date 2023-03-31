package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1233_D4_사칙연산유효성검사_최우석 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		

		for(int t = 1 ; t<=10 ; t++) {
			boolean flag = true;
			int n = Integer.parseInt(br.readLine());
	
			for(int i = 0 ;i<n;i++) {
				String[] info = br.readLine().split(" ");
				
				//리프노드일경우 자기자신은 숫자여야함
				if(info.length == 2) {
					if(info[1].equals("-") || info[1].equals("+") || info[1].equals("*") || info[1].equals("/"))
						flag = false;
				}else {
					if(!(info[1].equals("-") || info[1].equals("+") || info[1].equals("*") || info[1].equals("/")))
						flag = false;
				}
			}
	
			if(flag)System.out.printf("#%d 1",t);
			else System.out.printf("#%d 0",t);
			System.out.println();
		}
	}
}
