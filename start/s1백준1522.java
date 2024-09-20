package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s1백준1522 {
    static int acnt,bcnt;
    static char[] arr;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        arr = new char[str.length()];
        for(int i=0; i<str.length();i++){
            arr[i] =str.charAt(i);
            if(arr[i]=='a') acnt++;
        }

        for(int i=0; i<acnt;i++){
            if(str.charAt(i)=='b') bcnt++;
        }
        min = bcnt;

        for(int i=0; i<str.length();i++){
            if(str.charAt(i) =='b') bcnt--;
            if(str.charAt((i+acnt)%str.length())=='b') bcnt++;

            min = Math.min(min,bcnt);
        }
        System.out.print(min);
    }
}
