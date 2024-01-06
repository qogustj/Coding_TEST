public class 올바른괄호 {
    public static void main(String[] args) throws Exception {

        System.out.print(solution(")()()("));

    }
    static boolean solution(String s) {
        int trueNum =0;
        boolean answer=false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                trueNum++;
            } else if (s.charAt(i)==')') {
                trueNum--;
            }
            if(trueNum<0){
                break;
            }
        }
        if (trueNum==0&&s.charAt(0)!=')'&&s.charAt(s.length()-1)!='(') {
            answer = true;
        }
        return answer;
    }

}
// 16~18에서 num이 -가 되면 바로 중지하는걸 놓친게 컸다 까비!