package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class simul_s2백준11501 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int day = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            long[] arr = new long[day];
            for (int j = 0; j < day; j++) {
                arr[j] = Long.parseLong(st.nextToken());
            }

            long result = 0;
            long max = 0;
            for (int j = day - 1; j >= 0; j--) {
                if (arr[j] > max) {
                    max = arr[j];
                } else {
                    result += max - arr[j];
                }
            }
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}