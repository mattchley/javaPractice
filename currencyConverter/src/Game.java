import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.util.Scanner;

class Game {
        Scanner stringInput = new Scanner(System.in);
        String startingCurrency = " ";
        String startingCurrencyAmount;
        String confirmStartingCurrency;
        String endingCurrency;
        String confirmEndingCurrency;
        String continueWithApp;
        double convertedAmount;
        boolean endingCurrencyConfirmation = false;
        String[] currencyArray = { "AUD", "BGN", "BRL", "CAD", "CHF", "CNY", "CZK", "DKK", "EUR", "GBP",
                        "HKD",
                        "HRK", "HUF", "IDR", "ILS", "INR", "ISK", "JPY", "KRW", "MXN", "MYR", "NZD", "NOK",
                        "PHP", "PLN", "RON",
                        "RUB", "SEK", "SGD", "THB", "TRY", "USD", "ZAR" };
        String currencies = Arrays.toString(currencyArray);
        List<String> currencylist = new ArrayList<String>(Arrays.asList(currencyArray));

        void askQuestion(String stepInProcess) {
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

        boolean isValidInput(String startingCurrency) {
                return Arrays.asList(currencyArray).contains(startingCurrency);
        }

        boolean isValidAmount(String startingCurrencyAmount) {
                if (startingCurrencyAmount.length() < 1)
                        return false;
                if (startingCurrencyAmount.matches("[0-9]+") && !startingCurrencyAmount.matches("[.]+")) {
                        return true;
                } else if (startingCurrencyAmount.matches("[0-9.]+")) {
                        return true;
                }

                return false;

        }

        String addDecimalValue(String startingCurrencyAmount) {

                if (startingCurrencyAmount.matches("[0-9]+") && !startingCurrencyAmount.matches("[.]+")) {
                        return startingCurrencyAmount + ".00";
                } else if (startingCurrencyAmount.matches("[0-9.]+"))
                        return startingCurrencyAmount;

                return startingCurrencyAmount;
        }

        boolean isGoingToNextStep(String confirmStatementString) {
                return !confirmStatementString.equals("y") && !confirmStatementString.equals("Y") ? false
                                : true;
        }

        boolean isStepOneDone() {
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

        boolean isStepTwoDone() {

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

        boolean isfinalStepDone() throws IOException, InterruptedException{
                CallApi test = new CallApi();
                String responseConvertRate;
                try {
                        responseConvertRate =test.res(startingCurrency, endingCurrency);
                        convertedAmount = Double.parseDouble(startingCurrencyAmount) * Double.parseDouble(responseConvertRate);
                        askQuestion("end");
                        continueWithApp = stringInput.nextLine();
                        return !continueWithApp.equals("n") && !continueWithApp.equals("N") ? true
                                        : false;
                } catch (Exception e) {
                        System.err.println(e);
                        return false;
                }
           
        }

        void terminateApplication() {
                stringInput.close();
        }

        void perpetuateFuncs(boolean stepToExecute) {

                do {
                        if (stepToExecute)
                                endingCurrencyConfirmation = true;

                } while (!endingCurrencyConfirmation);

        }

        boolean runCurrencyCoverter() {
                perpetuateFuncs(isStepOneDone());
                perpetuateFuncs(isStepTwoDone());
                try{
                        return isfinalStepDone();
                 } catch (Exception e) {
                        System.err.println(e);
                        return false;
                }

        }
}