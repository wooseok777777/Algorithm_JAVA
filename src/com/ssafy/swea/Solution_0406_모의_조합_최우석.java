package com.ssafy.swea;

import java.util.*;

public class Solution_0406_모의_조합_최우석 {
    static int tc;
    static final int MOD = 1234567891;

    static long combination(int n, int r, int p) {
        if (r == 0)
            return 1L;
        long[] fac = new long[n + 1];
        fac[0] = 1;
        for (int i = 1; i <= n; i++) {
            fac[i] = fac[i - 1] * i % p;
        }
        return (fac[n] * power(fac[r], p - 2, p) % p * power(fac[n - r], p - 2, p) % p) % p;
    }

    static long power(long x, int y, int p) {
        long res = 1L;
        x = x % p;
        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tc = sc.nextInt();

        for(int t = 1 ; t<= tc ; t++){
            int n = sc.nextInt();
            int r = sc.nextInt();

            long ans = combination(n,r,MOD);
            System.out.printf("#%d %d\n",t,ans);
        }
    }
}
