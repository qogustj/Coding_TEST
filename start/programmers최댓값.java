//import java.util.*;
//class Solution {
//    public String solution(String s) {
//        String answer = "";
//        int max = Integer.MIN_VALUE;
//
//        int min = Integer.MAX_VALUE;
//        String[] str = s.split(" ");
//        for(int i =0; i<str.length; i++){
//            int num = Integer.parseInt(str[i]);
//
//            max = Math.max(max,num);
//            min = Math.min(min,num);
//        }
//        StringBuilder sb = new StringBuilder();
//        sb.append(min).append(" ").append(max);
//
//        return sb.toString();
//    }
//}