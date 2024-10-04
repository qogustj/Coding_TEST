//package start.dewale;
//
//package start;
//
//abstract class GameRule {
//    abstract String getResponse(int number);
//}
//
//class DefaultGameRule extends GameRule {
//    @Override
//    String getResponse(int number) {
//        String num = String.valueOf(number);
//        for (char ch : num.toCharArray()) {
//            if (ch == '3' || ch == '6' || ch == '9') return "clap";
//        }
//        return String.valueOf(number);
//    }
//}
//
//class BusanGameRule extends GameRule {
//    @Override
//    String getResponse(int number) {
//        String num = String.valueOf(number);
//        int count = 0;
//        for (char ch : num.toCharArray()) {
//            if (ch == '3' || ch == '6' || ch == '9') count++;
//        }
//        if (count == 2) return "clapclap";
//        if (count >= 1) return "clap";
//        return String.valueOf(number);
//    }
//}
//
//class GameRuleFactory {
//    static GameRule getGameRule(String region) {
//        if ("부산".equals(region)) {
//            return new BusanGameRule();
//        }
//        return new DefaultGameRule();
//    }
//}
//
//class Solution {
//    public String solution(String region, String[] playerNames, int maxGameCount) {
//        StringBuilder answer = new StringBuilder();
//        int size = playerNames.length;
//        GameRule gameRule = GameRuleFactory.getGameRule(region);
//
//        for (int i = 1; i <= maxGameCount; i++) {
//            answer.append(playerNames[(i - 1) % size])
//                    .append(": ")
//                    .append(gameRule.getResponse(i))
//                    .append("\n");
//        }
//
//        return answer.toString();
//    }
//
//    public static void main(String[] args) {
//        Solution sol = new Solution();
//        String[] playerNames = {"player1", "player2", "player3"};
//        System.out.print(sol.solution("서울", playerNames, 20));
//        System.out.println("---");
//        System.out.print(sol.solution("부산", playerNames, 20));
//    }
//}
