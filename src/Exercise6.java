import java.util.Scanner;
public class Exercise6 {
    public static void main(String[] args) {
        int[] firstArray = creatArray(arraySize("first"));
        int[] secondArray = creatArray(arraySize("second"));
        if (areArraysForeign(firstArray,secondArray)){
            System.out.println("The arrays are foreign !");
        }else {
            System.out.println("The array derived from the first and second arrays is:");
            int[] cuttingArray = cutArray(firstArray,secondArray);
            for (int i = 0; i <cuttingArray.length ; i++) {
                System.out.print(cuttingArray[i]+", ");
            }
        }
    }

    public static int[] cutArray (int[] firstArray, int[] secondArray){
        int[] cutting = new int[firstArray.length];
        int index = 0;
        for (int i = 0; i < firstArray.length; i++) {
            for (int j = 0; j < secondArray.length && !isNumberAppeared(i,firstArray) ; j++) {
                if (firstArray[i]==secondArray[j]){
                    cutting[index]=firstArray[i];
                    index++;
                    break;
                }
            }
        }
        int[] finishedCutArray = null;
        if (index==firstArray.length){
            finishedCutArray=cutting;
        }else {
            finishedCutArray = new int[index];
            for (int i = 0; i<finishedCutArray.length ; i++) {
                finishedCutArray[i]=cutting[i];
            }
        }
        return finishedCutArray;
    }

    public static boolean areArraysForeign (int[] firstArray, int[] secondArray){
        boolean foreign = false;
        if (cutArray(firstArray,secondArray).length == 0){
            foreign = true;
        }
        return foreign;
    }

    public static boolean isNumberAppeared (int index, int [] numbersArray){
        boolean appeared = false;
        for (int i = index-1; i >= 0 ; i--) {
            if (numbersArray[i]==numbersArray[index]){
                appeared = true;
                break;
            }
        }
        return appeared;
    }




    public static int[] creatArray (int size){
        Scanner scanner = new Scanner(System.in);
        int [] array = new int[size];
        for (int i = 0; i < size; i++) {
            while (array[i]<10 || array[i]>99){
                System.out.println("Type a positive double-digit number : ("+(i+1)+")" );
                array[i]= scanner.nextInt();
            }
        }
        return array;
    }

    public static int arraySize (String arrayName){
        Scanner scanner = new Scanner(System.in);
        int size = -1;
        while (size<=0){
            System.out.println("How many numbers do you want to type in the "+arrayName+" array ? (a positive number)");
            size =scanner.nextInt();
        }
        return size;
    }
}
