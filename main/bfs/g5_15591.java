package main.bfs;

import java.io.*;
import java.util.*;

public class g5_15591 {
    static class Node{
        int end;
        int w;

        Node(int end, int w){
            this.end = end;
            this.w = w;
        }
    }
    static List<List<Node>> list;
    static int cnt;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(end, w));
            list.get(end).add(new Node(start, w));
        }

        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            cnt =0;
            bfs(k,v,cnt);

        }

    }

    private static void bfs(int k, int v, int cnt){
        Queue<Integer> pq = new LinkedList<>();
        boolean[] visit = new boolean[n+1];
        //현재 노드, 값
        pq.offer(v);
        visit[v] = true;
        while (!pq.isEmpty()){
            int current = pq.poll();

            for(Node node : list.get(current)){
                if(!visit[node.end]&&node.w>=k){
                    visit[node.end] = true;
                    pq.offer(node.end);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

}
