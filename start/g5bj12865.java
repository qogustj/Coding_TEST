package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g5bj12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // 물품의 수
        int k = Integer.parseInt(st.nextToken());  // 버틸 수 있는 무게

        int[] weights = new int[n + 1];  // 무게 배열
        int[] values = new int[n + 1];   // 가치 배열

        // 물품 입력 받기
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i][j] = i번째 물건까지 고려했을 때, 무게 j에서의 최대 가치
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (weights[i] > j) {
                    // 현재 물건의 무게가 고려하는 무게보다 크면 이전 상태 그대로 가져옴
                    dp[i][j] = dp[i-1][j];
                } else {
                    // 현재 물건을 넣는 경우와 넣지 않는 경우 중 최대값 선택
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i]] + values[i]);
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}