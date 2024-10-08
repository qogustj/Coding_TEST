package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class simul_s3백준22233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Set<String> keywords = new HashSet<>();
        for (int i = 0; i < N; i++) {
            keywords.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] usedKeywords = br.readLine().split(",");
            for (String keyword : usedKeywords) {
                keywords.remove(keyword);
            }
            sb.append(keywords.size()).append("\n");
        }

        System.out.print(sb);
    }
}