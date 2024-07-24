package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class dfs_s1백준2667 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> result;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        visited = new boolean[N][N];
        result = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    result.add(dfs(i,j,1));

                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(int i = 0 ; i < result.size() ; i++){
            System.out.println(result.get(i));
        }
    }
    public static int dfs(int y, int x, int size) {
        visited[y][x] = true;
        for(int i = 0 ; i < 4 ; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny>=0 && ny<N && nx>=0 && nx<N && map[ny][nx] == 1 &&!visited[ny][nx]){
//                visited[ny][nx] = true;
                size = dfs(ny,nx, size+1);
            }
        }
        return size;

    }
}
