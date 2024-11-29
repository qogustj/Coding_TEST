package main.math;

import java.io.*;
import java.util.*;

public class gdc_g5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 수들을 배열에 저장
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 수들을 정렬
        Arrays.sort(arr);

        // 수들의 차이를 구함
        int gcdResult = arr[1] - arr[0];
        for(int i = 2; i < n; i++) {
            gcdResult = gcd(gcdResult, arr[i] - arr[i-1]);
        }

        // 최대공약수의 약수들을 구함
        ArrayList<Integer> result = getDivisors(gcdResult);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append(" ");
        }
        System.out.println(sb.toString());
    }

    // 최대공약수를 구하는 메서드
    private static int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // 약수를 구하는 메서드
    private static ArrayList<Integer> getDivisors(int num) {
        ArrayList<Integer> divisors = new ArrayList<>();
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                divisors.add(i);
                if(i != num/i) {
                    divisors.add(num/i);
                }
            }
        }
        divisors.add(num);
        Collections.sort(divisors);
        return divisors;
    }
}
