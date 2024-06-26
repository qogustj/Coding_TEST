package dp;

import java.util.Scanner;

public class 백준11726 {
    static Integer[] dp;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new Integer[1001];
        dp[1]=1;
        dp[2]=2;
        for(int i=3; i<N+1; i++){
            dp[i]=(dp[i-1]+dp[i-2])%10007;
        }
        System.out.println(dp[N]);
    }
}
