package com.ssafy.swea;
import java.util.*;

public class Solution_8382_방향전환_최우석 {
    static int tc;
    static int sy,sx;
    static int ey,ex;
    static final int N = 300;

    static int[] dy = {0,0,-1,1};
    static int[] dx = {-1,1,0,0};

    static boolean inside(int y ,int x) {
        return 0<=y && y<N && 0<=x && x <N;
    }

    static int solve(){
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][][] v = new boolean[N][N][N];
        //              위치 , 어디서 왔는가,카운트
        q.add(new int[]{sy,sx,-1,0});
        v[sy][sx][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0],x = cur[1],prevk = cur[2],cnt = cur[3];

            if(y == ey && x == ex)return cnt;

            for(int k = 0 ;k<4;k++){
                int ny = y + dy[k],nx = x+dx[k];
                if(!inside(ny,nx) || v[ny][nx][k])continue;

                if(prevk == -1){
                    v[ny][nx][k] = true;
                    q.add(new int[]{ny,nx,k,cnt+1});
                }
                else if(prevk == 0 || prevk == 1){
                    if(k == 2 || k == 3){
                        v[ny][nx][k] = true;
                        q.add(new int[]{ny,nx,k,cnt+1});
                    }
                }
                else if(prevk == 2 || prevk == 3){
                    if(k == 0 || k == 1){
                        v[ny][nx][k] = true;
                        q.add(new int[]{ny,nx,k,cnt+1});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tc = sc.nextInt();

        for(int t = 1 ;t<=tc;t++){
            sy = sc.nextInt();
            sx = sc.nextInt();
            ey = sc.nextInt();
            ex = sc.nextInt();
            sy += 100;
            sx += 100;
            ey += 100;
            ex += 100;
            System.out.printf("#%d %d\n",t,solve());
        }
    }
}
