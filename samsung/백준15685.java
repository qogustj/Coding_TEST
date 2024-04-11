package samsung;
//ㄹㅇㅇ.... 개어럽네!
//수학잘해야푸는게!! 방향 뒤집어서 하는 방식..!!메몸
import java.util.*;
import java.io.*;
public class 백준15685 {
    static int n;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] map;
    static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n= Integer.parseInt(br.readLine());
        map = new int[101][101];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            map[y][x] = 1;
            curve(y, x, d, g);
        }

        //정사각형에 꼭짓점이 포함된지 검사
        for(int i =0 ;i<100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] == 1 && map[i][j+1] == 1 && map[i+1][j] == 1 && map[i+1][j+1] == 1) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    public static void curve(int y, int x, int d, int g){
        ArrayList<Integer> directions = new ArrayList<>();
        directions.add(d);

        for(int i=1;i<=g;i++){
            for(int j=directions.size()-1;j>=0;j--){
                directions.add((directions.get(j)+1)%4);
            }
        }

        int curX = x;
        int curY = y;
        map[curY][curX] = 1;

        for(int direction : directions){
            curX += dx[direction];
            curY += dy[direction];
            map[curY][curX] = 1;
        }
    }
}