package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dp_s1백준1890 {
    static int N;
    static int[][] game;
    static int result=0;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        game = new int[N+1][N+1];
        dp = new long[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][1] = 1;

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(dp[i][j]==0 || (i==N && j==N)) continue;
                int move = game[i][j];
                if(i+move<=N) dp[i+move][j]+=dp[i][j];
                if(j+move<=N) dp[i][j+move]+=dp[i][j];
            }
        }
//        dp(1,1);
        System.out.println(dp[N][N]);
    }
}
