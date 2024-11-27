package main.bfs;

import java.io.*;
import java.util.*;

public class g5_2589 {
    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};
    static char[][] arr;
    static int y,x;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        arr = new char[y][x];
        for(int i=0; i<y; i++){
            String str = br.readLine();
            for(int j=0; j<x; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        // 모든 육지에서 BFS 실행
        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                if(arr[i][j] == 'L'){
                    bfs(i,j);
                }
            }
        }

        System.out.print(max);
    }

    public static void bfs(int sy, int sx){
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[y][x];
        boolean[][] visit = new boolean[y][x];

        q.offer(new int[]{sy,sx});
        visit[sy][sx] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];

            for(int i=0; i<4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if(ny<0 || nx<0 || ny>=y || nx>=x || visit[ny][nx]) continue;
                if(arr[ny][nx] == 'L'){
                    visit[ny][nx] = true;
                    dist[ny][nx] = dist[cy][cx] + 1;
                    max = Math.max(max, dist[ny][nx]);
                    q.offer(new int[]{ny,nx});
                }
            }
        }
    }
}
