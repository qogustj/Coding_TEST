package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class binary_s3백준19637 {
    static class Game{
        String tier;
        int num;
        Game(String tier, int num){
            this.tier = tier;
            this.num = num;
        }
    }
    static int N,M;
    static String[] arr;
    static List<Game> games = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            games.add(new Game(str, num));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int price = Integer.parseInt(br.readLine());
            String tier = binary(price);
            sb.append(tier).append("\n");
        }
        System.out.print(sb);
    }

    static String binary(int price){
        int left = 0;
        int right = games.size() - 1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (games.get(mid).num < price) {
                left = mid + 1;
            } else {
                right = mid -1;
            }

        }
        return games.get(left).tier;
    }
}
