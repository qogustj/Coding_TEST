public class 숫자의표현 {
    public static void main(String[] args) throws Exception {

        System.out.print(solution(15));

    }



    public static int solution(int n) {
        int j=0;
        int i=0;
        int k=0;
        int answer = 0;
        while(k!=15) {
            for (i = k; i < n + 1; i++) {
                j = i + j;
                if (j == 15) {
                    answer++;
                    k=i;
                }
            }
        }
        return answer;
    }
}
