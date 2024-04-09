package samsung;
//배운점 행 렬 기준으로 yx 설정을 잘 해야하고, 후진할때는 방향을 안 바꾸고, 전진할때는 방향 바꿔도 되도록 후진대만 방향 따로 설정해서 계산
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준14503 {
    static int N;
    static int M;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int[][] visited;
    static int result = 1;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        visited = new int[N][M];
        for(int i =0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                visited[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(X,Y,p);
        System.out.println(result);
    }
    public static void dfs(int X, int Y, int p){
        //후진은 !=1로 했기에 청소한 곳을 다시 가지 않기 위해 -1로
        visited[Y][X] = -1;
        //동서남북 탐색
        for(int i=0; i<4;i++){
            //반시계 회전, 시계회전이면 +1
            p = (p+3)%4;
            int x = X+dx[p];
            int y = Y+dy[p];

            //청소가능하면 dfs호출
            if(x>=0&&x<M&&y>=0 && y<N && visited[y][x]==0){
                result++;
                dfs(x,y,p);
                //후진 방지
                return;
            }
        }

        //네 방향모두 청소 or 벽
        //후진
        int back = (p+2)%4;
        int bx = X+dx[back];
        int by = Y+dy[back];
        if(bx>=0&& bx<M && by>=0 && by<N && visited[by][bx]!=1){
            dfs(bx,by,p);
        }

    }
}
