package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dfs_s1백준1497 {
    static int N, M;
    static long[] guitars;
    static int maxSongs = 0;
    static int minGuitars = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        guitars = new long[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken(); // 기타 이름은 무시
            String yn = st.nextToken();
            for (int j = 0; j < M; j++) {
                if (yn.charAt(j) == 'Y') {
                    guitars[i] |= (1L << j);
                }
            }
        }

        dfs(0, 0, 0);

        System.out.println(maxSongs == 0 ? -1 : minGuitars);
    }

    static void dfs(int index, long songs, int count) {
        if (index == N) {
            int songCount = Long.bitCount(songs);
            if (songCount > maxSongs) {
                maxSongs = songCount;
                minGuitars = count;
            } else if (songCount == maxSongs) {
                minGuitars = Math.min(minGuitars, count);
            }
            return;
        }

        dfs(index + 1, songs | guitars[index], count + 1);
        dfs(index + 1, songs, count);
    }
}