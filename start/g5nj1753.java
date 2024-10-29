package start;

import java.io.*;
import java.util.*;

public class g5nj1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        // 인접 리스트 생성
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, weight));
        }

        // 거리 배열 초기화
        int[] distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        // 우선순위 큐 사용
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        // 다익스트라 알고리즘 수행
        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (distance[current.vertex] < current.weight) continue;

            for (Node next : graph.get(current.vertex)) {
                int newDist = distance[current.vertex] + next.weight;

                if (newDist < distance[next.vertex]) {
                    distance[next.vertex] = newDist;
                    pq.offer(new Node(next.vertex, newDist));
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(distance[i]).append("\n");
            }
        }
        System.out.print(sb);
    }

    static class Node implements Comparable<Node> {
        int vertex, weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
}