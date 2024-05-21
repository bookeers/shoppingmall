package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MbtiThrowsEx
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("=== MBTI ===");
            checkEorI(scanner);

            System.out.println("당신의 MBTI는");
        }
        catch (InputMismatchException e) {
            System.out.println("키보드 입력이 잘못되었습니다");
        }
        finally {
            if (scanner != null)
                scanner.close();
        }
    }

    public static void checkEorI(Scanner scanner) throws InputMismatchException {
        System.out.println("1. 나는 바깥에서 에너지를 얻는다");
        System.out.println("2. 나는 혼자 있을 때 에너지를 얻는다.");
        System.out.print("당신의 선택은? _ ");

        int choice = scanner.nextInt();

        switch(choice) {
            case 1:
                System.out.println("'E' 입니다.");
                break;
            case 2:
                System.out.println("'I' 입니다.");
                break;
            default:
                throw new InputMismatchException("올바른 숫자를 입력하세요.");
        }
    }
}
