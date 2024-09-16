package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dp_s3백준2579 {
    static int N;
    static int[] array;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        if (N >= 1) dp[1] = array[1];
        if (N >= 2) dp[2] = array[1] + array[2];

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i-2] + array[i], dp[i-3] + array[i-1] + array[i]);
        }

        System.out.println(dp[N]);
    }
}