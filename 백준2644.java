import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준2644 {
    static int[] p;
    static int N;
    static int p1,p2;
    static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        p = new int[N+1];
        // 초기값을 -1로 설정
        for (int i = 1; i <= N; i++) {
            p[i] = -1;
        }
        st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        C= Integer.parseInt(br.readLine());
        for(int i=0; i<C;i++){
            st = new StringTokenizer(br.readLine());
            int parent= Integer.parseInt(st.nextToken());
            int child= Integer.parseInt(st.nextToken());
            p[child] = parent;
        }
        int total = dfs(p1,p2, 0);
        System.out.println(total);
    }

    public static int dfs(int p1, int p2, int count){
        if (p1 == p2) {
            return count;
        }
        if (p[p1] != -1) {
            int result = dfs(p[p1], p2, count + 1);
            if (result != -1) {
                return result;
            }
        }

        if (p[p2] != -1) {
            int result = dfs(p1, p[p2], count + 1);
            if (result != -1) {
                return result;
            }
        }

        return -1;

    }
}
