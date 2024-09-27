package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class simul_s2백준2304 {
    static int N;
    static int[] arr;
    static int leftMaxPos = 0,rightMaxPos=0;
    static int max = 0;
    static int front=0, back =0;
    static int result=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        arr = new int[1001];
        PriorityQueue<Integer[]> queue = new PriorityQueue<>();
        for(int i =1; i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            arr[line] = height;
            if (max < height) {
                max = height;
                leftMaxPos = rightMaxPos = line;
            } else if (max == height) {
                rightMaxPos = Math.max(rightMaxPos, line);
                leftMaxPos = Math.min(leftMaxPos, line);
            }
        }

        for(int i=1;arr[i]!=max;i++){
            if(arr[i]<=front) {
                result += front;
                continue;
            }
            front = Math.max(front, arr[i]);
            result += front;
        }

        for(int i=1000;arr[i]!=max;i--){

            if(arr[i]<=back) {
                result += back;
                continue;
            }
            back = Math.max(back, arr[i]);
            result += back;

        }
        result += max * (rightMaxPos - leftMaxPos + 1);
        System.out.print(result);
    }
}
