package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pointer_s1백준20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[100001];  // 각 숫자의 등장 횟수를 저장할 배열
        int start = 0, end = 0;
        int maxLength = 0;

        while (end < N) {
            while (end < N && count[arr[end]] < K) {
                count[arr[end]]++;
                end++;
            }

            maxLength = Math.max(maxLength, end - start);

            if (end == N) break;

            while (start < end && arr[start] != arr[end]) {
                count[arr[start]]--;
                start++;
            }
            count[arr[start]]--;
            start++;
        }

        System.out.println(maxLength);
    }
}
