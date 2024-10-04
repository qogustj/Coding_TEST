//public class Solution {
//
//    public String solution(String[] playerNames, int[] errorRates, int maxGameCount, int[] randomValues) {
//        Player[] players = new Player[playerNames.length];
//        for (int i = 0; i < players.length; i++) {
//            players[i] = new Player(playerNames[i], errorRates[i]);
//        }
//        return playGame(players, maxGameCount, new Random(maxGameCount, randomValues));
//    }
//
//    private String playGame(Player[] players, int maxGameCount, Random random) {
//        StringBuilder answer = new StringBuilder();
//        int currentNumber = 1;
//        int playerIndex = 0;
//
//        while (currentNumber <= maxGameCount) {
//            Player player = players[playerIndex];
//            int randomValue = random.getNextInt();
//            boolean isCorrect = randomValue > player.getErrorRate();
//
//            answer.append(player.getName()).append(": ");
//
//            if (isCorrect) {
//                answer.append(do369(currentNumber));
//            } else {
//                answer.append("(오답)");
//            }
//            answer.append("\n");
//
//            currentNumber++;
//            playerIndex = (playerIndex + 1) % players.length;
//        }
//
//        return answer.toString();
//    }
//
//    private String do369(int number) {
//        String num = String.valueOf(number);
//        for (char ch : num.toCharArray()) {
//            if (ch == '3' || ch == '6' || ch == '9') return "clap";
//        }
//        return String.valueOf(number);
//    }
//
//    static class Player {
//        private String name;
//        private int errorRate;
//
//        public Player(String name, int errorRate) {
//            this.name = name;
//            this.errorRate = errorRate;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public int getErrorRate() {
//            return errorRate;
//        }
//    }
//
//    static private class Random {
//        private int currentCount;
//        private int maxCount;
//        private int[] randomValues;
//
//        public Random(int maxCount, int[] randomValues) {
//            if (randomValues.length != maxCount) {
//                throw new IllegalArgumentException("Random 클래스 초기화 실패");
//            }
//            this.maxCount = maxCount;
//            this.randomValues = randomValues;
//        }
//
//        public int getNextInt() {
//            return randomValues[currentCount++];
//        }
//    }
//}