package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class g4bj1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(arr[0]>=m){
            System.out.println(1);
            System.exit(0);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(arr[0]);
        int result = arr[0];
        int min = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            int current = arr[i];
            while (!q.isEmpty()&&result+current-q.peek()>=m){
                result-=q.poll();
            }
            q.offer(current);
            if (result+current>=m){
                min = Math.min(min, q.size());
            }

            result+=current;

//            if(result+current-q.peek()>=m){
//                result= result- q.poll()+current;
//                q.offer(current);
//                min = Math.min(min, q.size());
//            }else if (result+current>=m){
//                result +=current;
//                q.offer(current);
//                min = Math.min(min, q.size());
//            }else {
//                q.offer(current);
//                result += current;
//            }
        }
        System.out.println(min==Integer.MAX_VALUE?0:min);
    }
}
