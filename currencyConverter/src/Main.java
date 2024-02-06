import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // upon start up, text explaining the app to the user
        // list the types to convert
        Scanner input = new Scanner(System.in);
        String startingCurrency;
        String startingCurrencyAmount;
        String confirmStartingCurrency;
        String endingCurrency;
        String confirmEndingCurrency;

        System.out.println(
                "Greetings! This is a basic currency converter project. It uses the freecurrencyapi. Currently it can convert the following currencies to any of these 33 currencies: AUD, BGN, BRL, CAD, CHF, CNY, CZK, DKK, EUR, GBP, HKD, HRK, HUF, IDR, ILS, INR, ISK, JPY, KRW, MXN, MYR, NZD,  NOK, PHP, PLN, RON, RUB, SEK, SGD, THB, TRY, USD, ZAR");

        System.out.println(
                "Choose the starting currency: AUD, BGN, BRL, CAD, CHF, CNY, CZK, DKK, EUR, GBP, HKD, HRK, HUF, IDR, ILS, INR, ISK, JPY, KRW, MXN, MYR, NZD,  NOK, PHP, PLN, RON, RUB, SEK, SGD, THB, TRY, USD, ZAR");
        startingCurrency = input.nextLine();
        System.out.println(
                "Choose the amount exp: 1.00");
        startingCurrencyAmount = input.nextLine();
        System.out.println("You entered " + startingCurrencyAmount + " " + startingCurrency
                + ", is this correct?");
        confirmStartingCurrency = input.nextLine();
        if (confirmStartingCurrency.equals("yes")) {
            System.out.println(
                    "Choose the ending currency: AUD, BGN, BRL, CAD, CHF, CNY, CZK, DKK, EUR,GBP, HKD, HRK, HUF, IDR, ILS, INR, ISK, JPY, KRW, MXN, MYR, NZD, NOK, PHP,PLN, RON, RUB, SEK, SGD, THB, TRY, USD, ZAR");
            endingCurrency = input.nextLine();
            System.out.println("You entered " + endingCurrency + ", is this correct?");
            confirmEndingCurrency = input.nextLine();
            if (confirmEndingCurrency.equals("yes") || confirmEndingCurrency.equals("y")) {
                // TODO: Code to grab conversion to
                double convertedAmount = Double.parseDouble(startingCurrencyAmount) * 10.61;
                System.out.println(
                        startingCurrencyAmount + " " + startingCurrency + "converted to " +
                                endingCurrency + " is "
                                + convertedAmount);
                input.close();

            } else {
                // code to deal with negative path
            }
        } else {
            // code to deal with negative path
        }

    }
}
