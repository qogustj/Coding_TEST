package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준2606 {
    static boolean Visited[];
    static int Graph[][];
    static int N, E;
    static int result =0;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine()); // 정점의 개수를 읽음
        E = Integer.parseInt(bufferedReader.readLine());
        Visited = new boolean[N+1];
        Graph = new int[N+1][N+1];
        for(int i=0; i<E; ++i){
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            Graph[u][v] = Graph [v][u] =1;
        }
        dfs(1);
        System.out.println(result);
    }

    static  void dfs(int node){
        Visited[node]=true;

        for (int next=0; next<N+1; ++next){
            if(!Visited[next] && Graph[node][next] != 0){
                dfs(next);
                result++;
            }
        }
    }
}
