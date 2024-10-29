package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class dp_lv3백준17484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m+2];
        Arrays.stream(arr).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));  // 101 대신 MAX_VALUE 사용
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[n][m+2][3];  // 3차원 배열로 변경 (마지막 차원은 이전 이동 방향)
        for(int i=0; i<n; i++) {
            for(int j=0; j<m+2; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        // 첫 행 초기화
        for(int j=1; j<=m; j++) {
            for(int k=0; k<3; k++) {
                dp[0][j][k] = arr[0][j];
            }
        }

        // dp 진행
        for(int i=1; i<n; i++) {
            for(int j=1; j<=m; j++) {
                // 왼쪽 대각선 (-1)
                for(int prev=0; prev<3; prev++) {
                    if(prev != 0) { // 이전에 왼쪽 대각선으로 이동하지 않았다면
                        dp[i][j][0] = Math.min(dp[i][j][0], dp[i-1][j-1][prev] + arr[i][j]);
                    }
                }
                // 직진 (0)
                for(int prev=0; prev<3; prev++) {
                    if(prev != 1) { // 이전에 직진하지 않았다면
                        dp[i][j][1] = Math.min(dp[i][j][1], dp[i-1][j][prev] + arr[i][j]);
                    }
                }
                // 오른쪽 대각선 (+1)
                for(int prev=0; prev<3; prev++) {
                    if(prev != 2) { // 이전에 오른쪽 대각선으로 이동하지 않았다면
                        dp[i][j][2] = Math.min(dp[i][j][2], dp[i-1][j+1][prev] + arr[i][j]);
                    }
                }
            }
        }

        // 마지막 행에서 최소값 찾기
        int result = Integer.MAX_VALUE;
        for(int j=1; j<=m; j++) {
            for(int k=0; k<3; k++) {
                result = Math.min(result, dp[n-1][j][k]);
            }
        }
        System.out.println(result);
    }
}