import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
        // TODO add checks on scanner in case they don't use a currency in the Array or
        // No numbers in amount
        static Scanner stringInput = new Scanner(System.in);
        static Scanner doubleInput = new Scanner(System.in);
        static String startingCurrency = " ";
        static double startingCurrencyAmount;
        static String confirmStartingCurrency;
        static String endingCurrency;
        static String confirmEndingCurrency;
        static double convertedAmount;
        static boolean startingAmountConfirmation = false;
        static boolean endingCurrencyConfirmation = false;
        static String[] currencyArray = { "AUD", "BGN", "BRL", "CAD", "CHF", "CNY", "CZK", "DKK", "EUR", "GBP",
                        "HKD",
                        "HRK", "HUF", "IDR", "ILS", "INR", "ISK", "JPY", "KRW", "MXN", "MYR", "NZD", "NOK",
                        "PHP", "PLN", "RON",
                        "RUB", "SEK", "SGD", "THB", "TRY", "USD", "ZAR" };
        static String currencies = Arrays.toString(currencyArray);
        static List<String> currencylist = new ArrayList<String>(Arrays.asList(currencyArray));

        static void askQuestion(String stepInProcess) {
                switch (stepInProcess) {
                        case "intro":

                                System.out.println(
                                                "Greetings! This is a basic currency converter. It uses the freecurrencyapi. Currently it can convert the 33 currencies: \nChoose the starting currency: "
                                                                + currencies);

                                break;
                        case "amount":
                                System.out.println(
                                                "Choose the amount exp: 1.00");

                                break;
                        case "confirm first choices":
                                System.out.println("You entered " + startingCurrencyAmount + " " + startingCurrency
                                                + ", is this correct? Y/N");

                                break;
                        case "choose ending currency":
                                System.out.println(
                                                "Choose the ending currency: "
                                                                + Arrays.toString(currencylist.toArray()));
                                break;
                        case "confirm second choices":
                                System.out.println("You entered " + endingCurrency + ", is this correct? Y/N");
                                break;
                        case "end":
                                System.out.println(
                                                startingCurrencyAmount + " " + startingCurrency + "converted to " +
                                                                endingCurrency + " is "
                                                                + convertedAmount);
                                break;

                }
        }

        static boolean isValidInput(String startingCurrency) {
                return Arrays.asList(currencyArray).contains(startingCurrency);
        }

        static boolean isStepOneDone() {
                do {
                        askQuestion("intro");
                        startingCurrency = stringInput.nextLine();
                } while (!isValidInput(startingCurrency));

                askQuestion("amount");
                startingCurrencyAmount = doubleInput.nextDouble();
                askQuestion("confirm first choices");
                confirmStartingCurrency = stringInput.nextLine();

                return !confirmStartingCurrency.equals("y") && !confirmStartingCurrency.equals("Y") ? false
                                : true;

        }

        static boolean isStepTwoDone() {

                currencylist.remove(startingCurrency);
                do {
                        askQuestion("choose ending currency");
                        endingCurrency = stringInput.nextLine();
                } while (!isValidInput(endingCurrency));

                askQuestion("confirm second choices");
                confirmEndingCurrency = stringInput.nextLine();

                return !confirmEndingCurrency.equals("y") && !confirmEndingCurrency.equals("Y") ? false : true;

        }

        static void finalStep() {
                convertedAmount = startingCurrencyAmount * 10.61;
                askQuestion("end");
                stringInput.close();
                doubleInput.close();
        }

        static void intermediateStep(boolean stepToExecute) {

                do {
                        if (stepToExecute)
                                endingCurrencyConfirmation = true;

                } while (!endingCurrencyConfirmation);

        }

        static void runCurrencyCoverter() {
                intermediateStep(isStepOneDone());
                intermediateStep(isStepTwoDone());
                finalStep();
        }

        public static void main(String[] args) {
                runCurrencyCoverter();
        }
}
