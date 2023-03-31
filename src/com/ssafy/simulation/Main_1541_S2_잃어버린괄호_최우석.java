package com.ssafy.simulation;
import java.util.*;

public class Main_1541_S2_잃어버린괄호_최우석 {
	static List<Integer> nums;
	static List<String> ops;
	
	public static int getans() {
		//덧셈 먼저 처리
		int pluscnt = 0;
		for(String op : ops) {
			if(op.equals("+"))pluscnt++;
		}
		
		for(int k = 0 ; k<pluscnt;k++) {
			//plus 하나씩 처리
			for(int i = 0 ;i<ops.size();i++) {
				if(ops.get(i).equals("+")) {
					int p = nums.get(i) + nums.get(i + 1);
					ops.remove(i);
					nums.set(i, p);
					nums.remove(i+1);
					break;
				}
			}
		}
		
		int ret = nums.get(0);
		for(int i = 0 ;i<ops.size();i++) {
			ret -= nums.get(i+1);
		}
		return ret;
	}
	public static void main(String[] args) {
		nums = new ArrayList<>();
		ops = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] strnums = s.split("\\+|\\-");
		String[] strops = s.split("\\d+");
		
		for(String n : strnums) {
			nums.add(Integer.parseInt(n));
		}
		for(int i = 1 ;i<strops.length ;i++) {
			ops.add(strops[i]);
		}
		System.out.println(getans());
		
	}
}
