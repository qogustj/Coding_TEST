public class 문자열내p와y의개수 {
    public static void main(String[] args) throws Exception {

        System.out.print(solution("abab"));

    }



    public static boolean solution(String s) {
        int pnum=0;
        int ynum=0;
        int num=0;
        boolean answer = true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='p'||s.charAt(i)=='P'){
                pnum++;
            }
            else if(s.charAt(i)=='y'||s.charAt(i)=='Y'){
                ynum++;
            }
            else{
                num++;
            }
        }
        if(pnum==ynum||num==s.length()){
            answer=true;
        }
        else{
            answer=false;
        }

        return answer;
    }
}