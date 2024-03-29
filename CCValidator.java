import java.util.Scanner;

public class CCValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cardNumber;
        // to check if entered values are numbers, if someone puts strings (A, B, ...) , then returns invalid credit card
        do {
            System.out.print("Please enter a credit card number: ");
            cardNumber = scanner.nextLine();

            if (!cardNumber.matches("[0-9]+")) {
                System.out.println("You did not enter a number.");
            }
        } while (!cardNumber.matches("[0-9]+"));

        // Check if the card number length is between 13 and 16 digits
        if (cardNumber.length() < 13 || cardNumber.length() > 16) {
            System.out.println(cardNumber + " is an invalid credit card number.");
            return;
        }

        // Check the card type based on the first digit(s)
        char firstDigit = cardNumber.charAt(0);
        char secondDigit = cardNumber.charAt(1);

        if (firstDigit == '4') {
            System.out.print(cardNumber + " is a Visa credit card. ");
        } else if (firstDigit == '5') {
            System.out.print(cardNumber + " is a Mastercard credit card. ");
        } else if (firstDigit == '3' && secondDigit == '7') {
            System.out.print(cardNumber + " is an American Express credit card. ");
        } else if (firstDigit == '6') {
            System.out.print(cardNumber + " is a Discover credit card. ");
        } else {
            System.out.println(cardNumber + " is an invalid credit card number.");
            return;
        }

        boolean toBeDoubled = false;
        int sum = 0;
        for (int i = cardNumber.length() - 1 ; i >= 0; i--) {
            // to convert character to integer by using ASCII value of 0
            int digit = cardNumber.charAt(i) - '0';
            // digit = 7

            // for the first loop, it is false so this condition will not be executed
            // for second loop, we change it to true, so it will be executed and so on
            if(toBeDoubled){
                digit = digit * 2;

                // to get sum of individual numbers if number is more than one digit
                // example: 10 = 1 + 0 = 1,  also 10-9 = 1
                if (digit > 9){
                    digit = digit - 9;
                }
            }
            // summing all doubled as well as individual numbers
            sum = sum + digit;
            // changing it to true if it was false and vice versa, the aim is to get every second digit
            toBeDoubled = !toBeDoubled;
        }

        if (sum % 10 == 0) {
            System.out.println("It is a valid credit card number.");
        } else {
            System.out.println("It is an invalid credit card number.");
        }
    }
}

