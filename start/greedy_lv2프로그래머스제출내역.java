package start;

import java.util.Arrays;

public class greedy_lv2프로그래머스제출내역 {
    public static void main(String[] args) {
        System.out.print(solution("1924",2));
    }
    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int max;

        for (int i = 0; i < number.length() - k; i++) {
            max = 0;
            for (int j = index; j <= k + i; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    index = j + 1;
                }
            }
            sb.append(max);
        }

        return sb.toString();
    }
}
