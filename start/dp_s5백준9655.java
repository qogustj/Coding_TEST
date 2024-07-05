package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dp_s5백준9655 {
    static int N;
    public static void main(String[] args) throws IOException {
        boolean[] dp;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new boolean[N+1];
        dp[1] = true;
        dp[2] = false;
        dp[3] = true;

        for(int i=4;i<=N;i++){
         dp[i] = !(dp[i-1] && dp[i-3]);
        }
        System.out.println(dp[N]?"SK":"CY");
    }
}
