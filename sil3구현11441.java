import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sil3구현11441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[][] array1 = new int[M][2];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++) {
                array1[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < M; i++) {
            int result = 0;
            for(int j = array1[i][0]-1 ; j <= array1[i][1]-1 ; j++) {
                result += array[j];
            }
            System.out.println(result);
        }
    }
}
