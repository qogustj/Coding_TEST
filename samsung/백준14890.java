package samsung;
//첨에는 경사로 내려갈때만 생각하고 했고, 경사로 사이에 평평한지를 확인 안했다
//음 문제의 주석을 다 확인해야 하는데 이게 참 쉽지 않다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준14890 {
    static int N,L;
    static int[][] map;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i =0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i =0; i<N;i++){
                colcalculate(i);
        }
        for(int i =0; i<N;i++){
            rowcalculate(i);
        }
        System.out.println(result);
    }
    public static void colcalculate(int col) {
        boolean[] visited = new boolean[N];
        int i = 0;
        while (i < N - 1) {
            if (map[i][col] == map[i + 1][col]) {
                i++;
            } else if (Math.abs(map[i][col] - map[i + 1][col]) == 1) {
                if (map[i][col] < map[i + 1][col]) {
                    if (i - L + 1 >= 0 && checkFlatnessc(i - L + 1, i, col, visited)) {
                        for (int j = i - L + 1; j <= i; j++) {
                            visited[j] = true;
                        }
                        i++;
                    } else {
                        break;
                    }
                } else {
                    if (i + L < N && checkFlatnessc(i + 1, i + L, col, visited)) {
                        for (int j = i + 1; j <= i + L; j++) {
                            visited[j] = true;
                        }
                        i += L;
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        if (i == N - 1) {
            result++;
        }
    }

    public static boolean checkFlatnessc(int start, int end, int col, boolean[] visited) {
        int height = map[start][col];
        for (int i = start; i <= end; i++) {
            if (map[i][col] != height || visited[i]) {
                return false;
            }
        }
        return true;
    }
    public static void rowcalculate(int row) {
        boolean[] visited = new boolean[N];
        int i = 0;
        while (i < N - 1) {
            if (map[row][i] == map[row][i + 1]) {
                i++;
            } else if (Math.abs(map[row][i] - map[row][i + 1]) == 1) {
                if (map[row][i] < map[row][i + 1]) {
                    if (i - L + 1 >= 0 && checkFlatnessr(row, i - L + 1, i, visited)) {
                        for (int j = i - L + 1; j <= i; j++) {
                            visited[j] = true;
                        }
                        i++;
                    } else {
                        break;
                    }
                } else {
                    if (i + L < N && checkFlatnessr(row, i + 1, i + L, visited)) {
                        for (int j = i + 1; j <= i + L; j++) {
                            visited[j] = true;
                        }
                        i += L;
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        if (i == N - 1) {
            result++;
        }
    }

    public static boolean checkFlatnessr(int row, int start, int end, boolean[] visited) {
        int height = map[row][start];
        for (int i = start; i <= end; i++) {
            if (map[row][i] != height || visited[i]) {
                return false;
            }
        }
        return true;
    }
//    public static void colcalculate(int col){
//        int i=0;
//
//            for(; i<N-1;){
//                if(i+L<N) {
//                    if (Math.abs(map[i][col] - map[i + L][col]) == 1) {
//                        i+=L;
//                        continue;
//                    }
//                    break;
//                }
//                else if(map[i][col]==map[i+1][col]){
//                    i++;
//                }
//                else
//                    break;
//            }
//            if(i+L==N-1||i==N-1)
//                result++;
//    }
//    public static void rowcalculate(int row){
//        int i =0;
//        for(; i<N-1;){
//            if(i+L<N) {
//                if (Math.abs(map[row][i] - map[row][i+L]) == 1) {
//                    i+=L;
//                    continue;
//                }
//                break;
//            }
//            else if(map[row][i]==map[row][i+1]){
//                i++;
//            }
//            else
//                break;
//        }
//        if(i+L==N-1||i==N-1)
//            result++;
//    }
}
