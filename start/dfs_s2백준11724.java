package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class dfs_s2백준11724 {
    static int n,m;
    static int result;
    static boolean[] visit;
    static List<List<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i =0; i<=n;i++){
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u =Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }
        visit = new boolean[n+1];
        for(int i=1; i<=n; i++){
            if(!visit[i]){
                dfs(i);
                result++;
            }
        }
        System.out.println(result);
    }
    public static void dfs(int num){
        visit[num] = true;
        for(int i=0; i<list.get(num).size();i++){
            int next = list.get(num).get(i);
            if(!visit[next]){
                dfs(next);
            }
        }


    }
}
