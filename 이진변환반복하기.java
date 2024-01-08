public class 이진변환반복하기 {
    public static void main(String[] args) throws Exception {

        System.out.print(solution("110010101001"));

    }

    public static int[] solution(String s) {
        int[] answer = new int[2];

        while (!s.equals("1")) {
            // 1. 0 제거
            int removedZeros = 0;
            StringBuilder sb = new StringBuilder();
            for (char ch : s.toCharArray()) {
                if (ch == '1') {
                    sb.append(ch);
                } else {
                    removedZeros++;
                }
            }

            // 2. 이진 변환
            s = Integer.toBinaryString(sb.length());
            answer[0]++; // 변환 횟수 증가
            answer[1] += removedZeros; // 제거된 0의 개수 누적
        }

        return answer;
        /*
        int zeroNum=0;
        int oneNum=0;
        int count=0;
        String two="";
        while (s.contains("0")) {
            two="";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    if(i==0){
                        s=s.substring(1);
                    }else {
                        zeroNum++;
                        s = s.substring(0, i) + s.substring(i + 1);
                        i--; // 현재 인덱스를 다시 확인하기 위해 i를 하나 줄입니다.
                    }
                }
                if (s.charAt(i) == '1') {
                    oneNum++;
                }
            }
            oneNum=oneNum/2;
            for (int j = (int) (Math.sqrt(oneNum)); j > 0; j--) {
                if (oneNum % Math.pow(2, j) != 0) {
                    two=two+"0";
                } else {
                    two=two+"1";
                }
            }
            s=two;
//            two="";
            count++;
        }
        int[] answer = {count,zeroNum};
        return answer;*/
    }

}
