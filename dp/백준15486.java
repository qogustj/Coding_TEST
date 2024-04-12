package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준15486 {
    static int n;
    static int[][] tp;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        tp = new int[2][n];
        dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                tp[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (tp[0][i] + i <= n) {
                dp[i] = Math.max(tp[1][i] + dp[tp[0][i] + i], dp[i + 1]);
            } else {
                dp[i] = dp[i + 1];
            }
        }
        System.out.println(dp[0]);
    }
}