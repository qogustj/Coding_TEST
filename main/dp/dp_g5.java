package main.dp;

import java.io.*;
import java.util.*;

public class dp_g5 {
    static int n, k;
    static int result = 0;
    static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        long[][] dp = new long[k+1][n+1];

        for(int i=0; i<=n; i++){
            dp[1][i] = 1;
        }

        for(int i=2; i<=k; i++){
            for(int j=0; j<=n; j++){
                for(int l=0; l<=j; l++){
                    dp[i][j] = (dp[i][j] + dp[i-1][j-l]) % MOD;
                }
            }
        }
        System.out.print(dp[k][n]);
    }


}
