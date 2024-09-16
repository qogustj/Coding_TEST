package eleven;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class three {
    public static void main (String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int m = Integer.parseInt(bufferedReader.readLine());
        int[][] games = new int[n][m];
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < m; j++){
                games[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(games));
    }

    public static int solution(int[][] games) {
        int n = games.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int day = 0; day < n; day++) {
            for (int i = 0; i < n; i++) {
                int price = games[i][0];
                if (day >= games[i][1]) {
                    price = price * (100 - games[i][2]) / 100;
                }

                if (day == 0) {
                    dp[day] = Math.min(dp[day], price);
                } else {
                    dp[day] = Math.min(dp[day], dp[day - 1] + price);
                }
            }
        }

        return dp[n - 1];
    }

}