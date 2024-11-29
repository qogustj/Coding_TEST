package main.dijkstra;

import java.io.*;
import java.util.*;

public class g4_1504 {
    static class Node implements  Comparable<Node>{

        int end;
        int w;
        Node( int end, int w){

            this.end = end;
            this.w = w;
        }

        @Override
        public int compareTo(Node n){
            return this.w-n.w;
        }
    }
    static int n;
    static int INF = 200000000;
    static List<List<Node>> nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());


        nodes  = new ArrayList<>();

        for(int i=0; i<=n; i++){
            nodes.add(new ArrayList<>());
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            nodes.get(start).add(new Node(end,w));
            nodes.get(end).add(new Node(start,w));
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        long path1=0;
        path1 += dijkstra(1,a);
        path1 += dijkstra(a,b);
        path1 += dijkstra(b,n);

        long path2=0;
        path2 += dijkstra(1,b);
        path2 += dijkstra(b,a);
        path2 += dijkstra(a,n);


        long result = Math.min(path2, path1);


        if(path1 >= INF && path2 >= INF){
            System.out.print(-1);
        }else {
            System.out.print(result);
        }

    }
    private static int dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[] distance = new int[n+1];
        Arrays.fill(distance, INF);
        distance[start] =0;
        pq.offer(new Node(start,0));

        while (!pq.isEmpty()){
            Node current = pq.poll();

            if(distance[current.end]< current.w) continue;

            for(Node next : nodes.get(current.end)){
                int cost = next.w+distance[current.end];
                if(distance[next.end]>cost){
                    distance[next.end] = cost;
                    pq.offer(new Node(next.end, cost));
                }
            }
        }
        return distance[end];
    }
}
