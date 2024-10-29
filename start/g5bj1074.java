package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g5bj1074 {
    static int cnt;
    static int r,c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        z((int) Math.pow(2,n),0,0);
    }
    public static void z(int size, int x, int y){

            if(y==r && x==c){
                System.out.println(cnt);
                System.exit(0);  // 답을 찾으면 프로그램 종료
            }


        if (!(x <= c && c < x + size && y <= r && r < y + size)) {
            cnt += size * size;
            return;
        }
        size = size/2;
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                z(size, x+size*j, y+size*i);
            }
        }
    }
}
