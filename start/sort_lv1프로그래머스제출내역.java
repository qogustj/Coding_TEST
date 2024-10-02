package start;

import java.util.Arrays;

public class sort_lv1프로그래머스제출내역 {
    public static void main(String[] args){
        int[] numbers1 = {1, 2, 3, 4, 5};
        int[][] command = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        solution(numbers1, command);
    }

    public static int[] solution(int[] array, int[][] commands) {
        int size = commands.length;
        //결과값 저장 배열
        int[] result = new int[commands.length];

        for (int i = 0; i < size; i++) {
            int newSize = commands[i][1]-commands[i][0]+1;
            int[] newArr = new int[newSize];
            System.arraycopy(array, -1 + commands[i][0], newArr, 0, newSize);
            Arrays.sort(newArr);

            result[i] = newArr[commands[i][2]-1];
        }

        return result;
    }
}
