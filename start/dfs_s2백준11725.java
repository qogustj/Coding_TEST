package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class dfs_s2백준11725 {
    static int N;
    static boolean[] visited; //방문여부
    static int[] parent; //부모노드
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        parent = new int[N+1];
        for(int i = 0; i < N+1; i++){
            list[i] =  new ArrayList<>();
        }


        for (int i = 0; i < N-1 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b  = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        for(int i = 2; i < N+1; i++){
            System.out.println(parent[i]);
        }
    }
    public static void dfs(int i) {
        visited[i] = true;
        for(int j : list[i]){
            if(!visited[j]){
                parent[j] = i;
                dfs(j);
            }
        }
    }
}
