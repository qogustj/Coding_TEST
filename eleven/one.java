package eleven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class one {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        System.out.println(compress(line));
        System.out.println(compress1(line));

    }
    public static String compress1(String line){
        boolean inUpperCaseSequence = false;
        StringBuilder result = new StringBuilder();

        for(int i =0; i<line.length(); i++){
            char c = line.charAt(i);
            if(Character.isUpperCase(c) && !inUpperCaseSequence){
                result.append(c);
                inUpperCaseSequence =true;
            }else if(i<line.length()-1&&Character.isUpperCase(line.charAt(i+1))){
                inUpperCaseSequence =false;
            }else {
                if(i>2&&!Character.isUpperCase(c)&&Character.isUpperCase(line.charAt(i-1))&&Character.isUpperCase(line.charAt(i-2))){
//                    result.append(line.charAt(i-1));
                    inUpperCaseSequence =false;
                }
            }
        }
        return result.toString();
    }
    public static String compress(String line) {
        StringBuilder result = new StringBuilder();
        StringBuilder currentWord = new StringBuilder();
        boolean inUpperCaseSequence = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (Character.isUpperCase(c)) {
                if (currentWord.length() > 0 && !inUpperCaseSequence) {
                    result.append(currentWord.charAt(0));
                    currentWord = new StringBuilder();
                }
                currentWord.append(c);
                inUpperCaseSequence = true;
            } else {
                if (inUpperCaseSequence) {
                    if (currentWord.length() > 1) {
                        result.append(currentWord.charAt(0));
                        currentWord = new StringBuilder();
                    }
                    inUpperCaseSequence = false;
                }
                currentWord.append(c);
            }
        }

        if (currentWord.length() > 0) {
            result.append(currentWord.charAt(0));
        }

        return result.toString();
    }
}
