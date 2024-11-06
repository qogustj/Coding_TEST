package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class g5bj1916 {
    static class Node implements Comparable<Node>{
//        int start;
        int end;
        int price;

        Node(int end, int price){
//            this.start = start;
            this.end = end;
            this.price = price;
        }

        @Override
        public int compareTo(Node node){
            return this.price- node.price;
        }
    }
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[] dp = new int[n+1];
        visit = new boolean[n+1];

        for(int i=0; i<=n;i++){
            dp[i]=Integer.MAX_VALUE/2;
        }
        List<List<Node>> nodes = new ArrayList<>();
        for(int i=0; i<=n;i++){
            nodes.add(new ArrayList<>());
        }
        for(int i=0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            int start  =Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            nodes.get(start).add(new Node(end,price));
        }
        st=new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s,0));
        dp[s] =0;
        while (!pq.isEmpty()){
            Node current = pq.poll();
            if(visit[current.end]) continue;
            visit[current.end] = true;

            //현재에서 다음 노드로 찾기
            List<Node> node = nodes.get(current.end);
            for (Node next : node) {
                if(!visit[next.end] && dp[next.end] > dp[current.end] + next.price){
                    dp[next.end] = dp[current.end] + next.price;
                    pq.offer(new Node(next.end, dp[next.end]));
                }
//                if (visit[next.end]) continue;
//                pq.offer(next.end);
//                dp[next.start] = Math.min(dp[next.start], dp[current] + next.price);
            }
        }
        System.out.println(dp[e]);
    }
}
