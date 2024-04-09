package samsung;
import java.util.*;
import java.io.*;

//배운점 : 연산자 별로 나눠서 접근하는게 어려웠다. 근데 idx 늘리면서 하는건 어느정도 감이 잡히긴 했따.
public class 백준14888 {
    static int N;
    static int[] A;
    static int[] B;
    static boolean[] visited;

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<4;i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        dfs(A[0],1);

        System.out.println(max);
        System.out.println(min);



    }
    public static void dfs(int num,int idx){
        if(idx==N){
            max = Math.max(max,num);
            min = Math.min(min,num);
            return;
        }

        for(int i =0; i<4; i++){
            if(B[i]>0){
                B[i]--;

                switch(i){
                    case 0 : dfs(num+A[idx], idx+1); break;
                    case 1 : dfs(num-A[idx], idx+1);break;
                    case 2 : dfs(num*A[idx], idx+1);break;
                    case 3 : dfs(num/A[idx], idx+1);break;
                }
                B[i]++;
            }

        }
    }

}
