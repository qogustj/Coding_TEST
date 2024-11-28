package main.dp;

import java.io.*;
import java.util.*;

public class g5_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] min = new int[n][3];
        min[0][0] = arr[0][0];
        min[0][1] = arr[0][1];
        min[0][2] = arr[0][2];

        int[][] max = new int[n][3];
        max[0][0] = arr[0][0];
        max[0][1] = arr[0][1];
        max[0][2] = arr[0][2];

        for(int i=1; i<n; i++){
            for(int j=0; j<3; j++){
                if(j==0){
                    min[i][0] = Math.min(min[i-1][0],min[i-1][1])+arr[i][0];
                    max[i][0] = Math.max(max[i-1][0],max[i-1][1])+arr[i][0];
                }
                if(j==1){
                    min[i][1] = Math.min(min[i-1][0],Math.min(min[i-1][1],min[i-1][2]))+arr[i][1];
                    max[i][1] = Math.max(max[i-1][0],Math.max(max[i-1][1],max[i-1][2]))+arr[i][1];
                }
                if(j==2){
                    min[i][2] = Math.min(min[i-1][1],min[i-1][2])+arr[i][2];
                    max[i][2] = Math.max(max[i-1][1],max[i-1][2])+arr[i][2];
                }
            }
        }

        int big =Integer.MIN_VALUE;
        int small =Integer.MAX_VALUE;
        for(int i=0; i<3;i++){
            big = Math.max(big,max[n-1][i]);
            small = Math.min(small,min[n-1][i]);
        }

        System.out.print(big+" "+small);
    }
}
