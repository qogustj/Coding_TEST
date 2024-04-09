package samsung;

//챙겨갈거
// 1. long은 기본타입이라 그냥 선언해도 0으로 초기값을 가짐 Long 쓰면 초기화 해줘야함
// 2. 나머지값을 고려해서 부감독-1값을 고사장 학생 수에 더하고 나눠줘야 함
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 백준13458 {
    static int N;
    static int[] A;
    static int B;
    static int C;
    static long Bnum,Cnum;
    static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        //시험장의 개수 N(1 ≤ N ≤ 1,000,000)
        N = Integer.parseInt(br.readLine());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        //각 시험장에 있는 응시자의 수 Ai (1 ≤ Ai ≤ 1,000,000)
        for(int i =0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        //B와 C가 주어진다. (1 ≤ B, C ≤ 1,000,000) 감독관 B, 부감독관 C
        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        calculate(N, A);
        System.out.println(Cnum+Bnum);
    }
    public static void calculate(int N, int[] A){
        for(int i = 0; i < N; i++){
            if(A[i] <= B) {
                Bnum++;
            } else {
                Bnum++;
                int remainingStudents = A[i] - B;
                //나머지가 있는 경우를 고려한다....
                Cnum += (remainingStudents + C - 1) / C;
            }
        }
    }

}
