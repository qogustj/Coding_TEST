//package start;
//
//public class player {
//    public String solution(String[] playerNames, int[] errorRates, int maxGameCount, int[] randomValues) {
//        Player[] players = new Player[playerNames.length];
//        //playerNames, errorRates 를 사용하여 players 만드는 코드를 작성해주세요.
//        for (int i=0; i<players.length;i++){
//            players[i] = new Player(playerNames[i], errorRates[i]);
//        }
//        return playGame(players, maxGameCount, new Random(maxGameCount, randomValues));
//    }
//
//    private String playGame(Player[] players, int maxGameCount, Random random) {
//        StringBuilder answer = new StringBuilder();
//        int currentNumber = 1;
//
//        while (currentNumber <= maxGameCount) {
//            for (Player player : players) {
//                int randomValue = random.getNextInt();
//                boolean isCorrect = randomValue > player.getErrorRate();
//
//                answer.append(player.getName()).append(": ");
//
//                if (isCorrect) {
//                    answer.append(do369(currentNumber));
//                } else {
//                    answer.append("(오답)");
//                }
//                answer.append("\n");
//
//                if (currentNumber == maxGameCount) break;
//            }
//            currentNumber++;
//        }
//        return answer.toString();
//    }
//    private String do369(int number) {
//        String num = String.valueOf(number);
//        for (char ch : num.toCharArray()) {
//            if (ch == '3' || ch == '6' || ch == '9') return "clap";
//        }
//        return String.valueOf(number);
//    }
//
//    static class Player {
//
//        private String name;
//
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
//    /**
//     * 이 클래스는 수정하지 마세요.
//     */
//    static private class Random {
//
//        private int currentCount;
//
//        private int maxCount;
//
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
//        /**
//         * 0~99까지의 값을 리턴하는 함수 각 숫자는 모두 나올 확율이 같다고 가정하면된다.
//         */
//        public int getNextInt() {
//            return randomValues[currentCount++];
//        }
//    }
//}
