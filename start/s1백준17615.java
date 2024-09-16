package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s1백준17615 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String balls = br.readLine();

        int redCount = 0;
        for (char ball : balls.toCharArray()) {
            if (ball == 'R') redCount++;
        }

        int minMoves = N;
        int leftRed = 0, rightRed = 0;
        int leftBlue = 0, rightBlue = 0;


        for (int i = 0; i < N && balls.charAt(i) == 'R'; i++) {
            leftRed++;
        }


        for (int i = N - 1; i >= 0 && balls.charAt(i) == 'R'; i--) {
            rightRed++;
        }


        for (int i = 0; i < N && balls.charAt(i) == 'B'; i++) {
            leftBlue++;
        }


        for (int i = N - 1; i >= 0 && balls.charAt(i) == 'B'; i--) {
            rightBlue++;
        }

        minMoves = Math.min(minMoves, redCount - leftRed);
        minMoves = Math.min(minMoves, redCount - rightRed);
        minMoves = Math.min(minMoves, N - redCount - leftBlue);
        minMoves = Math.min(minMoves, N - redCount - rightBlue);

        System.out.println(minMoves);
    }
}