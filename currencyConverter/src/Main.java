import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
        // TODO abstract the logic to allow for easy reference when getting negative
        // path
        public static void main(String[] args) {
                // upon start up, text explaining the app to the user
                // list the types to convert
                Scanner stringInput = new Scanner(System.in);
                Scanner doubleInput = new Scanner(System.in);
                String startingCurrency;
                Double startingCurrencyAmount;
                String confirmStartingCurrency;
                String endingCurrency;
                String confirmEndingCurrency;
                String[] currencyArray = { "AUD", "BGN", "BRL", "CAD", "CHF", "CNY", "CZK", "DKK", "EUR", "GBP",
                                "HKD",
                                "HRK", "HUF", "IDR", "ILS", "INR", "ISK", "JPY", "KRW", "MXN", "MYR", "NZD", "NOK",
                                "PHP", "PLN", "RON",
                                "RUB", "SEK", "SGD", "THB", "TRY", "USD", "ZAR" };
                String currencies = Arrays.toString(currencyArray);
                List<String> currencylist = new ArrayList<String>(Arrays.asList(currencyArray));

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
                if (confirmStartingCurrency.equals("y") || confirmStartingCurrency.equals("Y")) {
                        currencylist.remove(startingCurrency);
                        System.out.println(
                                        "Choose the ending currency: " + Arrays.toString(currencylist.toArray()));
                        endingCurrency = stringInput.nextLine();
                        System.out.println("You entered " + endingCurrency + ", is this correct? Y/N");
                        confirmEndingCurrency = stringInput.nextLine();
                        if (confirmEndingCurrency.equals("y") || confirmEndingCurrency.equals("Y")) {
                                // TODO: Code to grab conversion to
                                double convertedAmount = startingCurrencyAmount * 10.61;
                                System.out.println(
                                                startingCurrencyAmount + " " + startingCurrency + "converted to " +
                                                                endingCurrency + " is "
                                                                + convertedAmount);
                                stringInput.close();
                                doubleInput.close();

                        } else {
                                // code to deal with negative path
                        }
                } else {
                        // code to deal with negative path
                }

        }
}
