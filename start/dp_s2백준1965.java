package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dp_s2백준1965 {
    static int N;
    static int[] dp,array;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(br.readLine());
         dp = new int[N + 1];
         array = new int[N + 1];
         StringTokenizer st = new StringTokenizer(br.readLine());
         for (int i = 1; i <= N; i++) {
             array[i] = Integer.parseInt(st.nextToken());
             dp[i] = 1;
         }

         dp[0] = 0;
         dp[1] = 1;
         for (int i = 2; i <= N; i++) {
             for(int j = 1; j<i; j++){
                 if(array[i] > array[j]){
                     dp[i] = Math.max(dp[j]+1, dp[i]);

                 }
             }
             max = Math.max(max, dp[i]);
         }
         System.out.println(max);
    }
}
