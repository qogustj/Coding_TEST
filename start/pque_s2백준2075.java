package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class pque_s2백준2075 {
    static int N;
    static int[][] arr;
    static int[] big;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i =0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());

                if(queue.size()<N){
                    queue.offer(num);
                }else if(queue.peek()<num){
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        System.out.print(queue.peek());


    }
}
