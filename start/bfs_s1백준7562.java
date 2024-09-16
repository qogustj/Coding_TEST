package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_s1백준7562 {
    static int T;
    static boolean[][] chess;
    static int N;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            chess = new boolean[N][N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int currentX = Integer.parseInt(st.nextToken());
            int currentY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int moveX = Integer.parseInt(st.nextToken());
            int moveY = Integer.parseInt(st.nextToken());
            System.out.println(bfs(currentX, currentY, moveX, moveY));
        }
    }

    public static int bfs(int currentX, int currentY, int moveX, int moveY) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{currentX, currentY, 0});
        chess[currentX][currentY] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int distance = cur[2];

            if (x == moveX && y == moveY) {
                return distance;
            }

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !chess[nx][ny]) {
                    chess[nx][ny] = true;
                    q.offer(new int[]{nx, ny, distance + 1});
                }
            }
        }
        return -1;
    }
}