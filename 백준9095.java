package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 백준9095 {
    static Integer[] dp;
    static int[]arr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new Integer[11];
        arr = new int[N+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;

        for(int i=0;i<3;i++) {
            int n = sc.nextInt();

            System.out.println(solution(n));
        }
    }
    static int solution(int j) {
        if(j>3){
        if (dp[j] == null) {
            dp[j] = solution(j - 1) + solution(j - 2) + solution(j - 3); // 점화식
        }
        }
        return dp[j];
    }
}

// 다른 풀이
/*
import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<11; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        for(int i=0; i<t; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp[num]);
        }
    }
}*/