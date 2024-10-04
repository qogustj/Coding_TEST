//package start;
//
//class Solution {
//    public String solution(String region, String[] playerNames, int maxGameCount) {
//        StringBuilder answer = new StringBuilder();
//        int size = playerNames.length;
//        int start = 0;
//        while (maxGameCount != start) {
//            answer.append(playerNames[start % size])
//                    .append(": ")
//                    .append(do369(start + 1, region))
//                    .append("\n");
//            start++;
//        }
//
//        return answer.toString();
//    }
//
//    private String do369(int number, String region) {
//        String num = String.valueOf(number);
//        int regionCnt =0;
//        for (char ch : num.toCharArray()) {
//            if (ch == '3' || ch == '6' || ch == '9') regionCnt++;
//        }
//        if(regionCnt==2 && region.equals("부산")) return "clapclap";
//        if(regionCnt>=1) return "clap";
//        return String.valueOf(number);
//    }
//}