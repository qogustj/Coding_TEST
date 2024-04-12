package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준14499 {
    static int n,m,x,y,k;
    static int map[][];
    static int[]K;
    static int[][] state;
    static int dy=0;
    static int dx=0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        K=new int[k];
        state =new int[4][3];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                state[i][j] = 0;
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++){
            K[i] = Integer.parseInt(st.nextToken());
            move(K[i]);

        }
    }

    public static void move(int dir){
        int ny = y;
        int nx = x;
        if (dir == 1) {
            nx++;
        } else if (dir == 2) {
            nx--;
        } else if (dir == 3) {
            ny--;
        } else if (dir == 4) {
            ny++;
        }
        if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
            return;
        }
        int tmp;
        if(dir==1){
            tmp = state[1][2];
            state[1][2] = state[1][1];
            state[1][1] = state[1][0];
            state[1][0] = state[3][1];
            state[3][1] = tmp;

        }
        else if(dir==2){
            tmp = state[1][0];
            state[1][0] = state[1][1];
            state[1][1] = state[1][2];
            state[1][2] = state[3][1];
            state[3][1] =tmp;

        }
        else if(dir==3){
            tmp = state[0][1];
            state[0][1] = state[1][1];
            state[1][1] = state[2][1];
            state[2][1] = state[3][1];
            state[3][1] = tmp;

        }
        else if(dir==4){
            tmp = state[3][1];
            state[3][1] = state[2][1];
            state[2][1] = state[1][1];
            state[1][1] = state[0][1];
            state[0][1] = tmp;
        }
        if (map[ny][nx] == 0) {
            map[ny][nx] = state[3][1];
        } else {
            state[3][1] = map[ny][nx];
            map[ny][nx] = 0;
        }
        System.out.println(state[1][1]);
        y = ny;
        x = nx;
    }
}
