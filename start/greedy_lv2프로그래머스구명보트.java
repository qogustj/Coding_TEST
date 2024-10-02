package start;

import java.util.Arrays;

public class greedy_lv2프로그래머스구명보트 {

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            answer++;
        }

        return answer;
    }
}
