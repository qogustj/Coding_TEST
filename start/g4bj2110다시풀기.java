package start;

import java.io.*;
import java.util.*;

public class g4bj2110다시풀기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 집 좌표 저장
        int[] houses = new int[n];
        for(int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        // 정렬
        Arrays.sort(houses);

        // 이진 탐색
        int start = 1; // 최소 거리
        int end = houses[n-1] - houses[0]; // 최대 거리
        int result = 0;

        while(start <= end) {
            int mid = (start + end) / 2; // 현재 검사할 거리
            int count = 1; // 설치한 공유기 수
            int lastInstalled = houses[0]; // 마지막 설치 위치

            // mid 거리로 공유기 설치
            for(int i = 1; i < n; i++) {
                if(houses[i] - lastInstalled >= mid) {
                    count++;
                    lastInstalled = houses[i];
                }
            }

            // 설치한 공유기 수에 따라 거리 조절
            if(count >= c) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}