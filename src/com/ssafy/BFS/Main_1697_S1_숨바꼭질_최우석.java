package com.ssafy.BFS;

import java.awt.Point;
import java.util.*;

public class Main_1697_S1_숨바꼭질_최우석 {
	static int n,k,ans;
	static int N = 100000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		boolean[] v = new boolean[N + 1];
		Deque<Point> q = new ArrayDeque<>();
		q.add(new Point(n,0));
		v[n] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			int now = cur.x;
			int cost = cur.y;
			if(now == k) {
				ans = cost;
				break;
			}
			if(0<= now + 1 && now + 1 <= N && !v[now + 1]) {
				q.add(new Point(now + 1,cost + 1));
				v[now+1] = true;
			}
			if(0<= now - 1 && now - 1 <= N && !v[now - 1]) {
				q.add(new Point(now - 1,cost + 1));
				v[now-1] = true;
			}
			if(0<= 2*now && 2 *now <= N && !v[2 * now]) {
				q.add(new Point(2 *now,cost + 1));
				v[2*now] = true;
			}
		}
		System.out.println(ans);
		
	}
}
