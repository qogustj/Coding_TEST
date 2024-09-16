package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class dfs_s1백준14940 {
    static int n,m;
    static int[][] map;
    static int[] dx = {0, 1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];
        int startX = 0, startY = 0;


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    startY = i;
                    startX = j;
                }
                if (map[i][j] == 1) {
                    visited[i][j] = -1;
                }
            }
        }

        bfs(startY,startX);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(visited[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        visited[i][j] = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];

            for(int k=0;k<4;k++){
                int nx = x+dx[k];
                int ny = y+dy[k];

                if(ny>=0 && ny<n && nx>=0 && nx<m && map[ny][nx]==1 && visited[ny][nx]==-1){
                    q.offer(new int[]{ny,nx});
                    visited[ny][nx] = visited[y][x]+1;
                }
            }
        }


    }
}
