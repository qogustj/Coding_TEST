public class 정수제곱근판별 {
    public static void main(String[] args) throws Exception {

        System.out.print(solution(121));
    }



    public static long solution(long n) {
        long answer = 0;
        for(int i=(int) n;i>0;i--){
            if(i*i==n){
                answer=(i+1)*(i+1);
            }
        }

        return answer;
    }

}