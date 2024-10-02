package start;
import java.io.*;
import java.util.*;
public class sort_lv1구름숫자제거정렬 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i =0; i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        int cnt =0;
        int val = 1;
        for(int i=0;i<n;i++){
            if(cnt!=arr[i]) val=1;
            if(cnt!=arr[i]&&val==1) {
                sb.append(arr[i]).append(" ");
                val--;
                cnt = arr[i];
            }else if(cnt==arr[i]&&val==0){
                continue;
            }
        }
        System.out.print(sb);
    }
}
