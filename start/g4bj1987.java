package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class g4bj1987 {
    static char[][] arr;
    static int r,c;
    static int max;
    static int[] dy = {0,-1,0,1};
    static int[] dx ={1,0,-1,0};
    static boolean[] visited = new boolean[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        for(int i=0; i<r; i++){
            String str = br.readLine();
            for(int j=0; j<str.length();j++){
                arr[i][j] = str.charAt(j);
            }
        }
        visited[arr[0][0] - 'A'] = true;
        dfs(0,0,1);
        System.out.println(max);
    }
    public static void dfs(int y, int x, int depth){
        max = Math.max(max, depth);  // 현재 깊이로 최댓값 갱신

        for(int i=0; i<4; i++) {
            int my = y + dy[i];
            int mx = x + dx[i];

            if(my<0 || mx<0 || my>=r || mx>=c) continue;

            int next = arr[my][mx] - 'A';
            if(!visited[next]) {  // 방문하지 않은 알파벳인 경우에만
                visited[next] = true;
                dfs(my, mx, depth+1);
                visited[next] = false;
            }
        }
    }
}
