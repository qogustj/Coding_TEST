package start;

import java.io.*;
import java.util.*;

public class g5bj1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int distance = y - x;
            int max = (int)Math.sqrt(distance);

            if (max * max == distance) {
                System.out.println(2 * max - 1);
            }
            else if (max * max < distance && distance <= max * max + max) {
                System.out.println(2 * max);
            }
            else {
                System.out.println(2 * max + 1);
            }
        }
    }
}