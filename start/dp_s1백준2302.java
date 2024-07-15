package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dp_s1백준2302 {
    static int N, M;
    static int[] fix;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        fix = new int[M + 2];
        dp = new int[N + 1];

        for (int i = 1; i <= M; i++) {
            fix[i] = Integer.parseInt(br.readLine());
        }
        fix[M + 1] = N + 1;

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int answer = 1;
        int prev = 0;
        for (int i = 1; i <= M + 1; i++) {
            int len = fix[i] - prev - 1;
            answer *= dp[len];
            prev = fix[i];
        }

        System.out.println(answer);
    }
}