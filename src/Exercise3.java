import java.util.Scanner;
public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a phone number :");
        String phoneNumber = scanner.nextLine();
        System.out.println("Your number is : "+arrangingAPhoneNumber(phoneNumber));
    }

    public static String arrangingAPhoneNumber (String phoneNumber){
        String newPhoneNumber = "---";
        if (isStringAPhoneNumber(phoneNumber)){
            switch (phoneNumber.length()){
                case 10:
                    newPhoneNumber =createANewPhoneNumber(2,phoneNumber);
                    break;
                case 11:
                    newPhoneNumber = phoneNumber;
                    break;
                case 12:
                    newPhoneNumber =createANewPhoneNumber(4,phoneNumber);
                    break;
            }
        }

        return newPhoneNumber;
    }

    public static boolean isStringAPhoneNumber(String stringToCheck){
        boolean isNumber = (stringToCheck.length()>=10 && stringToCheck.length()<=12);
        for (int i = 0; i < stringToCheck.length() && isNumber; i++) {
            String number = "";
            isNumber = false;
            for (int j = 0; j < 10; j++) {
                number =""+j;
                if (stringToCheck.charAt(i)==number.charAt(0)||(stringToCheck.length()==11 && i==3 && stringToCheck.charAt(i)=='-')){
                    isNumber=true;
                    break;
                }
            }
        }
        return isNumber && prefixCheck(stringToCheck);
    }

    public static boolean prefixCheck (String phoneNumber){
        boolean isNormalPrefix = true;
        String prefix = "";
        if (phoneNumber.length()==12)
        {
            prefix="9725";
        }else if (phoneNumber.length()==10 || (phoneNumber.length()==11 && phoneNumber.charAt(3)=='-')){
            prefix = "05";
        }else isNormalPrefix = false;

        for (int i = 0; i < prefix.length() && isNormalPrefix; i++) {
                isNormalPrefix=(prefix.charAt(i)==phoneNumber.charAt(i));
        }
        return isNormalPrefix;
    }

    public static String createANewPhoneNumber (int startIndex, String phoneNumber){
        String newPhone = "05"+phoneNumber.charAt(startIndex)+"-";
        for (int i = startIndex+1; i < phoneNumber.length(); i++) {
            newPhone = newPhone+phoneNumber.charAt(i);
        }
        return  newPhone;
    }
}
