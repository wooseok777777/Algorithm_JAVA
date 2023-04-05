package com.ssafy.BOJ;

import java.util.*;

public class Main_9205_G5_맥주마시면서걸어가기_최우석 {
    static int tc;
    static int n;
    static int sy,sx;
    static List<int[]> nodes;
    static int numNodes;
    static boolean[] v;
    static int ey,ex;

    static boolean bt(int node,boolean[] v){
        int y = nodes.get(node)[0];
        int x = nodes.get(node)[1];
        if(y == ey && x == ex)return true;
        v[node] = true;
        for(int nextnode = 0 ;nextnode < numNodes;nextnode++){
            if(v[nextnode])continue;
            int ny = nodes.get(nextnode)[0];
            int nx = nodes.get(nextnode)[1];
            int dist = Math.abs(y - ny) + Math.abs(x - nx);
            if(dist > 1000)continue;
            if(bt(nextnode,v))return true;

        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tc = sc.nextInt();

        for(int t = 1 ; t <= tc;t++){
            nodes = new ArrayList<>();
            n = sc.nextInt();
            sy = sc.nextInt();
            sx = sc.nextInt();
            nodes.add(new int[]{sy,sx});
            for(int i = 0 ;i<n;i++){
                int y = sc.nextInt();
                int x = sc.nextInt();
                nodes.add(new int[]{y,x});
            }
            ey = sc.nextInt();
            ex = sc.nextInt();
            nodes.add(new int[]{ey,ex});
            v = new boolean[nodes.size()];
            numNodes = nodes.size();
            boolean flag = bt(0,v);
            if(flag) System.out.println("happy");
            else System.out.println("sad");
        }
    }
}
