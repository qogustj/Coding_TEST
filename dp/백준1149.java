package dp;

import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

    public class 백준1149 {
    //    static Integer[][] dp;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int N = Integer.parseInt(br.readLine());
            int[][] cost = new int[N][3];
    //        dp = new Integer[N][3];

            for(int j=0;j<N;j++){
                st = new StringTokenizer(br.readLine(), " ");
                cost[j][0]=Integer.parseInt(st.nextToken());
                cost[j][1]=Integer.parseInt(st.nextToken());
                cost[j][2]=Integer.parseInt(st.nextToken());
            }
            for(int i=1; i<N;i++){
                cost[i][0]=Math.min(cost[i-1][1],cost[i-1][2])+cost[i][0];
                cost[i][1]=Math.min(cost[i-1][0],cost[i-1][2])+cost[i][1];
                cost[i][2]=Math.min(cost[i-1][0],cost[i-1][1])+cost[i][2];
            }
            //음 재귀랑 반복문에서 n-1을 신경써야겠다
            System.out.println(Math.min(cost[N-1][0],Math.min(cost[N-1][1],cost[N-1][2] )));
        }
    }
