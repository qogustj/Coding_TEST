import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준10026 {
    static int N;
    static char[][] map;
    static boolean[][] visit1, visit2;
    static int result1, result2;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visit1 = new boolean[N][N];
        visit2 = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        result1 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit1[i][j]) {
                    dfs(i, j, map[i][j], visit1, false);
                    result1++;
                }
            }
        }

        result2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit2[i][j]) {
                    dfs(i, j, map[i][j], visit2, true);
                    result2++;
                }
            }
        }

        System.out.println(result1 + " " + result2);
    }

    public static void dfs(int y, int x, char color, boolean[][] visit, boolean isColorBlind) {
        visit[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;
            if (ny >= 0 && nx >= 0 && ny < N && nx < N && !visit[ny][nx]) {
                if (isColorBlind) {
                    if ((color == 'R' || color == 'G') && (map[ny][nx] == 'R' || map[ny][nx] == 'G')) {
                        dfs(ny, nx, color, visit, true);
                    } else if (color == 'B' && map[ny][nx] == 'B') {
                        dfs(ny, nx, color, visit, true);
                    }
                } else {
                    if (map[ny][nx] == color) {
                        dfs(ny, nx, color, visit, false);
                    }
                }
            }
        }
    }
}