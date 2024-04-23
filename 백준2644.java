import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 백준2644 {
    static int[] p;
    static int N;
    static int p1, p2;
    static int C;
    static Map<Integer, Integer> dist; // 각 노드까지의 거리를 저장하는 맵

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        p = new int[N + 1];
        dist = new HashMap<>();

        // 초기값을 -1로 설정
        for (int i = 1; i <= N; i++) {
            p[i] = -1;
        }

        st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        C = Integer.parseInt(br.readLine());
        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            p[child] = parent;
        }

        // p1의 조상들까지의 거리를 계산하여 dist에 저장
        dfs(p1, 0);

        // p2에서 시작하여 조상들을 따라가면서 p1의 조상과 일치하는 노드를 찾음
        int total = findCommonAncestor(p2, 0);
        System.out.println(total);
    }

    public static void dfs(int node, int depth) {
        dist.put(node, depth);
        if (p[node] != -1) {
            dfs(p[node], depth + 1);
        }
    }

    public static int findCommonAncestor(int node, int depth) {
        if (dist.containsKey(node)) {
            return dist.get(node) + depth;
        }
        if (p[node] != -1) {
            return findCommonAncestor(p[node], depth + 1);
        }
        return -1;
    }
}