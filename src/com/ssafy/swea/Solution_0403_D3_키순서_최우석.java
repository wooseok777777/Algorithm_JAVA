package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_0403_D3_키순서_최우석 {
    static int n, m, t, cnt;
    static List<List<Integer>> child, parent;
    static boolean[] check;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        child = new ArrayList<>();
        parent = new ArrayList<>();
        check = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            child.add(new ArrayList<>());
            parent.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            child.get(a).add(b);
            parent.get(b).add(a);
        }
    }
    static void dfs(List<List<Integer>> list, int now) {
    	check[now] = true;
    	cnt++;
        for (int i = 0; i < list.get(now).size(); i++) {
            int next = list.get(now).get(i);
            if (check[next]) continue;
            dfs(list,next);
            
        }
    }
    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            input();
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                cnt = 0;
                Arrays.fill(check, false);
                dfs(child,i);
                dfs(parent,i);
                if (cnt == n + 1) ans++;
            }
            System.out.println("#" + tc + " " + ans);
        }
    }
}
