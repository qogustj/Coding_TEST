package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g4bj1707 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i=0;i<t;i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            parent = new int[v+1];

            //초기화
            for(int j=1;j<=v;j++){
                parent[j] =j;
            }
            boolean check = true;
            for(int j=0; j<e; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(union(a,b)) {
                    System.out.println("NO");
                    check = false;
                    break;
                }
            }
            if(check) System.out.println("YES");
        }
    }
    public static int find(int num){
        if(parent[num] == num) return num;
        return parent[num] = find(parent[num]);
    }

    public static boolean union(int x, int y){
        x = find(x);
        y = find(y);
        parent[x] = y;
        return x ==y;
    }
}
