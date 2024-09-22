package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class simul_g5백준12919 {
    static String S,T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        System.out.println(simul(T)?1:0);
    }
    static boolean simul(String current){
        if(current.equals(S)) return true;

        if(current.length()<=S.length()) return false;
        if (current.charAt(current.length() - 1) == 'A') {
            if (simul(current.substring(0, current.length() - 1))) {
                return true;
            }
        }
        if (current.charAt(0) == 'B') {
            //앞에서 없애고 돌려야 추가하고 돌린게 성립이 됨
            StringBuilder sb = new StringBuilder(current.substring(1));
            if (simul(sb.reverse().toString())) return true;
        }

        return false;
    }
}
