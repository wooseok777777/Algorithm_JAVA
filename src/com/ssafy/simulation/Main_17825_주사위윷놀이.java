package com.ssafy.simulation;
import java.util.*;

public class Main_17825_주사위윷놀이 {
	static List<Integer> dices;
	static final int N = 10;
	static final int NUMHORSE = 4;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dices = new ArrayList<>();
		for(int i = 0 ; i<N;i++) {
			dices.add(sc.nextInt());
		}
	}
}
