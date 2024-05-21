package exception;

public class ArrayIndexOutOfBoundEx {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};
        int[] numbers2 = {1, 2, 3, 4};

        try{
            System.out.println(numbers[5]);
            System.out.println(numbers2[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("out of range");
        }

    }
}
