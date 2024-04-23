import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준2468 {
    static int N;
    static int[][] map;
    static boolean[][] visit;
    static int maxH = Integer.MIN_VALUE;
    static int max = Integer.MIN_VALUE;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, map[i][j]);
            }
        }

        for (int h = 0; h <= maxH; h++) {
            count = 0;
            visit = new boolean[N][N]; // visit 배열 초기화
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j] && map[i][j] > h) {
                        count += dfs(i, j, h);
                    }
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }

    public static int dfs(int x, int y, int h) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (visit[nx][ny]) continue;
            if (map[nx][ny] > h) {
                dfs(nx, ny, h);
            }
        }
        return 1;
    }
}