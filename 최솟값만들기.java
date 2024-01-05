import java.util.Arrays;

public class 최솟값만들기 {
    public static int solution(int[] A, int[] B) {
        // 배열 A를 오름차순 정렬, 배열 B를 내림차순 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        reverseArray(B);

        int answer = 0;

        // 최솟값을 만들기 위해 A의 가장 작은 수와 B의 가장 큰 수를 곱하여 누적
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[i];
        }

        return answer;
    }

    // 배열을 역순으로 정렬하는 메소드
    private static void reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            // Swap start and end elements
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            // Move indices towards the center
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};

        int result = solution(A, B);
        System.out.println(result); // 출력 결과: 29
    }
}
