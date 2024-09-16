package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class simul_b1백준14467 {
    static int[] cow;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        cow = new int[10];

        for(int i=0; i<N; i++){
            cow[i] = -1;
        }

        StringTokenizer st;
        for(int i =0; i<11 ; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int rl = Integer.parseInt(st.nextToken());
            if(cow[num]!=rl&&cow[num]!=-1){

                count++;
            }
            cow[num] = rl;
        }
        System.out.println(count);
    }
}
