package eleven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class two {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
    }
    public static int solution(String s) {
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= Math.min(i + 5, s.length()); j++) {
                String firstNum = s.substring(i, j);
                if (isValidNumber(firstNum)) {
                    int length = checkSequence(s, j, firstNum);
                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        return maxLength;
    }

    private static boolean isValidNumber(String num) {
        if (num.length() > 5) return false;
        if (num.length() > 1 && num.charAt(0) == '0') return false;
        try {
            int value = Integer.parseInt(num);
            return value >= 0 && value <= 99999;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int checkSequence(String s, int startIndex, String prevNum) {
        int currentNum = Integer.parseInt(prevNum);
        int length = prevNum.length();
        int index = startIndex;

        while (index < s.length()) {
            currentNum++;
            if (currentNum > 99999) break;

            String nextNum = String.valueOf(currentNum);
            if (index + nextNum.length() > s.length()) break;
            if (!s.startsWith(nextNum, index)) break;

            length += nextNum.length();
            index += nextNum.length();
        }

        return length > prevNum.length() ? length : 0;
    }
}