package main.swapping;

import java.io.*;
import java.util.*;

public class g511000 {
    static class Time {
        int time;
        int isStart;  // 1이면 시작, -1이면 종료

        Time(int time, int isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Time> times = new ArrayList<>();

        // 시작 시간과 종료 시간을 따로 저장
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            times.add(new Time(start, 1));
            times.add(new Time(end, -1));
        }

        // 시간 순으로 정렬, 같은 시간이면 종료를 먼저 처리
        Collections.sort(times, (a, b) -> {
            if(a.time == b.time) {
                return a.isStart - b.isStart;
            }
            return a.time - b.time;
        });

        int count = 0;
        int result = 0;

        // 시간순으로 진행하면서 겹치는 수업 수를 계산
        for(Time t : times) {
            count += t.isStart;
            result = Math.max(result, count);
        }

        System.out.print(result);
    }
}
