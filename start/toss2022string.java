package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class toss2022string {
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        int result =-1;
        for(int i=0; i<s.length()-2;i++){
            if((s.charAt(i)==s.charAt(i+1))&&(s.charAt(i+1)==s.charAt(i+2))){
                result = Math.max(result,Integer.parseInt(s.substring(i,i+3)));
            }
        }
        System.out.println(result);
    }
}
