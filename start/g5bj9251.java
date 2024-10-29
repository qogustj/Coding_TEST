package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class g5bj9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();
        int fsize = first.length();
        int ssize = second.length();
        int[][] dp = new int[fsize+1][ssize+1];

        for(int i=1; i<=fsize; i++){
            for(int j=1; j<=ssize; j++){
                if(first.charAt(i-1)==second.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        System.out.println(dp[fsize][ssize]);

    }
}
