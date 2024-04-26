import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 백준11652 {
    static long N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        long max =0;
        long x =0;
        HashMap<Long, Integer> card = new HashMap<>();
        for(int i=0; i<N;i++){
            Long num = Long.parseLong(br.readLine());
            card.put(num,card.getOrDefault(num,0)+1);

            if(card.get(num)>max){
                max = card.get(num);
                x=num;
            } else if(card.get(num)==max){
                x=Math.min(x,num);
            }
        }
        System.out.println(x);

    }
}
