package com.ssafy.Pro;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 중위순회 {
	static ArrayList<String> res;
	static int n;
	static String tree[];
	static void inorder(int node) {
		if(node > n)return;
		inorder(2*node);
		res.add(tree[node]);
		inorder(2*node+1);
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			n = Integer.parseInt(br.readLine());
			tree = new String[n + 1];
			res = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				String[] S = br.readLine().split(" ");
				int node = Integer.parseInt(S[0]);
				String value = S[1];
				tree[node] = value;
			}
			inorder(1);
			System.out.print("#"+t+" ");
			for(String s : res) {
				System.out.print(s);
			}System.out.println();
		}
	}
}
