package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_s1백준1697 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println(bfs(N,K));
    }
    public static int bfs(int N, int K) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        q.offer(new int[]{N, K, 0});
        visited[N] = true;
        while (!q.isEmpty()) {
            int[] current = q.poll();
            if (current[0] == current[1]) {
                return current[2];
            }
            if(current[0]-1>=0&&!visited[current[0]-1]) {
                q.offer(new int[]{current[0] - 1, current[1], current[2] + 1});
                visited[current[0] - 1] = true;
            }

            if(current[0]+1<=100000&&!visited[current[0]+1]) {
                q.offer(new int[]{current[0] + 1, current[1], current[2] + 1});
                visited[current[0] + 1] = true;
            }
            if(current[0]*2<=100000&&!visited[current[0]*2]) {
                q.offer(new int[]{current[0] * 2, current[1], current[2] + 1});
                visited[current[0] * 2] = true;
            }
        }
        return -1;
    }
}
