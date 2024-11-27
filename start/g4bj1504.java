package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class g4bj1504 {
    static class Node implements Comparable<Node> {
        int end;
        long dis;

        Node(int end, long dis) {
            this.end = end;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node n) {
            return Long.compare(this.dis, n.dis);
        }
    }

    static int n, e;
    static int v1, v2;
    static List<List<Node>> nodes;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        nodes = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            nodes.get(a).add(new Node(b, c));
            nodes.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> N 경로
        long res1 = 0;
        long path1 = dijkstra(1, v1);
        long path2 = dijkstra(v1, v2);
        long path3 = dijkstra(v2, n);

        if (path1 != INF && path2 != INF && path3 != INF) {
            res1 = path1 + path2 + path3;
        } else {
            res1 = INF;
        }

        // 1 -> v2 -> v1 -> N 경로
        long res2 = 0;
        path1 = dijkstra(1, v2);
        path2 = dijkstra(v2, v1);
        path3 = dijkstra(v1, n);

        if (path1 != INF && path2 != INF && path3 != INF) {
            res2 = path1 + path2 + path3;
        } else {
            res2 = INF;
        }

        long ans = Math.min(res1, res2);
        System.out.println(ans == INF ? -1 : ans);
    }

    public static long dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        long[] distance = new long[n + 1];
        Arrays.fill(distance, INF);

        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.dis > distance[current.end]) continue;

            for (Node next : nodes.get(current.end)) {
                long nextDis = current.dis + next.dis;

                if (nextDis < distance[next.end]) {
                    distance[next.end] = nextDis;
                    pq.offer(new Node(next.end, nextDis));
                }
            }
        }

        return distance[end];
    }
}