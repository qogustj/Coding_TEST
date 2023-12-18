public class 약수의합 {
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        // solution(12);
        System.out.print(solution(12));
    }



    public static int solution(int n) {
        for(int i=1;i<=n;i++){
            if(n%i==0){

                answer+=i;
            }
        }
        return answer;
    }

}