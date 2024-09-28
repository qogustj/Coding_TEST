package start;

import java.io.*;
import java.util.*;


public class simul_s2백준20006 {
    static int p, m;
    static List<Room> rooms = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            Player player = new Player(level, name);

            boolean joined = false;
            for (Room room : rooms) {
                if (room.canJoin(player)) {
                    room.addPlayer(player);
                    joined = true;
                    break;
                }
            }

            if (!joined) {
                rooms.add(new Room(player));
            }
        }

        for (Room room : rooms) {
            if (room.isFull()) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }

            room.players.sort(Comparator.comparing(a -> a.name));
            for (Player player : room.players) {
                System.out.println(player.level + " " + player.name);
            }
        }
    }

    static class Player {
        int level;
        String name;

        Player(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }

    static class Room {
        int minLevel;
        int maxLevel;
        List<Player> players;

        Room(Player player) {
            this.minLevel = player.level - 10;
            this.maxLevel = player.level + 10;
            this.players = new ArrayList<>();
            this.players.add(player);
        }

        boolean canJoin(Player player) {
            return  player.level>= minLevel && player.level <= maxLevel && players.size() < m;
        }

        void addPlayer(Player player) {
            players.add(player);
        }

        boolean isFull() {
            return players.size() == m;
        }
    }
}