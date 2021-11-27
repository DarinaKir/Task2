import java.util.Scanner;
public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arraySize = -1;
        do {
            System.out.println("How many numbers do you want to type ? (a positive number) :");
            arraySize = scanner.nextInt();
        }while (arraySize<=0);
        int[] numbers = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            System.out.println("Type a number :");
            numbers[i]=scanner.nextInt();
        }
        System.out.println("Array without duplicates : ");
        int[] newArray = arrayWithoutDuplicates(numbers);
        for (int i = 0; i < newArray.length ; i++) {
            System.out.print(newArray[i]+", ");
        }
    }

    public static int[] arrayWithoutDuplicates (int[] arrayNumbers){
        int duplicatesNumbers = 0;
        for (int i = 1; i < arrayNumbers.length; i++) {
            if (isDuplicate(i,arrayNumbers)){
                duplicatesNumbers++;
            }
        }
        int [] newArrayNumbers = null;
        if (duplicatesNumbers==0){
            newArrayNumbers = arrayNumbers;
        }else {
            newArrayNumbers = new int[arrayNumbers.length-duplicatesNumbers];
            int index =-1;
            for (int i = 0; i < arrayNumbers.length; i++) {
                if(!isDuplicate(i,arrayNumbers)){
                    index++;
                    newArrayNumbers[index]=arrayNumbers[i];
                }
            }
        }
        return newArrayNumbers;
    }

    public static boolean isDuplicate (int index, int[] array){
        boolean duplicate = false;
        for (int i = index-1; i >=0 && !duplicate ; i--) {
            duplicate = (array[index] == array[i]);
        }
        return duplicate;
    }
}
