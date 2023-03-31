package com.ssafy.graph;

public class Edge implements Comparable<Edge>{
	int from;
	int to;
	int weight;
	
	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
	
}
