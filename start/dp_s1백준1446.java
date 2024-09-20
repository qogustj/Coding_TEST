package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class dp_s1백준1446 {
    static int N, D;
    static List<ShortCut>[] shortCuts;
    static int[] dp;

    static class ShortCut {
        int end, length;
        ShortCut(int end, int length) {
            this.end = end;
            this.length = length;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        shortCuts = new ArrayList[10001];
        for (int i = 0; i <= 10000; i++) {
            shortCuts[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            if (end > D) continue; // 도착 지점이 D를 넘어가면 무시
            if (end - start <= length) continue; // 지름길이 더 길면 무시
            shortCuts[start].add(new ShortCut(end, length));
        }

        dp = new int[D + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i <= D; i++) {
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i-1] + 1);
            }
            for (ShortCut sc : shortCuts[i]) {
                dp[sc.end] = Math.min(dp[sc.end], dp[i] + sc.length);
            }
        }

        System.out.println(dp[D]);
    }
}