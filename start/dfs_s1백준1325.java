package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class dfs_s1백준1325 {
    static int N,M;
    static int[] parent;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        adj = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1;i<=N;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[b].add(a);

        }

        for(int i=1;i<=N;i++){
            visited = new boolean[N+1];  // 각 DFS마다 visited 초기화
                parent[i] =dfs(i);


        }

        int max = Arrays.stream(parent).max().getAsInt();

        for(int i=1;i<=N;i++){
            if(parent[i]==max){
                System.out.print(i+" ");
            }
        }


    }
    private static int dfs(int v){
        visited[v] = true;
        int count=1;
        for(int w:adj[v]){
            if(!visited[w]){
                count +=dfs(w);
            }
        }
        return count;
    }
}
