import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
        // TODO add checks on scanner in case they don't use numbers in amount
        static Scanner stringInput = new Scanner(System.in);
        static String startingCurrency = " ";
        static String startingCurrencyAmount;
        static String confirmStartingCurrency;
        static String endingCurrency;
        static String confirmEndingCurrency;
        static String continueWithApp;
        static double convertedAmount;
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
                                                startingCurrencyAmount + " " + startingCurrency + " converted to " +
                                                                endingCurrency + " is "
                                                                + convertedAmount + "\n"
                                                                + "Would you like to try again? Y/N");
                                break;

                }
        }

        static boolean isValidInput(String startingCurrency) {
                return Arrays.asList(currencyArray).contains(startingCurrency);
        }

        static boolean isValidAmount(String startingCurrencyAmount) {
                if (startingCurrencyAmount.length() < 1)
                        return false;
                if (startingCurrencyAmount.matches("[0-9]+") && !startingCurrencyAmount.matches("[.]+")) {
                        return true;
                } else if (startingCurrencyAmount.matches("[0-9.]+")) {
                        return true;
                }

                return false;

        }

        static String addDecimalValue(String startingCurrencyAmount) {

                if (startingCurrencyAmount.matches("[0-9]+") && !startingCurrencyAmount.matches("[.]+")) {
                        return startingCurrencyAmount + ".00";
                } else if (startingCurrencyAmount.matches("[0-9.]+"))
                        return startingCurrencyAmount;

                return startingCurrencyAmount;
        }

        static boolean isGoingToNextStep(String confirmStatementString) {
                return !confirmStatementString.equals("y") && !confirmStatementString.equals("Y") ? false
                                : true;
        }

        static boolean isStepOneDone() {
                do {
                        askQuestion("intro");
                        startingCurrency = stringInput.nextLine();
                } while (!isValidInput(startingCurrency));

                do {
                        askQuestion("amount");
                        startingCurrencyAmount = stringInput.nextLine();
                } while (!isValidAmount(startingCurrencyAmount));
                startingCurrencyAmount = addDecimalValue(startingCurrencyAmount);
                askQuestion("confirm first choices");
                confirmStartingCurrency = stringInput.nextLine();
                if (isGoingToNextStep(confirmStartingCurrency)) {
                        return true;
                } else {
                        isStepOneDone();
                }
                return false;

        }

        static boolean isStepTwoDone() {

                currencylist.remove(startingCurrency);
                do {
                        askQuestion("choose ending currency");
                        endingCurrency = stringInput.nextLine();
                } while (!isValidInput(endingCurrency));

                askQuestion("confirm second choices");
                confirmEndingCurrency = stringInput.nextLine();
                if (isGoingToNextStep(confirmEndingCurrency)) {
                        return true;
                } else {
                        isStepTwoDone();
                }
                return false;

        }

        static boolean isfinalStepDone() {
                convertedAmount = Double.parseDouble(startingCurrencyAmount) * 10.61;
                askQuestion("end");
                continueWithApp = stringInput.nextLine();
                return !continueWithApp.equals("n") && !continueWithApp.equals("N") ? true
                                : false;
        }

        static void terminateApplication() {
                stringInput.close();
        }

        static void perpetuateFuncs(boolean stepToExecute) {

                do {
                        if (stepToExecute)
                                endingCurrencyConfirmation = true;

                } while (!endingCurrencyConfirmation);

        }

        static boolean runCurrencyCoverter() {
                perpetuateFuncs(isStepOneDone());
                perpetuateFuncs(isStepTwoDone());
                return isfinalStepDone();
        }

        public static void main(String[] args) {
                boolean continueApp = true;
                do {
                        if (!runCurrencyCoverter()) {
                                terminateApplication();
                                continueApp = false;
                        }
                } while (continueApp);
        }
}
