import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준19638 {
    static int N;
    static int HC;
    static int T;
    static int[] H;
    static String result = "NO";
    static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        HC = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        H = new int[N];
        C =0;
        for(int i = 0; i<N; i++){
            H[i]= Integer.parseInt(br.readLine());
        }
        Arrays.sort(H);
        while (T!=0&&H[H.length-1]>HC&&HC==1){
            solution(H);
        }
        if(H[H.length-1]<HC){
            result= "YES";
        }
        System.out.println(result);
        if(result.equals("YES")){
            System.out.println(C);
        }else{
            System.out.println(H[H.length-1]);
        }

    }
    private static void solution(int[] H){
        H[H.length-1] = H[H.length-1]/2;
        Arrays.sort(H);
        T--;
        C++;
    }
}
