package start;

import java.io.*;
import java.util.*;

class dfs_lv3구름대체경로 {
    static int n, m, s, e;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            sb.append(bfs(i)).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static int bfs(int blocked){
        if(blocked == s || blocked == e) return -1;

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        queue.offer(new int[]{s, 0});
        visited[s] = true;
        visited[blocked] = true;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int node = current[0];
            int distance = current[1];

            if(node == e) return distance+1;

            for(int next : graph.get(node)){
                if(!visited[next]){
                    queue.offer(new int[]{next, distance + 1});
                    visited[next] = true;
                }
            }
        }
        return -1;
    }
}
