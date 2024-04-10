package samsung;
// dfs속 bfs 구조는 한번에 알았는데 bfs 구현을 잘 못했다! 일단 큐로 하는법을 배웠다.
//deque랑 linkedlist는 뭔차인지 잘 모르겠다 deque가 속도는 더 빠르다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class yx{
    int x;
    int y;
    public yx(int y, int x){
        this.y = y;
        this.x = x;
    }
}
public class 백준14502 {
    static int N,M;
    static int[][] v;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        v = new int[N][M];
        for(int i =0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                v[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);



        System.out.println(max);

    }
    public static void validate(int[][] test){
        int result=0;
        for(int i =0;i<N;i++){
            for(int j =0; j<M;j++){
                if(test[i][j]==0){
                    result++;
                }
            }
        }
            max = Math.max(max,result);
    }
    public static void dfs(int count){
        if(count == 3){
            virus();
            return;
        }

        //안전영역 세우면서 최소값 비교
        for(int i=0; i<N;i++){
            for(int j=0; j<M;j++){
                if(v[i][j]==0){
                    v[i][j]=1;
                    dfs(count+1);
                    v[i][j]=0;
                }
            }
        }

    }

    //바이러스 퍼짐
    public static void virus(){
        int [][] test = new int[N][M];
        Queue<yx> yx = new LinkedList<>();

        //그냥 test=v 말고 직접 복사를 해야된다고 함
        for(int i=0; i<N;i++){
            for(int j=0;j<M;j++){
                test[i][j] = v[i][j];
            }
        }

        //바이러스 큐에 추가
        for(int i=0; i<N;i++){
            for(int j=0;j<M;j++){
                if(test[i][j] ==2)
                    yx.add(new yx(i,j));
            }
        }

        //큐 빌때까지 바이러스 퍼짐

        while(!yx.isEmpty()){
            yx poll = yx.poll();
            for(int i=0; i<4;i++){
                int y = poll.y+dy[i];
                int x = poll.x+dx[i];
                if(x>=0&&x<M&&y>=0&&y<N){
                    if(test[y][x]==0){
                        test[y][x]=2;
                        yx.add(new yx(y,x));
                    }
                }
            }
        }
        validate(test);

    }
}
