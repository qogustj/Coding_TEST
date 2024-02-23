package dp;

import java.io.*;
import java.util.*;

public class 백준1932 {
    static Integer[][] dp;
    static int[][] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new Integer[N][N];
        arr = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j =0; j<i+1;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

// 가장 마지막 행의 값들을 DP의 마지막 행에도 똑같이 복사
        for (int i = 0; i < N; i++) {
            dp[N - 1][i] = arr[N - 1][i];
        }

//        for(int i=0; i<N-1; i++){
//            for(int j =0; j<i;j++) {
//                dp[i][j] += Math.max(dp[i+1][j], dp[i+1][j+1]);
//            }
//        }
//        for(int i=0;i<N-1;i++){
//            k= Math.max(dp[N-1][i], dp[N-1][i+1]);
//        }
        System.out.println(solution(0,0));
    }
    static int solution(int i, int j){
        if(i == N - 1) return dp[i][j];
        if (dp[i][j] == null) {
            dp[i][j] = Math.max(solution(i+1,j), solution(i+1,j+1))+arr[i][j];
        }
        return dp[i][j];
    }
}
