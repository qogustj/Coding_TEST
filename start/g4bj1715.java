package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class g4bj1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n;i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }
        int result = 0;

        while (pq.size() > 1) {  // 큐에 2개 이상의 원소가 있을 때까지
            int sum = pq.poll() + pq.poll();  // 가장 작은 두 수를 꺼내서 더함
            result += sum;  // 결과에 더하기
            pq.offer(sum);  // 합을 다시 큐에 넣기
        }
        System.out.println(result);
    }
}
