import java.util.Scanner;
public class Exercise5 {
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
        System.out.println("The summit array index is : "+ ascendingDescendingArray(numbers));
    }

    public static int ascendingDescendingArray (int[] numbersArray){
        int summitIndex = 0;
        for (int i = 0; i < numbersArray.length-1; i++) {
            if (numbersArray[i]<numbersArray[i+1]){
                summitIndex++;
            }else break;
        }
        boolean isAscendingDescending = (summitIndex!=numbersArray.length-1 && summitIndex!=0);
        for (int i = summitIndex; i < numbersArray.length-1 && isAscendingDescending; i++) {
            isAscendingDescending = (numbersArray[i]>numbersArray[i+1]);
        }
        if (!isAscendingDescending){
            summitIndex = -1;
        }
        return summitIndex;
    }
}
