package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class lv2백준2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String first = br.readLine();
        int[] firstCount = new int[26]; // 첫 번째 단어의 알파벳 개수 저장

        // 첫 단어의 각 알파벳 개수 계산
        for(char c : first.toCharArray()) {
            firstCount[c - 'A']++;
        }

        int result = 0;

        for(int i = 0; i < n-1; i++) {
            String word = br.readLine();
            int[] wordCount = new int[26];

            // 비교할 단어의 알파벳 개수 계산
            for(char c : word.toCharArray()) {
                wordCount[c - 'A']++;
            }

            // 차이나는 문자의 개수 계산
            int diff = 0;
            int firstTotal = 0;
            int wordTotal = 0;

            for(int j = 0; j < 26; j++) {
                diff += Math.abs(firstCount[j] - wordCount[j]);
                firstTotal += firstCount[j];
                wordTotal += wordCount[j];
            }

            // 비슷한 단어 판단
            if(diff <= 2 && Math.abs(firstTotal - wordTotal) <= 1) {
                result++;
            }
        }

        System.out.println(result);
    }
}
