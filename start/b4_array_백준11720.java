package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b4_array_백준11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int[] N;
        int result=0;
        n = Integer.parseInt(br.readLine());
        N = new int[n];
        String st = br.readLine();
        for(int i=0; i<n; i++){
            result += Integer.parseInt(String.valueOf(st.charAt(i)));
        }
        System.out.println(result);
    }
}
