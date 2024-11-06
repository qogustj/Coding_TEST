package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class g3bj2206 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] min;
    static int[][] arr;
    static boolean[][][] visited; // [y][x][벽을 부순 상태]
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1][m+1];
        min = new int[n+1][m+1];
        visited = new boolean[n+1][m+1][2];

        // min 배열 초기화
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                min[i][j] = Integer.MAX_VALUE;
            }
        }

        // 입력 받기
        for(int i=1; i<=n; i++) {
            String str = br.readLine();
            for(int j=1; j<=m; j++) {
                arr[i][j] = str.charAt(j-1) - '0';  // 문자를 숫자로 변환
            }
        }

        int result = bfs(1, 1);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    public static int bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        // y, x, 이동수, 벽뚫은 여부
        q.offer(new int[]{y, x, 1, 0});  // 시작 위치도 카운트에 포함
        visited[y][x][0] = true;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int cy = current[0];
            int cx = current[1];
            int count = current[2];
            int broken = current[3];

            if(cy == n && cx == m) {
                return count;
            }

            for(int i=0; i<4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if(ny <= 0 || nx <= 0 || ny > n || nx > m) continue;

                // 벽이 있고 아직 벽을 부수지 않은 경우
                if(arr[ny][nx] == 1 && broken == 0 && !visited[ny][nx][1]) {
                    visited[ny][nx][1] = true;
                    q.offer(new int[]{ny, nx, count + 1, 1});
                }
                // 벽이 없는 경우
                else if(arr[ny][nx] == 0 && !visited[ny][nx][broken]) {
                    visited[ny][nx][broken] = true;
                    q.offer(new int[]{ny, nx, count + 1, broken});
                }
            }
        }

        return Integer.MAX_VALUE;  // 도달할 수 없는 경우
    }
}