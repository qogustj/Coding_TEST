package start;

import java.io.*;
import java.util.*;

public class g5bj1107 {
    static boolean[] broken = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        // 100번에서 +/- 버튼만 사용하는 경우
        int answer = Math.abs(target - 100);

        // 0부터 999999까지 모든 채널을 확인
        for (int i = 0; i <= 999999; i++) {
            int len = possible(i);
            if (len > 0) {
                int press = len + Math.abs(target - i);
                answer = Math.min(answer, press);
            }
        }

        System.out.println(answer);
    }

    // 숫자 버튼으로 해당 채널을 만들 수 있는지 확인
    // 가능하면 버튼을 누르는 횟수 반환, 불가능하면 0 반환
    static int possible(int n) {
        if (n == 0) {
            return broken[0] ? 0 : 1;
        }
        int len = 0;
        while (n > 0) {
            if (broken[n % 10]) return 0;
            len++;
            n /= 10;
        }
        return len;
    }
}

