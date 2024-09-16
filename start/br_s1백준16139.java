package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class br_s1백준16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        int q = Integer.parseInt(br.readLine());
        int[] arr = new int[q];
        StringTokenizer st;
        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int result =0;
            for(int j=l; j<=r; j++){
                if(string.charAt(j)==a.charAt(0)){
                    result++;
                }
            }
            arr[i]=result;
        }

        for(int i =0; i<q;i++){
            System.out.println(arr[i]);
        }
    }
}

