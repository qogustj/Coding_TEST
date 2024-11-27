package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class unionfind {
    static class Edge implements Comparable<g4bj1197.Edge> {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(g4bj1197.Edge o) {
            return this.weight - o.weight;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        parent = new int[V+1];

        for(int i=1; i<=V;i++){
            parent[i] = i;
        }

        // 간선 정보 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            pq.offer(new Edge(from, to, weight));
        }

        int result =0;
        int count =0;

        while (!pq.isEmpty()){
            Edge cur = pq.poll();

            if(find(cur.from) != find(cur.to)){
                union(cur.from, cur.to);
                result += cur.weight;
                count++;
            }

            if(count == V -1) break;
        }
        System.out.print(result);
    }
    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    static void union(int x, int y){
        x= find(x);
        y= find(y);
        if(x!=y) parent[y] =x;
    }
}
