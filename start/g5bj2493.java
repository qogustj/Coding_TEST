package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class g5bj2493 {
        static class Top {
            int num;
            int h;

            Top(int num, int h) {
                this.num = num;
                this.h = h;
            }
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            Stack<Top> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();

            // 첫 번째 탑 처리
            stack.push(new Top(1, Integer.parseInt(st.nextToken())));
            sb.append(0).append(" ");

            // 나머지 탑 처리
            for(int i=2; i<=n; i++) {
                int height = Integer.parseInt(st.nextToken());

                // 스택의 top이 현재 높이보다 작으면 pop
                while(!stack.isEmpty() && stack.peek().h < height) {
                    stack.pop();
                }

                // 스택이 비었으면 0, 아니면 스택의 top 번호 출력
                if(stack.isEmpty()) {
                    sb.append(0);
                } else {
                    sb.append(stack.peek().num);
                }
                sb.append(" ");

                // 현재 탑을 스택에 추가
                stack.push(new Top(i, height));
            }

            System.out.print(sb);
        }
    }