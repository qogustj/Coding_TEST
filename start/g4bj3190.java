package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class g4bj3190 {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] arr = new int[n+1][n+1];
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[y][x] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        HashMap<Integer,Character> map = new HashMap<>();
        for(int i=0; i<l; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            map.put(time,c);
        }

        int dir = 0;
        int currentx = 1;
        int currenty = 1;
        arr[currenty][currentx] = 2;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1,1});
        int time = 0;

        while (true) {
            time++;

            int mx = currentx + dx[dir];
            int my = currenty + dy[dir];

            if(mx < 1 || my < 1 || mx > n || my > n || arr[my][mx] == 2){
                System.out.println(time);
                return;
            }

            if(arr[my][mx] == 1){
                q.offer(new int[]{my,mx});
                arr[my][mx] = 2;
            } else {
                q.offer(new int[]{my,mx});
                int[] remove = q.poll();
                arr[remove[0]][remove[1]] = 0;
                arr[my][mx] = 2;
            }

            currentx = mx;
            currenty = my;

            if(map.containsKey(time)){
                char c = map.get(time);
                if(c == 'L'){
                    dir = (dir == 0) ? 3 : dir-1;
                }
                else if(c == 'D'){
                    dir = (dir == 3) ? 0 : dir+1;
                }
            }
        }
    }
}