package start;

import java.io.*;

public class b4bj9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));

            // 폭발 문자열을 만들 수 있는 길이가 되면 체크
            if(sb.length() >= bomb.length()) {
                boolean isSame = true;
                // 폭발 문자열과 일치하는지 확인
                for(int j = 0; j < bomb.length(); j++) {
                    if(sb.charAt(sb.length() - bomb.length() + j) != bomb.charAt(j)) {
                        isSame = false;
                        break;
                    }
                }
                // 일치하면 폭발 문자열 제거
                if(isSame) {
                    sb.delete(sb.length() - bomb.length(), sb.length());
                }
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}