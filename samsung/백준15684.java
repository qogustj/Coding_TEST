package samsung;

import java.io.*;
import java.util.*;

public class 백준15684 {
    // 세로선
    static int N;
    // 가로선
    static int M;
    // 세로선마다 가로선을 놓을 수 있는 위치의 개수
    static int H;
    // 가로선 위치정보
    static int[][] visit;
    static boolean fin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        visit = new int[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 오른쪽
            visit[a][b] = 1;
            // 왼쪽
            visit[a][b + 1] = 2;
        }

        // 규칙 찾기
        for (int i = 0; i <= 3; i++) {
            fin = false;
            dfs(1, 0, i);
            if (fin) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    public static void dfs(int col, int count, int total) {
        if (fin)
            return;
        // 지정한 사다리 개수가 total과 같다면
        if (total == count) {
            if (check())
                fin = true;
            return;
        }
        for (int j = col; j <= H; j++) {
            for (int i = 1; i < N; i++) {
                if (visit[j][i] == 0 && visit[j][i + 1] == 0) {
                    visit[j][i] = 1;
                    visit[j][i + 1] = 2;
                    dfs(j, count + 1, total);
                    visit[j][i] = 0;
                    visit[j][i + 1] = 0;
                }
            }
        }
    }

    public static boolean check() {
        for (int i = 1; i <= N; i++) {
            //1열부터 오른쪽갔다 왼쪽 갔다 결국 같은 열인지! 확인
            int y = 1, x = i;
            for (int j = 1; j <= H; j++) {
                if (visit[y][x] == 1)
                    x++;
                else if (visit[y][x] == 2)
                    x--;
                y++;
            }
            if (x != i)
                return false;
        }
        return true;
    }
}