package samsung;

import java.util.*;
import java.io.*;
public class 백준14889 {
    static int N;
    static int[][] S;
    static boolean[] result;
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        S = new int[N][N];
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = new boolean[N];
        dfs(0,0);

        System.out.println(min);
    }
    public static void dfs(int idx, int count){
        if(count==N/2){
            caculate();
            return;
        }
        for(int i = idx; i<N; i++){
            if(result[i]!=true) {
                result[i] = true;
                dfs(i + 1, count + 1);
                result[i] = false;
            }
        }
    }
    public static void caculate(){
        int start =0;
        int link =0;

        for(int i =0; i<N-1; i++){
            for(int j =i+1; j<N;j++){
                if(result[i]==true&&result[j]==true){
                    start += S[i][j]+S[j][i];
                }
                if(result[i]==false&&result[j]==false){
                    link +=S[i][j]+S[j][i];
                }
            }
        }
        int num = Math.abs(start-link);
        if(num==0){
            System.out.println(num);
            System.exit(0);
        }
        min = Math.min(min,num);
    }
}
