package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g4bj11054 {
    static int[] arr;
    static Integer[] dpInc;  // 증가하는 부분
    static Integer[] dpDec;  // 감소하는 부분

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];
        dpInc = new Integer[n];  // 증가 수열의 길이를 저장
        dpDec = new Integer[n];  // 감소 수열의 길이를 저장

        // 수열 입력 받기
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 증가하는 부분 수열 길이 계산
        for(int i = 0; i < n; i++) {
            dpInc[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    dpInc[i] = Math.max(dpInc[i], dpInc[j] + 1);
                }
            }
        }

        // 감소하는 부분 수열 길이 계산 (뒤에서부터)
        for(int i = n-1; i >= 0; i--) {
            dpDec[i] = 1;
            for(int j = n-1; j > i; j--) {
                if(arr[i] > arr[j]) {
                    dpDec[i] = Math.max(dpDec[i], dpDec[j] + 1);
                }
            }
        }

        // 각 위치에서의 바이토닉 수열의 최대 길이 계산
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, dpInc[i] + dpDec[i] - 1); // 중복되는 현재 위치를 빼주기 위해 -1
        }

        System.out.println(max);
    }
}