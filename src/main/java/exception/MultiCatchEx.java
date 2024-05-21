package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiCatchEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] cards = {1,2,3,4,5,6};

        try {
            System.out.println("카드를 선택해주세요.");
            int cardIdx = scanner.nextInt();

            System.out.println(cardIdx);
            System.out.println("번째 카드에 적힌 숫자는 : " + cards[cardIdx]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("숫자가 없음");
        } catch (InputMismatchException e) {
            System.out.println("입력이 잘못됨");
        }
    }
}
