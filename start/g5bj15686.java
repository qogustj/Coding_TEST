package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class g5bj15686 {
    static int[][] arr;
    static int n, m;
    static int size;
    static LinkedList<int[]> map;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        map = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    map.add(new int[]{i, j});
                } else {
                    arr[i][j] = num;
                }
            }
        }

        size = map.size();
        visited = new boolean[size];

        combination(0, 0);
        System.out.println(min);
    }

    // idx: 현재 검사하는 치킨집 인덱스, count: 현재까지 선택한 치킨집 개수
    public static void combination(int idx, int count) {
        // m개의 치킨집을 모두 선택했다면
        if (count == m) {
            LinkedList<int[]> selectedChickens = new LinkedList<>();
            // visited 배열을 확인하여 선택된 치킨집들을 리스트에 추가
            for (int i = 0; i < size; i++) {
                if (visited[i]) {
                    selectedChickens.add(map.get(i));
                    arr[map.get(i)[0]][map.get(i)[1]] = 2;
                }
            }

            min = Math.min(min, calculateDistance(selectedChickens));

            // 맵 상태 되돌리기
            for (int i = 0; i < size; i++) {
                if (visited[i]) {
                    arr[map.get(i)[0]][map.get(i)[1]] = 0;
                }
            }
            return;
        }

        // 더 이상 선택할 치킨집이 없는 경우
        if (idx >= size) return;

        // 현재 치킨집을 선택하는 경우
        visited[idx] = true;
        combination(idx + 1, count + 1);

        // 현재 치킨집을 선택하지 않는 경우
        visited[idx] = false;
        combination(idx + 1, count);
    }

    public static int calculateDistance(LinkedList<int[]> list) {
        int result = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == 1) {
                    int minDist = Integer.MAX_VALUE;
                    for (int[] current : list) {
                        minDist = Math.min(minDist, Math.abs(i - current[0]) + Math.abs(j - current[1]));
                    }
                    result += minDist;
                }
            }
        }
        return result;
    }
}