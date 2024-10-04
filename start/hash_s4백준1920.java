package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class hash_s4백준1920 {
    static long n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        n = Integer.parseInt(br.readLine());
        Set<Long> set = new HashSet<>();
        st= new StringTokenizer(br.readLine());
        for(int i=0; i<n;i++){
            set.add(Long.parseLong(st.nextToken()));
        }
        m = Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m;i++){
            long num = Long.parseLong(st.nextToken());
            if(set.contains(num)) sb.append(1);
            else sb.append(0);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
