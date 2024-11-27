package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class g4bj2580 {
    static int[][] arr = new int[9][9];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0, 0);
    }

    public static void sudoku(int row, int col) {
        // 현재 행이 다 채워졌을 경우 다음 행으로
        if(col == 9) {
            sudoku(row + 1, 0);
            return;
        }

        // 모든 행과 열이 다 채워졌을 경우 결과 출력
        if(row == 9) {
            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
            System.exit(0);
        }

        // 빈 칸일 경우
        if(arr[row][col] == 0) {
            for(int i=1; i<=9; i++) {
                if(isPossible(row, col, i)) {
                    arr[row][col] = i;
                    sudoku(row, col + 1);
                }
            }
            arr[row][col] = 0;
            return;
        }

        sudoku(row, col + 1);
    }

    public static boolean isPossible(int row, int col, int value) {
        // 같은 행에 있는 원소들 중 겹치는 열 원소가 있는지 검사
        for(int i=0; i<9; i++) {
            if(arr[row][i] == value) {
                return false;
            }
        }

        // 같은 열에 있는 원소들 중 겹치는 행 원소가 있는지 검사
        for(int i=0; i<9; i++) {
            if(arr[i][col] == value) {
                return false;
            }
        }

        // 3*3 칸에 중복되는 원소가 있는지 검사
        int set_row = (row/3)*3;
        int set_col = (col/3)*3;

        for(int i=set_row; i<set_row+3; i++) {
            for(int j=set_col; j<set_col+3; j++) {
                if(arr[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}