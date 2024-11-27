package main.lis;

import java.io.*;
import java.util.*;

public class g5_2565 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int n =Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
        }

        Arrays.sort(arr,(a,b)->{
            return a[0]-b[0];
        });
        int[] dp = new int[n];
        int maxlength=0;
        for(int i=0; i<n; i++){
            dp[i] =1;
            for(int j=0; j<i; j++){
                if(arr[i][1]>arr[j][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxlength = Math.max(maxlength, dp[i]);
        }
        System.out.print(n-maxlength);
    }
}
