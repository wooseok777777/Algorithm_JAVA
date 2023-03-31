package com.ssafy.BruteForce;

import java.util.*;

public class Main_12891_S2_DNA비밀번호_최우석 {
	static int N = 4;
	static int n;
	static int m;
	static String DNA = "";
	static Hashtable<Character,Integer> table = new Hashtable<>();
	static Character[] DNAS = {'A','C','G','T'};
	static int[] controlGroup = new int[N];
	static Scanner sc = new Scanner(System.in);
	
	public static boolean check(int[] eGroup) {
		for(int i = 0 ;i<N;i++) if(eGroup[i] < controlGroup[i])return false;
		return true;
	}
	
	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		DNA = sc.next();
		
		for(int i = 0 ;i<4;i++) {
			int x = sc.nextInt();
			table.put(DNAS[i],x);
			controlGroup[i] = x;
		}
		
		//initiate
		int idx = 0;
		int ans = 0;
		int[] eGroup = new int[4];
		
		for(int i = idx;i<idx+m;i++) {
			Character alpha = DNA.charAt(i);
			if(alpha == 'A')eGroup[0]+=1;
			else if(alpha == 'C')eGroup[1]+=1;
			else if(alpha == 'G')eGroup[2]+=1;
			else if(alpha == 'T')eGroup[3]+=1;
		}
		
		if(check(eGroup))ans+=1;
	
		while(idx + m + 1 <= n) {
		
			Character front = DNA.charAt(idx);
		
			idx+=1;
			if(front == 'A')eGroup[0]-=1;
			else if(front == 'C')eGroup[1]-=1;
			else if(front == 'G')eGroup[2]-=1;
			else if(front == 'T')eGroup[3]-=1;
			
			Character back = DNA.charAt(idx+m-1);
			
			if(back == 'A')eGroup[0]+=1;
			else if(back == 'C')eGroup[1]+=1;
			else if(back == 'G')eGroup[2]+=1;
			else if(back == 'T')eGroup[3]+=1;
			if(check(eGroup))ans+=1;

		}
		
		System.out.println(ans);
	}

}
