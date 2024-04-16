import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준1012 {
    static int T;
    static int[][] map;
    static boolean[][] visit;
    static int m,n,k;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int [] result;
    static int total;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        result = new int[T];
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            visit = new boolean[n][m];
            for(int j=0;j<k;j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }
            total =0;
            for(int j =0; j<n;j++){
                for(int k=0;k<m;k++){
                    dfs(j,k);
                }
            }
            result[i] = total;

        }
        for(int i=0; i<T; i++){
            System.out.println(result[i]);
        }
    }
    public static void dfs(int y, int x){
        if(visit[y][x]||map[y][x]==0){
            return;
        }
        visit[y][x] = true;
        total++;
        bfs(y,x);
    }
    public static void bfs(int y, int x){
        for(int i=0; i<4;i++){
            int my = y+dy[i];
            int mx = x+dx[i];
            if(my>=0 && mx>=0 && my<n && m>mx && map[my][mx]==1 && !visit[my][mx]){
                visit[my][mx] = true;
                bfs(my,mx);
            }
        }
    }
}
