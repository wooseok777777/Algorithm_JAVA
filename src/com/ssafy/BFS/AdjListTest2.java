package com.ssafy.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AdjListTest2 {
	
	static ArrayList<Integer>[] adjList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		adjList = new ArrayList[V];
		for(int i=0;i<V;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		int from,to;
		for(int i=0;i<E;i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		print();
	}

	private static void print() {
		for(ArrayList<Integer> list : adjList) {
			System.out.println(list);
			
		}
	}

}