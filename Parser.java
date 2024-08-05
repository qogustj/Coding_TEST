import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Parser {
    private static Map<String, Integer> variables = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static String token;

    public static void main(String[] args) {
        while (true) {
            System.out.print(">> ");
            String input = scanner.nextLine();
            if (input.equals("terminate")) {
                break;
            }
            scanner = new Scanner(input);
            getToken();
            S();
        }
    }

    private static void getToken() {
        if (scanner.hasNext()) {
            token = scanner.next();
        } else {
            token = "";
        }
    }

    // S -> A
    private static void S() {
        A();
    }

    // A -> id = B ; | print id ;
    private static void A() {
        if (token.equals("print")) {
            getToken();
            String id = token;
            getToken();
            if (token.equals(";")) {
                if (variables.containsKey(id)) {
                    System.out.println(variables.get(id) == 1 ? "TRUE" : "FALSE");
                } else {
                    System.out.println("syntax error!!");
                }
                getToken();
            } else {
                System.out.println("syntax error!!");
                // 세미콜론이 없는 경우 다음 토큰을 읽어 오류를 건너뜁니다.
                getToken();
            }
        } else {
            String id = token;
            getToken();
            if (token.equals("=")) {
                getToken();
                int value = B();
                if (token.equals(";")) {
                    variables.put(id, value);
                    getToken();
                } else {
                    System.out.println("syntax error!!");
                }
            } else {
                System.out.println("syntax error!!");
            }
        }
    }

    // B -> C D
    private static int B() {
        int value = C();
        value = D(value);
        return value;
    }

    // C -> E F
    private static int C() {
        int value = E();
        value = F(value);
        return value;
    }

    // D -> == C | != C | < C | > C | <= C | >= C | ε
    private static int D(int left) {
        if (token.equals("==")) {
            getToken();
            int right = C();
            return left == right ? 1 : 0;
        } else if (token.equals("!=")) {
            getToken();
            int right = C();
            return left != right ? 1 : 0;
        } else if (token.equals("<")) {
            getToken();
            int right = C();
            return left < right ? 1 : 0;
        } else if (token.equals(">")) {
            getToken();
            int right = C();
            return left > right ? 1 : 0;
        } else if (token.equals("<=")) {
            getToken();
            int right = C();
            return left <= right ? 1 : 0;
        } else if (token.equals(">=")) {
            getToken();
            int right = C();
            return left >= right ? 1 : 0;
        }
        return left;
    }

    // E -> G H
    private static int E() {
        int value = G();
        value = H(value);
        return value;
    }

    // F -> + E | - E | ε
    private static int F(int left) {
        if (token.equals("+")) {
            getToken();
            int right = E();
            return left + right;
        } else if (token.equals("-")) {
            getToken();
            int right = E();
            return left - right;
        }
        return left;
    }

    // G -> num | id
    private static int G() {
        if (Character.isDigit(token.charAt(0))) {
            int value = Integer.parseInt(token);
            getToken();
            return value;
        } else {
            String id = token;
            getToken();
            return variables.getOrDefault(id, 0);
        }
    }

    // H -> * G | / G | ε
    private static int H(int left) {
        if (token.equals("*")) {
            getToken();
            int right = G();
            return left * right;
        } else if (token.equals("/")) {
            getToken();
            int right = G();
            if (right != 0) {
                return left / right;
            } else {
                System.out.println("syntax error!!");
                return 0;
            }
        }
        return left;
    }
}