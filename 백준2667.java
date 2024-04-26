import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 백준2667 {
    static int N;
    static int[][] map;
    static List<Integer> result;
    static boolean[][] visit;
    static int [] dy ={-1,0,1,0};
    static int[] dx ={0,1,0,-1};
    static int count;
    static int num=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        for(int i =0; i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }
        result = new ArrayList<>();
        //방문하면서 0이면넘어가고, 1이면 count늘려가면서 방문했다고 하고 값 증가 후 배열에 저장
        for(int i=0; i<N;i++){
            for(int j=0; j<N;j++){
                count =0;
                if(map[i][j]!=0&&visit[i][j]==false){
                    dfs(i,j);
                    result.add(count);
                    num++;
                }
            }
        }
        Collections.sort(result);
        System.out.println(num);
        for(Integer re : result){
            System.out.println(re);
        }

    }
    public static void dfs(int y, int x){
        if(map[y][x]==0){
            return;
        }
        count++;
        visit[y][x]=true;
        for(int i=0;i<4;i++){
            int my = dy[i]+y;
            int mx = dx[i]+x;
            if(my>=0&&mx>=0&&my<N&&mx<N&&visit[my][mx]==false){
                dfs(my,mx);
            }
        }
    }
}
