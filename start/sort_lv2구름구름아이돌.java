package start;

import java.io.*;
import java.util.*;

class sort_lv2구름구름아이돌 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // 그래프를 인접 리스트로 표현 (단방향 연결 가정)
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            graph.get(first).add(second);
            // 양방향이라면 아래 줄의 주석을 제거하세요
             graph.get(second).add(first);
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();


        visited[1] = true;
        queue.offer(1);

        int result = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();


            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) result++;
        }

        System.out.print(result);
    }
}