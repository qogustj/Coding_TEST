package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g4bj1976 {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st;
        arr = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] plan = new int[m];
        for(int i=0; i<m; i++){
            plan[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<m-1; i++){
            boolean[] visit = new boolean[n+1];
            if(find(plan[i], plan[i+1], visit)) continue;
            System.out.println("NO");
            System.exit(0);
        }
        System.out.println("YES");
    }

    public static boolean find(int start, int end, boolean[] visit) {
        if(start == end) return true;  // 시작점과 도착점이 같으면 true
        if(arr[start][end] == 1) return true;  // 직접 연결되어 있으면 true

        visit[start] = true;  // 현재 도시 방문 체크

        // 1부터 n까지의 도시들을 확인
        for(int i=1; i<arr.length; i++){
            // 아직 방문하지 않았고, 현재 도시에서 갈 수 있는 도시라면
            if(!visit[i] && arr[start][i] == 1){
                if(find(i, end, visit)) return true;
            }
        }
        return false;  // 모든 경로를 확인했는데도 도착점에 도달하지 못함
    }
}