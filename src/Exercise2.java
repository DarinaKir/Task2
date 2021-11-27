import java.util.Scanner;
public class Exercise2 {
    public static final int NUMBER_NUMBERS = 10;

    public static void main(String[] args) {
        largerNumbersThanAverage();
    }

    public static void largerNumbersThanAverage (){
        Scanner scanner = new Scanner(System.in);
        int [] numbers = new int[NUMBER_NUMBERS];
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Enter a number:");
            numbers[i] = scanner.nextInt();
            sum+=numbers[i];
        }
        int average = sum/numbers.length;
        System.out.print("The larger than average ( "+average+" ) numbers are: ");
        for (int i = 0; i < numbers.length; i++) {
            if (average<numbers[i]){
                System.out.print(numbers[i]+", ");
            }
        }
    }
}
