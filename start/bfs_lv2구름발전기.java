package start;

import java.io.*;
import java.util.*;
class bfs_lv2구름발전기 {
    static int[] x = {0,1,0,-1};
    static int[] y = {1, 0, -1,0};
    static boolean[][] visit;
    static int[][] m;
    static int result=0;
    static int n=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = new int[n][n];
        visit = new boolean[n][n];
        StringTokenizer st;
        for(int i=0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                m[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n;i++){
            for(int j=0;j<n;j++){
                if(m[i][j]==1 && !visit[i][j]){
                    bfs(i,j);
                    result++;
                }
            }
        }
        System.out.print(result);
    }

    public static void bfs(int my, int mx){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{my,mx});
        visit[my][mx] = true;

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int nx = current[1];
            int ny = current[0];
            for(int i=0; i<4;i++){
                int dx = x[i]+nx;
                int dy = y[i]+ny;
                if(dx>=0 && dx<n && dy>=0 && dy<n && !visit[dy][dx] && m[dy][dx]==1){
                    queue.offer(new int[]{dy,dx});
                    visit[dy][dx] = true;
                }
            }
        }

    }
}
