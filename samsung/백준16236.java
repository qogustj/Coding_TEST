package samsung;
//아... 줜나 어렵다 이 문제에선 초기위치를 0으로 안바꿔주는거 때매 오래걸렸다..
// 첨엔 dfs로 풀다가 bfs로 바꿨다 큐 쓰는법이 참 어렵다.
// 과정 = while문 안에서 다음 탐색할 곳 찾기, null이면 break findfish에서 큐 이용해서 이동
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준16236 {
    static int N;
    static int[][] map;
    static int sx;
    static int sy;
    static int size= 2;
    static int et=0;
    static int total;
    static int[] dy = {-1, 0 ,1,0};
    static int[] dx = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sy = i;
                    sx = j;
                    map[i][j] = 0; // 아기 상어의 초기 위치를 빈 칸(0)으로 변경
                }
            }
            //상어 크기 1~6, 아기 상어 크기 =2
            //아기상어 위치 = 9
            //빈칸 =0
            //아기 상어 크기만큼 먹으면 크기 +1

            //물고기 먹는우선순위 1. 가장 가까운 2. 맨위 3. 맨 왼쪽
        }
        while(true){
            int[] nextPos = findFish(sy,sx);
            if(nextPos == null){
                break;
            }
            int ny = nextPos[0];
            int nx = nextPos[1];
            int dist = nextPos[2];
            total += dist;
            et++;
            if(et==size){
                size++;
                et=0;
            }
            map[ny][nx] =0;
            sy = ny;
            sx = nx;

        }
        System.out.println(total);
    }
    public static int[] findFish(int sy, int sx ){
        boolean[][] visit = new boolean[N][N];
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{sy,sx,0});
        visit[sy][sx]=true;
        int min = Integer.MAX_VALUE;
        int[] result =null;

        while (!q.isEmpty()){
            int[] curr = q.poll();
            int y = curr[0];
            int x = curr[1];
            int dist = curr[2];
            if(dist>min){
                break;
            }

            if(map[y][x] !=0 && map[y][x]<size){
                if(dist<min){
                    //가까운 물고기 찾으면 갱신
                    min =dist;
                    result = new int[]{y,x,min};
                }else if(dist ==min){
                    if (y < result[0]) {
                        result = new int[]{y, x, dist};
                    } else if (y == result[0] && x < result[1]) {
                        result = new int[]{y, x, dist};
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                // 경계를 벗어나거나 이미 방문한 위치이거나 상어보다 큰 물고기가 있는 경우 건너뜀
                if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || map[ny][nx] > size) {
                    continue;
                }
                q.offer(new int[]{ny, nx, dist + 1});
                visit[ny][nx] = true;
            }
        }
        return result;
    }


}
