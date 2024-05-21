package exercise;
import java.util.Scanner;

public class NumberBaseballGame {

    public static void main(String[] args) {
        int[] answer = {1, 5, 7};
        boolean gameEnd = false;
        int tries = 0;

        Scanner scanner = new Scanner(System.in);

        /*
        * input이 세 자리가 아닐 시 무조건 횟수 차감
        * 중복숫자 발생시 횟수 차감
        * a12와 같이, input이 세자리지만 문자가 섞여 들어온 경우, 횟수 차감 x
        *
        * */

        while (!gameEnd && tries < 10) {
            System.out.println("세 자리 숫자 주세요: ");
            String input = scanner.nextLine();

            try {
                if (input.length() != 3) throw new Exception("입력은 세 자리로 부탁해요");

                if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2)) {
                    throw new Exception("숫자 중복은 안돼요");
                }

                for (char c : input.toCharArray()) {
                    if (!Character.isDigit(c)) {
                        throw new NumberFormatException("숫자만 입력해 주세요.");
                    }
                }

                int userInput = Integer.parseInt(input);
                int[] guess = new int[3];
                for (int i = 2; i >= 0; i--) {
                    guess[i] = userInput % 10;
                    userInput /= 10;
                }

                tries++;
                gameEnd = checkGuess(answer, guess);
            } catch (NumberFormatException e) {
                System.out.println("예외 발생: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("예외 발생: " + e.getMessage());
                tries++;
            }

            if (tries >= 10 && !gameEnd) {
                System.out.println("10번 땡~");
                System.out.println("정답은 " + answer[0] + answer[1] + answer[2] + "이에요~");
            }
        }

    }


    private static boolean checkGuess(int[] answer, int[] guess) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (guess[i] == answer[j]) {
                    if (i == j) {
                        strikes++;
                    } else {
                        balls++;
                    }
                }
            }
        }

        int outs = 3 - (strikes + balls);

        if (strikes == 3) {
            System.out.println("정답...");
            return true;
        } else {
            System.out.println(strikes + " 스트라이크 " + balls + " 볼 " + outs + " 아웃");
            return false;
        }
    }

}