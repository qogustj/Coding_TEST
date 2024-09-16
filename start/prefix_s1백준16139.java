package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prefix_s1백준16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());

        // 누적 합 배열 계산
        int[][] sum = new int[26][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                sum[j][i + 1] = sum[j][i];
            }
            sum[s.charAt(i) - 'a'][i + 1]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            sb.append(sum[a - 'a'][r + 1] - sum[a - 'a'][l]).append('\n');
        }

        System.out.print(sb);
    }
}
