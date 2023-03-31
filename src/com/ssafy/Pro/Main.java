package com.ssafy.Pro;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution
{
	private final static int CMD_INIT				= 1;
	private final static int CMD_HIRE				= 2;
	private final static int CMD_FIRE				= 3;
	private final static int CMD_UPDATE_SOLDIER		= 4;
	private final static int CMD_UPDATE_TEAM		= 5;
	private final static int CMD_BEST_SOLDIER		= 6;
	
	private final static UserSolution usersolution = new UserSolution();
	
	private static boolean run(BufferedReader br) throws Exception
	{
		StringTokenizer st;
		
		int numQuery;

		int mID, mTeam, mScore, mChangeScore;
	
		int userAns, ans;
	
		boolean isCorrect = false;

		numQuery = Integer.parseInt(br.readLine());
		
		for (int q = 0; q < numQuery; ++q)
		{
			st = new StringTokenizer(br.readLine(), " ");

			int cmd;
			cmd = Integer.parseInt(st.nextToken());
			
			switch(cmd)
			{
			case CMD_INIT:
				usersolution.init();
				isCorrect = true;
				break;
			case CMD_HIRE:
				mID = Integer.parseInt(st.nextToken());
				mTeam = Integer.parseInt(st.nextToken());
				mScore = Integer.parseInt(st.nextToken());
				usersolution.hire(mID, mTeam, mScore);
				break;
			case CMD_FIRE:
				mID = Integer.parseInt(st.nextToken());
				usersolution.fire(mID);
				break;
			case CMD_UPDATE_SOLDIER:
				mID = Integer.parseInt(st.nextToken());
				mScore = Integer.parseInt(st.nextToken());
				usersolution.updateSoldier(mID, mScore);
				break;
			case CMD_UPDATE_TEAM:
				mTeam = Integer.parseInt(st.nextToken());
				mChangeScore = Integer.parseInt(st.nextToken());
				usersolution.updateTeam(mTeam, mChangeScore);
				break;
			case CMD_BEST_SOLDIER:
				mTeam = Integer.parseInt(st.nextToken());
				userAns = usersolution.bestSoldier(mTeam);
				ans = Integer.parseInt(st.nextToken());
				if (userAns != ans) {
					isCorrect = false;
				}
				break;
			default:
				isCorrect = false;
				break;
			}
		}
		
		return isCorrect;
	}
	
	public static void main(String[] args) throws Exception
	{
//		int N = 100000;
//		UserSolution us = new UserSolution();
//		User users[] = us.infos;
//		HashMap<Integer,ArrayList<User>> teams = us.Teams;
//		
//		us.hire(16, 1, 5);
//		us.hire(21, 1, 5);
//		System.out.println(us.bestSoldier(1));
//		us.fire(21);
//		System.out.println(us.bestSoldier(1));
//		us.hire(25, 1, 4);
//		us.hire(30, 1, 2);
//		us.updateTeam(1, 1);
//		System.out.println(us.bestSoldier(1));
//		us.updateTeam(1, 2);
//		System.out.println(us.bestSoldier(1));
//		us.hire(100000, 5, 1);
//		System.out.println(us.bestSoldier(5));
//		us.hire(1, 1, 2);
//		us.hire(2, 2, 1);
//		us.hire(3, 1, 1);
//		us.hire(4, 3, 3);
//		us.hire(5, 4, 5);
//		us.hire(6, 5, 4);
//		us.hire(7, 4, 2);
//		
//	
//		for(int i = 0;i<=N;i++) {
//			if(users[i] == null)continue;
//			System.out.println(users[i]);
//		}
//		System.out.println("----------------------------------------------------------");
//		for(int i = 1;i<=5;i++) {
//			System.out.println(teams.get(i));
//		}
//		System.out.println("----------------------------------------------------------");
//		us.fire(4);
//		us.updateSoldier(1, 5);
//		us.updateTeam(4,-4);
//		
//		for(int i = 0;i<=N;i++) {
//			if(users[i] == null)continue;
//			System.out.println(users[i]);
//		}
//		System.out.println("----------------------------------------------------------");
//		for(int i = 1;i<=5;i++) {
//			System.out.println(teams.get(i));
//		}
//		
//		us.hire(3, 4, 5);
//		us.bestSoldier(4);
//		for(int i = 0;i<=N;i++) {
//			if(users[i] == null)continue;
//			System.out.println(users[i]);
//		}
//		System.out.println("----------------------------------------------------------");
//		for(int i = 1;i<=5;i++) {
//			System.out.println(teams.get(i));
//		}
		
		int TC, MARK;
		
		System.setIn(new java.io.FileInputStream("C:\\ssafy\\java-work\\Algorithm\\src\\com\\ssafy\\Pro\\sample_25_input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		TC = Integer.parseInt(st.nextToken());
		MARK = Integer.parseInt(st.nextToken());

		for (int testcase = 1; testcase <= TC; ++testcase)
		{
			int score = run(br) ? MARK : 0;
            System.out.println("#" + testcase + " " + score);
		}

		br.close();
	}
}