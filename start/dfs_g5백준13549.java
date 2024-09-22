package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class dfs_g5백준13549 {
    static int N,K;
    static int max = 100000;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N,K));
    }
    static int bfs(int start, int end){
        Deque<Integer> deque = new ArrayDeque<>();
        int[] time = new int[max+1];
        Arrays.fill(time, -1);

        deque.offer(start);
        time[start] = 0;

        while (!deque.isEmpty()){
            int current = deque.poll();

            if(current == end){
                return time[current];
            }

            //0초먼저니까 *2먼저
            if(current*2<=max && time[current*2] ==-1){
                time[current*2] = time[current];
                //0초니가 앞에 추가
                deque.addFirst(current*2);
            }

            if(current-1>=0 && time[current-1] ==-1){
                //1초 추가
                time[current-1] = time[current]+1;
                //1초니가 뒤에 추가
                deque.addLast(current-1);
            }

            if(current+1<=max && time[current+1] ==-1){
                //1초 추가
                time[current+1] = time[current]+1;
                //1초니가 뒤에 추가
                deque.addLast(current+1);
            }
        }
        return -1;
    }
}
