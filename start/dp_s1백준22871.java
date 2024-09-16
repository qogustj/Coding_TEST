package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dp_s1백준22871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        long[] a = new long[n];
        long[] dp = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        // 초기화: 첫 번째 돌에서 시작
        dp[0] = 0;

        // 동적 프로그래밍
        for (int i = 1; i < n; i++) {
            dp[i] = Long.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                long power = Math.max(dp[j], (i - j) * (1 + Math.abs(a[i] - a[j])));
                dp[i] = Math.min(dp[i], power);
            }
        }

        System.out.println(dp[n - 1]);
    }
}