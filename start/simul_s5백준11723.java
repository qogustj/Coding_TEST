package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class simul_s5백준11723 {
    static int N;
    static boolean[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new boolean[21];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            if (operation.equals("all") || operation.equals("empty")) {
                calcul(operation, 0,sb);
            } else {
                calcul(operation, Integer.parseInt(st.nextToken()),sb);
            }
        }
        System.out.println(sb);
    }
    public static void calcul(String cal, int num,StringBuilder sb) {
        switch (cal) {
            case "add":
                arr[num] = true;
                break;
            case "remove":
                arr[num] = false;
                break;
            case "check":
                if (arr[num]) {
                    sb.append(1+"\n");
                    break;
                } else {
                    sb.append(0+"\n");
                    break;
                }
            case "toggle":
                if (arr[num]) {
                    arr[num] = false;
                    break;
                } else {
                    arr[num] = true;
                    break;
                }
            case "all":
                for (int i = 1; i <= 20; i++) {
                    arr[i] = true;
                }
                break;
            case "empty":
                for (int i = 1; i <= 20; i++) {
                    arr[i] = false;
                }
        }
    }
}
