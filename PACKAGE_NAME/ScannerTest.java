package PACKAGE_NAME;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();

        switch (score < 0 ? -1 : score > 100 ? 11 : score / 10) {
            case 10:
            case 9:
                System.out.println("A등급");
                break;
            case 8:
                System.out.println("B등급");
                break;
            case 7:
                System.out.println("C등급");
                break;
            case 6:
                System.out.println("D등급");
                break;
            case 5:
            case 4:
            case 3:
            case 2:
            case 1:
            case 0:
                System.out.println("F등급");
                break;
            default:
                System.out.println("잘못입력하였습니다. 0부터 100 사이의 점수를 입력해주세요.");
                break;
        }
    }
}