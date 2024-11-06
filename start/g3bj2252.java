package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class g3bj2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 진입차수 배열
        int[] indegree = new int[n + 1];
        // 인접 리스트
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b); // a -> b
            indegree[b]++; // b의 진입차수 증가
        }

        // 위상 정렬 시작
        Queue<Integer> q = new LinkedList<>();

        // 진입차수가 0인 정점을 큐에 삽입
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            int current = q.poll();
            sb.append(current).append(" ");

            // 현재 정점과 연결된 모든 정점들의 진입차수를 감소
            for (int next : graph.get(current)) {
                indegree[next]--;
                // 진입차수가 0이 되면 큐에 삽입
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        System.out.println(sb);
    }
}