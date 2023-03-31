package com.ssafy.jungol;
import java.util.*;

public class Main_2247_bank_도서관_최우석 {
	static class Position implements Comparable<Position>{
		int s;
		int e;
		
		public Position(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Position o) {
			// TODO Auto-generated method stub
			return this.s != o.s ? this.s - o.s : o.e - this.e;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Position [s=").append(s).append(", e=").append(e).append("]");
			return builder.toString();
		}
		
	}
	static int n;
	static List<Position> a = new ArrayList<>(10);
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i = 0 ;i<n;i++) {
			int s,e;
			s = sc.nextInt();
			e = sc.nextInt();
			a.add(new Position(s,e));
		}
		
		Collections.sort(a);
	
		List<Integer> blankTimeResult = new ArrayList<>();
		List<Integer> duringTimeResult = new ArrayList<>();
		int curStart = a.get(0).s;
		int curEnd = a.get(0).e;
		int duringTime = curEnd - curStart;
		a.remove(0);
	
		for(Position pos : a) {
			int s,e;
			s = pos.s;
			e = pos.e;
			if(e <= curEnd)continue;
			if(curEnd < s) {

				blankTimeResult.add(s - curEnd);
				duringTimeResult.add(duringTime);
				duringTime = e - s;
				curEnd = e;
			}else {
				duringTime += e - curEnd;	
				curEnd = e;
			
			}
		}
		duringTimeResult.add(duringTime);
	
		System.out.print(Collections.max(duringTimeResult));
		System.out.print(" ");
		System.out.print(Collections.max(blankTimeResult));
	}
}
