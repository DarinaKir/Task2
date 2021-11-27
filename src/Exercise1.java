import java.util.Scanner;
public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first string :");
        String firstString = scanner.nextLine();
        System.out.println("Enter the second string :");
        String secondString = scanner.nextLine();
        System.out.print("Does the first string contain the second string ? : ");
        System.out.println(isStringInclude(firstString,secondString));
    }


    public static boolean isStringInclude (String totalString, String includedString){
        boolean include = false;
        for (int i = 0; i <= totalString.length() - includedString.length(); i++) {
            if (totalString.charAt(i) == includedString.charAt(0)){
                include = true;
                for (int j = 0; j < includedString.length() && include; j++) {
                    include= (totalString.charAt(i+j) == includedString.charAt(j));
                }
            }
            if (include){
                break;
            }
        }
        return include;
    }

}
