import java.io.*;
import java.util.*;
public class 백준1697bfs {
    static int N,K, count;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[10001];

        System.out.println(find(N));
    }
    private static int find(int N) {
        Queue<Integer> queue= new LinkedList<Integer>();
        queue.add(N);
        int n=0;
        arr[N]=1;
        while(!queue.isEmpty()){
            n= queue.poll();
            if(n==K){
                return arr[n]-1;
            }
            if(n-1>0&&arr[n-1]==0){
                arr[n-1]=arr[n]+1;
                queue.add(n-1);
            }
            if(n+1<10001&&arr[n+1]==0){
                arr[n+1]=arr[n]+1;
                queue.add(n+1);
            }
            if(n*2<10001&&arr[n*2]==0){
                arr[n*2]=arr[n]+1;
                queue.add(n*2);
            }
        }

        return -1;
    }
}
