package samsung;
//음 시뮬레이션은 하나만 삑사리나도 틀리니 주석으로 하나부터 잘 조건 적어서 구현하는게 관건인듯
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준20055 {
    //컨베이어벨트 N, 내구도 0인 칸의 개수가 K개 이상이면 종료
    static int N,K;
    static int zeroCount;
    //내구도
    static int[] A;
    static int[] robot;
    static int ng, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st= new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        K= Integer.parseInt(st.nextToken());

        A= new int[2*N];
        robot= new int[N];

        st= new StringTokenizer(br.readLine());
        for(int i=0; i<2*N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        while (zeroCount<K) {
            //벨트 회전
            turnbelt();
            //올라온 로봇부터 이동시작(내구도 -1씩) 다음칸 로봇 없거나 내구도1 이상
            moveRobot();
            //올리는 위치에 로봇 올리기 내구도가 0 아니라면
            upRobot();
            //
            zeroCount=0;
            validate();
        }
        System.out.println(result);


    }
    public static void validate(){
        for(int i =0; i<2*N;i++){
            if(A[i]==0)
                zeroCount++;
        }
        result++;
    }
    public static void upRobot(){
        if(A[0]>0){
            robot[0]=1;
            A[0]--;
        }
    }
    public static void moveRobot(){
        for (int i = robot.length - 1; i > 0; i--) {
            if (robot[i - 1]==1 && 1!=robot[i] && A[i] >= 1) {
                A[i]--;
                robot[i] = 1;  // 로봇 생성
                robot[i - 1] = 0; // 로봇 제거
            }
        }

        /* 이전 코드
        for(int i=N-2; i>=0; i--){
            if(A[i]>=1&&robot[i+1]!=1){
                robot[i]=0;
                robot[i+1]=1;
                A[i+1]--;
            }
        }
        if(robot[N-1]==1){
            robot[N-1]=0;
//            A[N-1]--;
        }*/
    }
    public static void turnbelt(){
        int tp = A[2*N-1];
        for(int i =2*N-2;i>=0;i-- ){
            A[i+1] = A[i];
        }
        A[0]=tp;


        for(int i =N-2;i>=0;i-- ){
            robot[i+1] = robot[i];
        }
        robot[N-1]=0;
        robot[0]=0;
    }
}
