package com.ssafy.BOJ;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_17070_G5_파이프옮기기1_최우석 {
	static int n,ans;
	static int[][] a;
	static int[][][] d;
	
	public static boolean inside(int y, int x) {
		return 0<=y && y< n&& 0<=x && x<n;
	}
	public static boolean canGoRight(int y,int x) {
		if(!inside(y,x+1))return false;
		return a[y][x+1] == 0; 
	}
	public static boolean canGoDiagnal(int y,int x) {
		if(!inside(y,x+1) || !inside(y+1,x) || !inside(y+1,x+1))return false;
		return a[y][x+1] == 0 && a[y+ 1][x] == 0 && a[y + 1][x+1] == 0; 
	}
	public static boolean canGoDown(int y,int x) {
		if(!inside(y + 1,x))return false;
		return a[y + 1][x] == 0; 
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        d = new int[n][n][3];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(line[j]);
            }
        }
		
		d[0][1][0] = 1;
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				//오른쪽일 경우
				if(canGoRight(i, j)) d[i][j+1][0] += d[i][j][0];
				if(canGoDiagnal(i, j)) d[i+1][j+1][1] += d[i][j][0];
				
				//대각일 경우
				if(canGoRight(i, j)) d[i][j+1][0] += d[i][j][1];
				if(canGoDiagnal(i, j)) d[i+1][j+1][1] += d[i][j][1];
				if(canGoDown(i, j)) d[i+1][j][2] += d[i][j][1];
				
				//아래일 경우
				if(canGoDown(i, j)) d[i + 1][j][2] += d[i][j][2];
				if(canGoDiagnal(i, j)) d[i+1][j+1][1] += d[i][j][2];
				
				
			}
		}
		
		for(int k = 0 ;k<3;k++) {
			ans += d[n-1][n-1][k];
		}
		System.out.println(ans);
		
	}
}
