package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class g4bj16234 {
    static int n,l,r;
    static int[][] arr;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visit;
    static boolean check;  // true로 초기화하지 않음
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true){
            check = false;  // 각 날짜가 시작할 때 check를 false로 설정
            visit = new boolean[n+1][n+1];

            for(int i=1;i<=n;i++){
                for(int j=1;j<=n; j++){
                    if(!visit[i][j]){
                        bfs(i,j);
                    }
                }
            }

            if(!check) break;  // 하루동안 인구 이동이 없었다면 종료
            cnt++;  // 인구 이동이 있었던 날짜 증가
        }
        System.out.print(cnt);
    }

    public static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        // 연합에 속한 칸들의 좌표를 저장할 리스트
        LinkedList<int[]> union = new LinkedList<>();

        q.offer(new int[]{y,x});
        visit[y][x] = true;
        union.add(new int[]{y,x}); // 시작 지점도 연합에 포함

        int total = arr[y][x];
        int area = 1;

        while (!q.isEmpty()){
            int[] current = q.poll();

            for(int i=0;i<4;i++){
                int mx = current[1]+dx[i];
                int my = current[0]+dy[i];

                if(mx<1 || my<1 || mx>n || my>n ||
                        Math.abs(arr[current[0]][current[1]]-arr[my][mx])<l ||
                        Math.abs(arr[current[0]][current[1]]-arr[my][mx])>r ||
                        visit[my][mx]) continue;

                q.offer(new int[]{my,mx});
                visit[my][mx] = true;
                union.add(new int[]{my,mx}); // 연합에 추가
                total += arr[my][mx];
                area++;
                check = true;
            }
        }

        if(area > 1){
            int avg = total / area;
            // 연합에 속한 칸들만 순회
            for(int[] pos : union){
                arr[pos[0]][pos[1]] = avg;
            }
        }
    }
}