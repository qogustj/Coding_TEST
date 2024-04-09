package samsung;
//배운점 :
//일단 톱니 방향을 나타내는 d 배열을 첨엔 while문 밖에서 초기화 시켜서 여러번 연속되는 과정속에서 중첩되어 방향이 정해지게 됨 이게 문제
//while문 안에 넣음으로써 한 사이클이 끝나고 다시 초기화시켜야 하는데 그냥 초기화시킬때 이런 실수 잘 봐야할듯
//그리고 방향을 배열에 어떻게 담을지 첨엔 연쇄적으로 일어나는걸 생각했는데, 이미 다 계산하고 그냥 0부터 돌리는 느낌!
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준14891 {
    static int[][] t;

    static int K;
    static int[] d;
    static int result=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = new int[4][8];
        for(int i =0; i<4; i++){
            String str = br.readLine();
            for(int j=0; j<8; j++){
                t[i][j] = str.charAt(j)-'0';
            }
        }

        K = Integer.parseInt(br.readLine());

        while(K>0){
            st = new StringTokenizer(br.readLine());
            int tnum = Integer.parseInt(st.nextToken())-1;
            d = new int[4];
            d[tnum] = Integer.parseInt(st.nextToken());

            setd(tnum);
            turn();
            K--;
        }

        for(int i=0;i<4;i++){
            if(t[i][0]==1){
                result+=Math.pow(2,i);
            }
        }
        System.out.println(result);
    }
    public static void setd(int tnum){
        //톱니 왼쪽
        for(int i =tnum-1; i>=0;i--){
            if(t[i][2]!=t[i+1][6])
                d[i]=-d[i+1];

        }
        //톱니 오른쪽
        for(int i=tnum+1;i<4;i++){
            if(t[i][6]!=t[i-1][2])
                d[i]=-d[i-1];
        }
    }
    public static void turn(){
        for(int i =0; i<4;i++){
            //시계방향일때
            if(d[i]==1){
                int tp = t[i][7];
                for(int j=7; j>=1;j--){
                    t[i][j]=t[i][j-1];
                }
                t[i][0] =tp;
            }
            if(d[i]==-1){
                int tp = t[i][0];
                for(int j=0;j<7;j++){
                    t[i][j]=t[i][j+1];
                }
                t[i][7]=tp;
            }
        }
    }
}
