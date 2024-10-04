//package start.dewale;
//
//Output">
//import java.util.concurrent.CompletableFuture;
//
//class Solution {
//    public CompletableFuture<Integer> solution(String[] playerNames, int maxGameCount) {
//        ClapCounter clapCounter = ClapCounter.getInstance();
//        clapCounter.resetCount();  // 카운터 초기화
//        Game game1 = new Game("서울", playerNames, maxGameCount, clapCounter);
//        Game game2 = new Game("부산", playerNames, maxGameCount, clapCounter);
//
//        CompletableFuture<Void> future1 = game1.play();
//        CompletableFuture<Void> future2 = game2.play();
//
//        return CompletableFuture.allOf(future1, future2)
//                .thenApply(v -> clapCounter.getCount());
//    }
//}
//
//class Game {
//    private final String region;
//    private final String[] playerNames;
//    private final int maxGameCount;
//    private final ClapCounter clapCounter;
//
//    public Game(String region, String[] playerNames, int maxGameCount, ClapCounter clapCounter) {
//        this.region = region;
//        this.playerNames = playerNames;
//        this.maxGameCount = maxGameCount;
//        this.clapCounter = clapCounter;
//    }
//
//    public CompletableFuture<Void> play() {
//        return CompletableFuture.runAsync(() -> {
//            int size = playerNames.length;
//            for (int i = 1; i <= maxGameCount; i++) {
//                String response = getResponse(i);
//                if (isClap(response)) {
//                    if (response.equals("clapclap")) {
//                        clapCounter.incrementCount();  // 추가 박수 카운트
//                    }
//                    clapCounter.incrementCount();
//                }
//                // System.out.println 제거: 테스트 환경에서는 출력이 필요없을 수 있음
//            }
//        });
//    }
//
//    private String getResponse(int number) {
//        String num = String.valueOf(number);
//        int count = 0;
//        for (char ch : num.toCharArray()) {
//            if (ch == '3' || ch == '6' || ch == '9') count++;
//        }
//        if (count == 2 && "부산".equals(region)) return "clapclap";
//        if (count >= 1) return "clap";
//        return String.valueOf(number);
//    }
//
//    private boolean isClap(String response) {
//        return "clap".equals(response) || "clapclap".equals(response);
//    }
//}
//
//class ClapCounter {
//    private static ClapCounter clapCounter = new ClapCounter();
//    private int count;
//
//    private ClapCounter() {
//        this.count = 0;
//    }
//
//    public static ClapCounter getInstance() {
//        return clapCounter;
//    }
//
//    public synchronized int getCount() {
//        return count;
//    }
//
//    public synchronized void incrementCount() {
//        count++;
//    }
//
//    public synchronized void resetCount() {
//        count = 0;
//    }
//}
