package main.two_pointer;

import java.io.*;
import java.util.*;

public class g52470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = n-1;
        long min = Long.MAX_VALUE;
        long first = 0, second = 0;

        while(left < right) {
            long sum = arr[left] + arr[right];
            if(Math.abs(sum) < min) {
                min = Math.abs(sum);
                first = arr[left];
                second = arr[right];
            }

            if(sum < 0) left++;
            else right--;
        }

        System.out.print(first + " " + second);
    }
}
