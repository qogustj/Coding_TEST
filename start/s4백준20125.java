package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s4백준20125 {
    static int N;
    static char[][] arr;
    static int dx, dy;
    static int left, right, main, leftl, rightl;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new char[N + 1][N + 1];
        for(int i =0; i<N;i++){
            String string = br.readLine();
            for(int j =0;j<N;j++){
                arr[i][j] = string.charAt(j);
            }
        }

        for(int i =0; i<N;i++){
            for(int j =0;j<N;j++){
                if(arr[i][j]=='*'){
                    dx = j;
                    dy = i+1;
                    break;
                }
            }
            if (dy != 0) break;
        }
        left();
        right();
        mai();
        leftl();
        rightl();
        sb.append(dy + 1).append(" ").append(dx + 1).append("\n")
                .append(left).append(" ").append(right).append(" ").append(main).append(" ").append(leftl).append(" ").append(rightl);
        System.out.print(sb);

    }
    public static void left(){
        int x = dx - 1;
        int y = dy;
        while (x >= 0 && arr[y][x] == '*'){
            left++;
            x--;
        }
    }
    public static void right(){
        int x = dx + 1;
        int y = dy;
        while (x < N && arr[y][x] == '*'){
            right++;
            x++;
        }
    }
    public static void mai(){
        int x = dx;
        int y = dy + 1;
        while (y < N && arr[y][x] == '*'){
            main++;
            y++;
        }
    }
    public static void leftl(){
        int x = dx - 1;
        int y = dy + main + 1;
        while (y < N && arr[y][x] == '*'){
            leftl++;
            y++;
        }
    }
    public static void rightl(){
        int x = dx + 1;
        int y = dy + main + 1;
        while (y < N && arr[y][x] == '*'){
            rightl++;
            y++;
        }
    }
}


