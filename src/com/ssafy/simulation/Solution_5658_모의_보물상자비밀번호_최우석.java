package com.ssafy.simulation;
import java.util.*;

public class Solution_5658_모의_보물상자비밀번호_최우석 {
	static int tc;
	static int N,K;
	static int n;
	static String chain;
	static Set<Integer> restset;
	static List<Integer> numbers;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();
		
		for(int t = 1; t<=tc;t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			chain = sc.next();
			numbers = new ArrayList<>();
			restset = new HashSet<>();
			n = (int)N/4;
			
			for(int round = 0 ;round < n;round++) {
			
				for(int i = 0 ;i<N;i+=n) {
					String substr = chain.substring(i, i + n);
				
					int number = Integer.parseInt(substr,16);
					restset.add(number);
					
				}
				chain = chain.charAt(chain.length()-1) + chain.substring(0,chain.length()-1);
				
			}
			
			//post processing
			for(int n : restset)numbers.add(n);
			Collections.sort(numbers,Collections.reverseOrder());
			
			
			int ans = numbers.get(K-1);
	
			System.out.println("#" + t + " " + ans);
		
		}
	}
}
