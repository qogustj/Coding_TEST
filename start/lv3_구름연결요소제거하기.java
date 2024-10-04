package start;

import java.io.*;
import java.util.*;

class lv3_구름연결요소제거하기 {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int N, K;
    static char[][] arr;
    static boolean[][] visited;
    static List<int[]> connectedComponent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            char d = st.nextToken().charAt(0);
            arr[y][x] = d;

            visited = new boolean[N][N];
            connectedComponent = new ArrayList<>();
            dfs(y, x, d);

            if (connectedComponent.size() >= K) {
                for (int[] pos : connectedComponent) {
                    arr[pos[0]][pos[1]] = '.';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int y, int x, char target) {
        if (y < 0 || x < 0 || y >= N || x >= N || visited[y][x] || arr[y][x] != target) {
            return;
        }

        visited[y][x] = true;
        connectedComponent.add(new int[]{y, x});

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            dfs(ny, nx, target);
        }
    }
}