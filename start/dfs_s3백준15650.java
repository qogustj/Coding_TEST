package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dfs_s3백준15650 {
    static int n,m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        dfs(0,1);
        System.out.println(sb);
    }

    public static void dfs(int depth,int cnt){
        if(depth==m){
            for(int ar : arr){
                sb.append(ar+" ");
            }
            sb.append("\n");
            return;
        }


        for(int i =  cnt; i<=n; i++){
            arr[depth] = i;
            dfs(depth+1,i+1);
        }
    }
}
