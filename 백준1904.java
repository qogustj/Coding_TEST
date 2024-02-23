import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준1904 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp= new int[1000001];
        for(int i=3; i<dp.length; i++)
            dp[i]=-1;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        int result = fibo(n);
        System.out.println(result);
    }
    static int fibo(int n){
        if(dp[n]== -1){
            dp[n] = (fibo(n-1)+fibo(n-2))%15746;
        }
        return dp[n];

    }
}
