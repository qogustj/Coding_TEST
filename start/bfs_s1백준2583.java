package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bfs_s1백준2583 {
    static int M,N,K;
    static int[][] xy;
    static boolean[][] visited;
    static int[]  mx = {0, 1, 0, -1};
    static int[] my = { 1, 0, -1, 0};
    static List<Integer> res = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        xy = new int[K][4];
        visited = new boolean[M][N];
        for(int i =0 ;i<K;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0 ;j<4;j++){
                xy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i =0 ;i<K;i++){
            int dx = xy[i][0];
            int dy = xy[i][1];
            int x = xy[i][2];
            int y = xy[i][3];
            for(int j =dy ;j<y;j++){
                for(int k =dx ;k<x;k++){
                    if (!visited[j][k])
                        visited[j][k] = true;
                }
            }
        }

        for(int i =0 ;i<M;i++){
            for(int j =0 ;j<N;j++){
                if(!visited[i][j]){
                    res.add(bfs(i,j));
                }
            }
        }
        System.out.println(res.size());
        res.sort(Comparator.naturalOrder());
        for (Integer re : res) {
            System.out.print(re + " ");
        }
    }
    public static int bfs(int y,int x) {
        Queue<int[]> q = new LinkedList<>();
        int size =1;

        q.offer(new int[]{x,y, size});
        visited[y][x] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x1 = cur[0];
            int y1 = cur[1];

            for(int i =0 ;i<4;i++){
                int nx = x1+mx[i];
                int ny = y1+my[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[ny][nx]) {
                    q.offer(new int[]{nx, ny});
                    visited[ny][nx] = true;
                    size++;
                }
            }
        }
        return size;
    }
}
