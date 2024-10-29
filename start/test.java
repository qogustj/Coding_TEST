import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {1, gems.length};

        // 전체 보석 종류를 파악
        HashSet<String> gemKinds = new HashSet<>(Arrays.asList(gems));

        // 모든 보석 종류가 1개인 경우
        if (gemKinds.size() == 1) {
            return new int[] {1, 1};
        }

        // 진열대 구간을 저장할 Map
        HashMap<String, Integer> gemMap = new HashMap<>();
        int start = 0;
        int minLength = gems.length + 1;
        HashMap<String,Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>(map.keySet());
        Set<Map.Entry<String,Integer>> set2 = new HashSet<>(map.entrySet());
        // 시작 위치와 끝 위치
        for (int end = 0; end < gems.length; end++) {
            // 현재 보석 개수 추가
            gemMap.put(gems[end], gemMap.getOrDefault(gems[end], 0) + 1);

            // 첫 번째 위치의 보석이 중복되는 경우 시작점을 이동
            while (gemMap.get(gems[start]) > 1) {
                gemMap.put(gems[start], gemMap.get(gems[start]) - 1);
                start++;
            }

            // 모든 종류의 보석이 포함된 경우
            if (gemMap.size() == gemKinds.size() && minLength > end - start) {
                minLength = end - start;
                answer[0] = start + 1;
                answer[1] = end + 1;
            }
        }

        return answer;
    }
}