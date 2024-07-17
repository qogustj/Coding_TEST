package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_s1백준7562 {
    static int T;
    static boolean[][] chess;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
             chess = new boolean[N][N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int currentX = Integer.parseInt(st.nextToken());
            int currentY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int moveX = Integer.parseInt(st.nextToken());
            int moveY = Integer.parseInt(st.nextToken());
            System.out.println(bfs(currentX, currentY, moveX, moveY));
        }
    }
    public static int bfs(int currentY, int currentX, int moveX, int moveY) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<int[]> q = new LinkedList<>();

        int distance =0;

        q.offer(new int[]{currentY, currentX, distance});
        chess[currentY][currentX] = true;


        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            distance = cur[2];
            if(x == moveX && y == moveY){
                return distance;
            }
            if(x+2<N  && y+1<N){
                if(!chess[y+1][x+2]) {
                    q.offer(new int[]{y + 1, x + 2, distance + 1});
                    chess[y + 1][x + 2] = true;
                }
            }
            if(x+1<N && y+2<N){
                if(!chess[y+2][x+1]){
                    q.offer(new int[]{y + 2, x + 1, distance + 1});
                    chess[y + 2][x + 1] = true;
                }
            }
            if(x+2<N && y-1>=0){
                if(!chess[y-1][x+2]) {
                    q.offer(new int[]{y - 1, x + 2, distance + 1});
                    chess[y - 1][x + 2] = true;
                }
            }
            if(x+1<N && y-2>=0){
                if(!chess[y-2][x+1]) {
                    q.offer(new int[]{y - 2, x + 1, distance + 1});
                    chess[y - 2][x + 1] = true;
                }
            }
            if(x-2>=0  && y+1<N) {
                if (!chess[y+1][x-2]) {
                    q.offer(new int[]{y + 1, x - 2, distance + 1});
                    chess[y + 1][x - 2] = true;
                }
            }
            if(x-1>=0  && y+2<N){
                if(!chess[y+2][x-1]) {
                    q.offer(new int[]{y + 2, x - 1, distance + 1});
                    chess[y + 2][x - 1] = true;
                }
            }
            if(x-2>=0 && y-1>=0){
                if(!chess[y-1][x-2]) {
                    q.offer(new int[]{y - 1, x - 2, distance + 1});
                    chess[y - 1][x - 2] = true;
                }
            }
            if(x-1>=0  && y-2>=0){
                if(!chess[y-2][x-1]) {
                    q.offer(new int[]{y - 2, x - 1, distance + 1});
                    chess[y - 2][x - 1] = true;
                }
            }
        }
        return -1;
    }
}
