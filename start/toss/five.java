package start.toss;

import java.util.*;
class five {
    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(new String[]{"db", "testdb://localhost:12345", "password", "test", "db-test", "{db}?{password}test=123"})));
    }
    public static String[] solution(String[] arr) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < arr.length - 1; i += 2) {
            map.put(arr[i], arr[i + 1]);
        }

        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = (i % 2 == 0) ? arr[i] : resolve(map, arr[i - 1], new HashSet<>());
        }

        return result;
    }

    private static String resolve(Map<String, String> map, String key, Set<String> seen) {
        if (seen.contains(key)) return "";
        seen.add(key);

        String val = map.get(key);
        if (val == null) return "";

        StringBuilder sb = new StringBuilder();
        int start = 0;
        while (start < val.length()) {
            int open = val.indexOf("{", start);
            if (open == -1) {
                sb.append(val.substring(start));
                break;
            }
            sb.append(val.substring(start, open));
            int close = val.indexOf("}", open);
            if (close == -1) {
                sb.append(val.substring(open));
                break;
            }

            String refKey = val.substring(open + 1, close);
            String resolved = resolve(map, refKey, new HashSet<>(seen));
            sb.append(resolved);
            start = close + 1;
        }

        seen.remove(key);
        String result = sb.toString();
        return result.isEmpty() ? val : result;
    }
}
