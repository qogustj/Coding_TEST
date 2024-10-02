package start;

import java.util.ArrayList;
import java.util.List;

public class greedy_프로그래머스lv2조이스틱 {
    public static void main(String[] args) {
        solution("BZROEN");
    }
    public static int solution(String name) {
        int n = name.length();
        int answer = 0;
        int move = n - 1; // 최대 이동 횟수

        for (int i = 0; i < n; i++) {
            // 상하 이동 계산
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            // 좌우 이동 계산
            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }

            move = Math.min(move, i + n - next + Math.min(i, n - next));
        }

        return answer + move;
    }
}
