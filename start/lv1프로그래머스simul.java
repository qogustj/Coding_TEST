package start;
import java.util.*;

class greedy_프로그래머스lv1체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];

        // 모든 학생이 체육복을 1개씩 가지고 있다고 가정
        Arrays.fill(students, 1);

        // 도난당한 학생 처리
        for (int l : lost) {
            students[l-1]--;
        }

        // 여벌 체육복 가진 학생 처리
        for (int r : reserve) {
            students[r-1]++;
        }

        // 체육복 빌려주기
        for (int i = 0; i < n; i++) {
            if (students[i] == 0) {
                if (i > 0 && students[i-1] == 2) {
                    students[i]++;
                    students[i-1]--;
                } else if (i < n-1 && students[i+1] == 2) {
                    students[i]++;
                    students[i+1]--;
                }
            }
        }

        // 체육 수업을 들을 수 있는 학생 수 계산
        int answer = 0;
        for (int s : students) {
            if (s > 0) answer++;
        }

        return answer;
    }
}