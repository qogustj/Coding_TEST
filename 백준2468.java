import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준2468 {
    static int N;
    static int[][] map;
    static boolean[][] visit;
    static int maxH = Integer.MIN_VALUE;
    static int max = Integer.MIN_VALUE;
    static int[] dy = {-1, 0,1 ,0};
    static int[] dx = {0, 1,0,-1};
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, map[i][j]);
            }
        }

        for(int h=1; h<maxH; h++){
            count = 0;
            visit = new boolean[N][N]; // visit 배열 초기화
            for(int i=0; i<N;i++){
                for(int j=0;j<N;j++){
                    dfs(i,j,h);
                }
            }
            max = Math.max(max, count);
        }
    System.out.println(max);


    }


    public static void dfs(int y, int x, int h) {
        if (map[y][x] <= h || y < 0 || x < 0 || y >= N || x >= N || visit[y][x]) {
            return;
        }

        if (!visit[y][x]) {
            visit[y][x] = true;
            count++;
        }

        for (int i = 0; i < 4; i++) {
            int my = y + dy[i];
            int mx = x + dx[i];
            if(my>=0 && mx>=0 && my<N && mx<N ) {
                if(map[mx][my]>h){
                    visit[my][mx] = true;
                    dfs(my, mx, h);
                }

            }
        }
    }
}
