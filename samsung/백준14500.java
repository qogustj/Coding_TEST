package samsung;

//나는 0,0 부터 다 찾으려고 했는데, 1씩 계쏙 오류가 났다.
//특정 위치부터 찾으면서 dfs하고 다시 다른 위치를 기준으로 찾는게 맞는것 같은걸 늦게 깨달았다.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class 백준14500 {

    static int [][] result;
    static int [][] visit;
    static int N,M;
    static int[] x ={0,0,-1,1};
    static int[] y ={-1,1,0,0};
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        result = new int[N][M];
        visit = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for( int j=0;j<M;j++){
                result[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j]=1;
                //들어갈때 시작이니까 1로 시작
                dfs(1, result[i][j], i, j);
                visit[i][j]=0;
                checkSpecialCase(i, j);
            }
        }
        System.out.println(max);
    }
    public static void dfs(int count, int total, int row, int col){
        if(count ==4){
            max=Math.max(total,max);
            return;
        }

                //방문안했으면 dfs

        for(int k=0; k<4;k++){
            if(row+y[k]>=0&&col+x[k]>=0&&row+y[k]<N&&col+x[k]<M&&visit[row + y[k]][col + x[k]]==0) {
                visit[row + y[k]][col + x[k]] = 1;
                dfs(count + 1, total + result[row + y[k]][col + x[k]], row + y[k], col + x[k]);
                visit[row + y[k]][col + x[k]] = 0;
            }
        }




    }
    public static void checkSpecialCase(int row, int col) {
        // ㅗ 모양 체크
        if (row >= 0 && row + 1 < N && col >= 0 && col + 2 < M) {
            int sum = result[row][col] + result[row][col + 1] + result[row][col + 2] + result[row + 1][col + 1];
            max = Math.max(max, sum);
        }
        // ㅜ 모양 체크
        if (row >= 1 && row < N && col >= 0 && col + 2 < M) {
            int sum = result[row][col] + result[row][col + 1] + result[row][col + 2] + result[row - 1][col + 1];
            max = Math.max(max, sum);
        }
        // ㅓ 모양 체크
        if (row >= 0 && row + 2 < N && col >= 0 && col + 1 < M) {
            int sum = result[row][col] + result[row + 1][col] + result[row + 2][col] + result[row + 1][col + 1];
            max = Math.max(max, sum);
        }
        // ㅏ 모양 체크
        if (row >= 0 && row + 2 < N && col >= 1 && col < M) {
            int sum = result[row][col] + result[row + 1][col] + result[row + 2][col] + result[row + 1][col - 1];
            max = Math.max(max, sum);
        }
    }

}
