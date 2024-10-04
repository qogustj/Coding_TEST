package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class hash_s1백준5525 {
    static int n, m;
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        s = br.readLine();

        int result = 0;
        int patternCount = 0;

        for (int i = 1; i < m - 1; i++) {
            if (s.charAt(i - 1) == 'I' && s.charAt(i) == 'O' && s.charAt(i + 1) == 'I') {
                patternCount++;
                if (patternCount == n) {
                    result++;
                    patternCount--;
                }
                i++; // Skip the next 'I' as it's part of the pattern
            } else {
                patternCount = 0;
            }
        }

        System.out.print(result);
    }
}