package com.ssafy.Pro;

import java.util.*;

class User implements Comparable{
	int mID;
	int mTeam;
	int mScore;
	
	public User() {}
	
	public User(int mID, int mTeam, int mScore){
		super();
		this.mID = mID;
		this.mTeam = mTeam;
		this.mScore = mScore;
	}
	public int getmID() {
		return mID;
	}
	public void setmID(int mID) {
		this.mID = mID;
	}
	public int getmTeam() {
		return mTeam;
	}
	public void setmTeam(int mTeam) {
		this.mTeam = mTeam;
	}
	public int getmScore() {
		return mScore;
	}
	public void setmScore(int mScore) {
		this.mScore = mScore;
	}

	@Override
	public boolean equals(Object obj) {
		User other = (User) obj;
		return this.mID == other.mID;
	}

	@Override
	public int compareTo(Object o) {
		User other = (User)o;
		
		if(this.mScore < other.mScore)return 1;
		else if(this.mScore == other.mScore) {
			return other.mID - this.mID;
		}
		return -1;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [mID=").append(mID).append(", mTeam=").append(mTeam).append(", mScore=").append(mScore)
				.append("]");
		return builder.toString();
	}
	
}
class UserSolution
{
	public HashMap<Integer,ArrayList<Integer>> Teams = new HashMap<>();
	public User infos[] = new User[100000+1];
	private static int MAXTEAMNUM = 5;
	
	public UserSolution() {
		for(int i = 0;i<=MAXTEAMNUM;i++) {
			Teams.put(i, new ArrayList<>(64));
		}
	}
	public void init()
	{
	}
	
	public void hire(int mID, int mTeam, int mScore)
	{
		infos[mID] = new User(mID,mTeam,mScore);
		Teams.get(mTeam).add(mID);
	}
	
	public void fire(int mID)
	{
		int TeamNum = infos[mID].getmTeam();
		int removeIdx = Teams.get(TeamNum).indexOf(mID);
		Teams.get(TeamNum).remove(removeIdx);
		infos[mID] = null;
	}

	public void updateSoldier(int mID, int mScore)
	{
		infos[mID].setmScore(mScore);
	}

	public void updateTeam(int mTeam, int mChangeScore)
	{
		if(Teams.get(mTeam) == null) return;
		for(int i = 0 ,n = Teams.get(mTeam).size();i <n;i++) {
			int curScore = infos[Teams.get(mTeam).get(i)].getmScore();
			int mID = infos[Teams.get(mTeam).get(i)].getmID();
			if(curScore + mChangeScore > 5) {
				infos[mID].setmScore(5);
			}else if(curScore + mChangeScore < 1) {
				infos[mID].setmScore(1);
			}else {
				infos[mID].setmScore(curScore + mChangeScore);
			}
		}
	}
	
	public int bestSoldier(int mTeam)
	{
		ArrayList<User> tmp = new ArrayList<>();
		for(int i = 0 ,n = Teams.get(mTeam).size();i <n;i++) {
			int mID = infos[Teams.get(mTeam).get(i)].getmID();
			tmp.add(infos[mID]);
		}
		Collections.sort(tmp);
		return tmp.get(0).getmID();
	}
}