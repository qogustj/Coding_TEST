package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_s1백준2178 {
    static int N,M;
    static int[][] miro;
    static boolean[][] visited;
    static int[] dx = {0 ,1, 0,-1};
    static int[] dy = {1,0,-1,0};
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        miro = new int[N][M];
        for (int i = 0; i < N; i++) {
            String string = br.readLine();
            for (int j = 0; j < M; j++) {
                miro[i][j] = Integer.parseInt(String.valueOf(string.charAt(j) - '0'));
            }
        }

        System.out.println(bfs(0,0));
    }
    public static int bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j,1});
        visited[i][j] = true;

        while (!q.isEmpty()){
            int[] data = q.poll();
            int distance = data[2];

            if (data[0] == N - 1 && data[1] == M - 1) {
                return distance;
            }


            for(int k = 0; k < 4; k++){
                int y = data[0] + dy[k];
                int x = data[1] + dx[k];
                if(y>=0 && y<N && x>=0 && x<M && !visited[y][x] && miro[y][x]==1){
                    q.offer(new int[]{y,x,distance+1});
                    visited[y][x] = true;
                }
            }
        }
        return -1;
    }
}
