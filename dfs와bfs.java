import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dfs와bfs {
    static int N,E,M;
    static int[][] Graph;
    static boolean[] Visited;
    static int[][] Graph2;
    static boolean[] Visited2;

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
        Visited2[node]=true;
        for (int next=0; next<N+1; ++next){
            if(!Visited2[next] && Graph2[node][next] != 0){
                Visited2[next]=true;
                bfs(next);
            }
        }
        System.out.print(node + " ");

    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Graph = new int[N+1][N+1];
        Visited = new boolean[N+1];
        Graph2 = new int[N+1][N+1];
        Visited2 = new boolean[N+1];
        //간선 정보 입력
        for(int i=0; i<E; ++i){
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            Graph[u][v] = Graph [v][u] =1;
            Graph2[u][v] = Graph2 [v][u] =1;
        }
        dfs(M);
        System.out.println("");
        bfs(M);
    }
}
