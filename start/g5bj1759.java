package start;

import java.io.*;
import java.util.*;

public class g5bj1759 {
    static int L, C;
    static char[] letters;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        letters = new char[C];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++) {
            letters[i] = st.nextToken().charAt(0);
        }

        // 먼저 정렬
        Arrays.sort(letters);

        // 백트래킹 시작
        makePassword("", 0, 0);
    }

    static void makePassword(String password, int start, int length) {
        if(length == L) {
            // 모음 개수와 자음 개수 확인
            if(isValid(password)) {
                System.out.println(password);
            }
            return;
        }

        // 조합 만들기
        for(int i = start; i < C; i++) {
            makePassword(password + letters[i], i + 1, length + 1);
        }
    }

    static boolean isValid(String password) {
        int vowels = 0;
        int consonants = 0;

        for(char c : password.toCharArray()) {
            if(isVowel(c)) vowels++;
            else consonants++;
        }

        return vowels >= 1 && consonants >= 2;
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}