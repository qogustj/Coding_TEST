package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class g5bj7576 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] tomato = new int[n][m];
        for (int i = 0; i < n; i++) {
            tomato[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int total_day = 0;
        // 우선순위 큐에 [익는데 걸리는 일수, x, y] 데이터를 저장할 때
        // 익는데 걸리는 일수를 기준으로 우선순위를 정하도록 지정
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0] - t1[0];
            }
        });

        // 처음부터 익은 토마토 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomato[i][j] == 1) {
                    queue.offer(new int[]{0, i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] t = queue.poll();  // 익는데 걸리는 일수가 적은 순으로 먼저 확인
            for (int i = 0; i < 4; i++) {
                int nx = t[1] + dx[i];
                int ny = t[2] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {  // 다음 토마토가 상자 안에 있고
                    if (tomato[nx][ny] == 0) {  // 아직 익지 않은 토마토인 경우
                        tomato[nx][ny] = 1;  // 익음 처리
                        queue.offer(new int[]{t[0] + 1, nx, ny});  // [다음 토마토가 익는데 걸리는 일수(현재 토마토가 익는데 걸리는 일수 + 1), 다음 토마토 x, 다음 토마토 y] 데이터를 우선순위 큐에 저장
                        total_day = Math.max(total_day, t[0] + 1);  // 익는데 걸리는 최대 시간 확인
                    }
                }
            }
        }

        // 최종적으로 익지 않은 토마토 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomato[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(total_day);
    }
}