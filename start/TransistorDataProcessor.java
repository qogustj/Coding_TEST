package start;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class TransistorDataProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>();

        System.out.println("여러 줄의 트랜지스터 데이터를 입력하세요. 입력을 마치려면 빈 줄을 입력하세요:");

        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            lines.add(line);
        }

        System.out.println("\n처리된 결과:");

        for (String line : lines) {
            System.out.println(processLine(line));
        }

        scanner.close();
    }

    private static String processLine(String line) {
        String[] parts = line.split("\\+", 2);
        if (parts.length < 2) {
            return line;
        }

        String prefix = parts[0].trim();
        String[] values = parts[1].trim().split("\\s+");

        StringBuilder result = new StringBuilder(prefix).append(" +");

        for (String value : values) {
            String[] keyValue = value.split("=");
            if (keyValue.length == 2) {
                String key = keyValue[0];
                float val = Float.parseFloat(keyValue[1]);

                if (key.equals("ad") || key.equals("as")) {
                    result.append(String.format(" %s=%.2fp", key, val * 0.16));
                } else if (key.equals("pd") || key.equals("ps")) {
                    result.append(String.format(" %s=%.1fu", key, val * 0.4));
                } else {
                    result.append(" ").append(value);
                }
            } else {
                result.append(" ").append(value);
            }
        }

        return result.toString();
    }
}
