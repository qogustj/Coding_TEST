package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class g5bj2294 {
    static ArrayList<Integer> pq;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        pq = new ArrayList<>();

        dp = new int[k+1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            if(!pq.contains(num)) {  // 중복 동전 처리
                pq.add(num);
                if(num <= k) dp[num] = 1;  // 범위 체크 추가
            }
        }

        for(int i=1; i<=k; i++){
            calculate(i);
        }

        System.out.print(dp[k] == 10001 ? -1 : dp[k]);  // 불가능한 경우 처리
    }

    public static void calculate(int num){
        for(int coin : pq){
            if(num-coin >= 0){
                dp[num] = Math.min(dp[num], dp[num-coin] + 1);
            }
        }
    }
}