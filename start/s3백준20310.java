package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class s3백준20310 {
    static int onecnt;
    static int zerocnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        List<Character> strs = new ArrayList<>();
        for (char c : input.toCharArray()) {
            strs.add(c);
        }
        int length = strs.size();

        for (int i = 0; i < length; i++) {
            if(strs.get(i) == '1') onecnt++;
            if(strs.get(i) == '0') zerocnt++;
        }

        for (int i = 0, removed = 0; i < length && removed < onecnt/2; i++) {
            if (strs.get(i) == '1') {
                strs.remove(i);
                i--;
                length--;
                removed++;
            }
        }

        for (int i = length - 1, removed = 0; i >= 0 && removed < zerocnt/2; i--) {
            if (strs.get(i) == '0') {
                strs.remove(i);
                removed++;
            }
        }

        StringBuilder result = new StringBuilder();
        for (char c : strs) {
            result.append(c);
        }
        System.out.println(result.toString());
    }
}