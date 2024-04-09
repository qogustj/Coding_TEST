package samsung;

//배운점
//dp 풀떼 위에서부터 갈지 아래서부터갈지 고민하자!
//
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
public class 백준14501 {
    //N+1일째 되는 날 퇴사
    static int N;

    //상담을 완료하는데 걸리는 기간 Ti
    static int[] T;
    //상담 비용 Pi
    static int[] P;
    static int[] result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];

        for(int i =0 ; i<N;i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        result = new int[N+1];
        maxMoney(T,P,N);

        System.out.println(result[0]);
    }
    public static void maxMoney(int[] T, int[] P, int N){
        for(int i=N-1; i>-1; i--){
            if(T[i]+i<=N){
                result[i] = Math.max(P[i]+result[T[i]+i],result[i+1]);
            }
            else{
                result[i]=result[i+1];
            }
        }

    }
}
