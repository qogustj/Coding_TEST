public class jadencase문자열만들기 {
    public static void main(String[] args) throws Exception {

        System.out.print(solution("for the last week"));

    }



    public static String solution(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        char[] charArray = s.toCharArray();

        // 첫 번째 문자는 무조건 대문자로 변환
        charArray[0] = Character.toUpperCase(charArray[0]);

        for (int i = 1; i < charArray.length; i++) {
            // 공백 다음의 문자는 대문자로, 이외의 문자는 소문자로 변환
            if (charArray[i - 1] == ' ') {
                charArray[i] = Character.toUpperCase(charArray[i]);
            } else {
                charArray[i] = Character.toLowerCase(charArray[i]);
            }
        }

        return new String(charArray);
    }
}
