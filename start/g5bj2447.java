package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class g5bj2447 {
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        star(0, 0, N);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void star(int x, int y, int N) {
        if(N == 1) {
            map[x][y] = '*';
            return;
        }

        int size = N/3;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(i == 1 && j == 1) {
                    blank(x + size, y + size, size);
                }
                else {
                    star(x + size * i, y + size * j, size);
                }
            }
        }
    }

    public static void blank(int x, int y, int size) {
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                map[i][j] = ' ';
            }
        }
    }
}