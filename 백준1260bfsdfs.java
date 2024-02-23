import java.io.*;
import java.util.*;

public class 백준1260bfsdfs {
    static int N,E,M;
    static int[][] Graph;
    static boolean[] Visited;
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] Visited2;
    static StringBuilder sb = new StringBuilder();
    static  void dfs(int node){
        Visited[node]=true;
        System.out.print(node + " ");

        for (int next=0; next<N+1; ++next){
            if(!Visited[next] && Graph[node][next] != 0){
                dfs(next);
            }
        }
    }
    static void bfs(int node){
        queue.add(node);
        Visited2[node]=true;

        while (!queue.isEmpty()){
            node = queue.poll();
            sb.append(node+" ");

            for(int i =1; i<=N ; i++){
                if(Graph[node][i]==1&&!Visited2[i]){
                    queue.add(i);
                    Visited2[i]=true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Graph = new int[N+1][N+1];
        Visited = new boolean[N+1];
        Visited2 = new boolean[N+1];
        //간선 정보 입력
        for(int i=0; i<E; ++i){
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            Graph[u][v] = Graph [v][u] =1;
        }
        dfs(M);
        System.out.println("");
        bfs(M);
        System.out.println(sb);
    }
}
