package start;

import java.io.*;
import java.util.*;

public class g5백준5972 {
    static class Edge implements Comparable<Edge> {
        int to, cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            if (dist[current.to] < current.cost) continue;

            for (Edge next : graph.get(current.to)) {
                if (dist[next.to] > dist[current.to] + next.cost) {
                    dist[next.to] = dist[current.to] + next.cost;
                    pq.offer(new Edge(next.to, dist[next.to]));
                }
            }
        }

        System.out.println(dist[N]);
    }
}