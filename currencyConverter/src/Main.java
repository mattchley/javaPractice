import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

        // upon start up, text explaining the app to the user
        // list the types to convert
        static Scanner stringInput = new Scanner(System.in);
        static Scanner doubleInput = new Scanner(System.in);
        static String startingCurrency;
        static Double startingCurrencyAmount;
        static String confirmStartingCurrency;
        static String endingCurrency;
        static String confirmEndingCurrency;
        static String[] currencyArray = { "AUD", "BGN", "BRL", "CAD", "CHF", "CNY", "CZK", "DKK", "EUR", "GBP",
                        "HKD",
                        "HRK", "HUF", "IDR", "ILS", "INR", "ISK", "JPY", "KRW", "MXN", "MYR", "NZD", "NOK",
                        "PHP", "PLN", "RON",
                        "RUB", "SEK", "SGD", "THB", "TRY", "USD", "ZAR" };
        static String currencies = Arrays.toString(currencyArray);
        static List<String> currencylist = new ArrayList<String>(Arrays.asList(currencyArray));

        static String stepOne() {

                System.out.println(
                                "Greetings! This is a basic currency converter. It uses the freecurrencyapi. Currently it can convert the 33 currencies: \nChoose the starting currency: "
                                                + currencies);

                startingCurrency = stringInput.nextLine();
                System.out.println(
                                "Choose the amount exp: 1.00");
                startingCurrencyAmount = doubleInput.nextDouble();
                System.out.println("You entered " + startingCurrencyAmount + " " + startingCurrency
                                + ", is this correct? Y/N");
                confirmStartingCurrency = stringInput.nextLine();
                return confirmStartingCurrency;
        }

        static String stepTwo() {

                currencylist.remove(startingCurrency);
                System.out.println(
                                "Choose the ending currency: " + Arrays.toString(currencylist.toArray()));
                endingCurrency = stringInput.nextLine();
                System.out.println("You entered " + endingCurrency + ", is this correct? Y/N");
                confirmEndingCurrency = stringInput.nextLine();
                return confirmEndingCurrency;
        }

        static void finalStep() {
                double convertedAmount = startingCurrencyAmount * 10.61;
                System.out.println(
                                startingCurrencyAmount + " " + startingCurrency + "converted to " +
                                                endingCurrency + " is "
                                                + convertedAmount);
                stringInput.close();
                doubleInput.close();
        }

        public static void main(String[] args) {
                String startingAmountConfirmation;
                String endingCurrencyConfirmation;
                startingAmountConfirmation = stepOne();
                if (startingAmountConfirmation.equals("y") || startingAmountConfirmation.equals("Y")) {
                        endingCurrencyConfirmation = stepTwo();
                        if (endingCurrencyConfirmation.equals("y") || endingCurrencyConfirmation.equals("Y")) {
                                finalStep();
                        } else {
                                // code to deal with negative path
                        }
                } else {
                        // code to deal with negative path

                }

        }
}
