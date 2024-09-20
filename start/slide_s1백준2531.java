package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class slide_s1백준2531 {
    static int N, d, k, c;
    static int[] belt;
    static int[] cnt;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        belt = new int[N];
        cnt = new int[d + 1];

        for(int i=0; i<N;i++){
                belt[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int max =0;

        //초기 윈도우 설정
        for(int i=0;i<k;i++){
            if(cnt[belt[i]]==0){
                count++;
            }
            cnt[belt[i]]++;
        }
        //쿠폰초밥
        max =  count;
        if(cnt[c] ==0) max++;

        for(int i=1;i<N;i++){
            //초밥제거
            cnt[belt[i-1]]--;
            if(cnt[belt[i-1]]==0) count--;

            //초밥추가
            if(cnt[belt[(i+k-1)%N]]==0) count++;
            cnt[belt[(i+k-1)%N]]++;

            // 쿠폰 초밥 고려
            int current = count;
            if(cnt[c] == 0) current++;

            max = Math.max(max, current);

        }
        System.out.println(max);
    }
}
