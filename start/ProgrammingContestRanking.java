package start;

import java.io.*;
import java.util.*;

public class ProgrammingContestRanking {
    static int T, n, k, t, m;

    static class Team implements Comparable<Team> {
        int id;
        int[] scores;
        int totalScore;
        int submissions;
        int lastSubmission;

        public Team(int id, int k) {
            this.id = id;
            this.scores = new int[k + 1];
            this.totalScore = 0;
            this.submissions = 0;
            this.lastSubmission = 0;
        }

        public void updateScore(int problem, int score, int time) {
            this.scores[problem] = Math.max(this.scores[problem], score);
            this.submissions++;
            this.lastSubmission = time;
        }

        public void calculateTotalScore() {
            this.totalScore = Arrays.stream(this.scores).sum();
        }

        @Override
        public int compareTo(Team o) {
            if (this.totalScore != o.totalScore) {
                return Integer.compare(o.totalScore, this.totalScore);
            }
            if (this.submissions != o.submissions) {
                return Integer.compare(this.submissions, o.submissions);
            }
            return Integer.compare(this.lastSubmission, o.lastSubmission);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            Map<Integer, Team> teams = new HashMap<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int problem = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                teams.putIfAbsent(id, new Team(id, k));
                teams.get(id).updateScore(problem, score, i);
            }

            for (Team team : teams.values()) {
                team.calculateTotalScore();
            }

            List<Team> rankedTeams = new ArrayList<>(teams.values());
            Collections.sort(rankedTeams);

            int yourRank = 1;
            for (Team team : rankedTeams) {
                if (team.id == t) break;
                yourRank++;
            }

            System.out.println(yourRank);
        }
    }
}