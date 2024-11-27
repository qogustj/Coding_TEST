package main.two_pointer;

import java.io.*;
import java.util.*;

public class g52470 {
    static int[] arr;
    static int result = Integer.MAX_VALUE;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[101];
        visit = new boolean[101];

        // 기본 배열 초기화
        for(int i=1; i<=100; i++) {
            arr[i] = i;
        }

        // 사다리 정보 입력
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x] = y;
        }

        // 뱀 정보 입력
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x] = y;
        }

        bfs();
        System.out.print(result);
    }

    // BFS로 변경 (최단 경로 문제이므로 BFS가 더 적합)
    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        visit[1] = true;
        q.offer(new int[]{1, 0}); // 위치, 주사위 굴린 횟수

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int pos = current[0];
            int cnt = current[1];

            if(pos == 100) {
                result = Math.min(result, cnt);
                continue;
            }

            for(int i=1; i<=6; i++) {
                int next = pos + i;
                if(next > 100) continue;

                next = arr[next]; // 뱀이나 사다리가 있는 경우 이동

                if(!visit[next]) {
                    visit[next] = true;
                    q.offer(new int[]{next, cnt+1});
                }
            }
        }
    }
}
