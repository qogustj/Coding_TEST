package start;

import java.io.*;
import java.util.*;

public class g5bj5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            Deque<Integer> deque = new ArrayDeque<>();
            for(int i=0; i<n; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            boolean isReverse = false;
            boolean isError = false;

            for(char cmd : p.toCharArray()) {
                if(cmd == 'R') {
                    isReverse = !isReverse;
                }
                else {
                    if(deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if(isReverse) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }

            if(isError) {
                sb.append("error\n");
            } else {
                sb.append('[');
                if(!deque.isEmpty()) {
                    if(isReverse) {
                        sb.append(deque.pollLast());
                        while(!deque.isEmpty()) {
                            sb.append(',').append(deque.pollLast());
                        }
                    } else {
                        sb.append(deque.pollFirst());
                        while(!deque.isEmpty()) {
                            sb.append(',').append(deque.pollFirst());
                        }
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb);
    }
}