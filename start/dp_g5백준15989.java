package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dp_g5백준15989 {
    static int T;
    //앞의 수를 만들때 뒤의 수로 끝나는 경우의 수를 저장
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        dp = new int[10001][4];
        initDP();
        for(int i =0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n][1] + dp[n][2] + dp[n][3]);
        }

    }
    static void initDP(){
        dp[1][1] = 1;
        dp[2][1] = 1; dp[2][2]=1;
        dp[3][1] =1; dp[3][2]=1; dp[3][3] =1;

        for(int i=4; i<= 10000; i++){
            //1만붙이니까 그 전꺼에 1추가
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][2]+dp[i-2][1];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

    }
}
