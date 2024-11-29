package main.dp;

import java.io.*;
import java.util.*;

public class g5_2096 {
    //    static boolean[] visit;
    static  List<List<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i=0; i<n;i++){
            boolean[] visit = new boolean[n];
            visit[i] = true;
            dfs(i,1,visit);
        }
        System.out.print(0);

    }
    private static void dfs(int num, int depth, boolean[] visit){
        if(depth == 5){
            System.out.print(1);
            System.exit(0);
        }

        List<Integer> nums = list.get(num);

        for(int n : nums){
            if(!visit[n]){
                visit[n] = true;
                dfs(n, depth+1, visit);
                visit[n] = false;
            }
        }
    }
}