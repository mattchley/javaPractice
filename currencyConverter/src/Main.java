import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // upon start up, text explaining the app to the user
        // list the types to convert
        System.out.println(
                "Greetings! This is a basic currency converter project. It uses the freecurrencyapi. Currently it can convert the following currencies to any of these 33 currencies: AUD, BGN, BRL, CAD, CHF, CNY, CZK, DKK, EUR, GBP, HKD, HRK, HUF, IDR, ILS, INR, ISK, JPY, KRW, MXN, MYR, NZD,  NOK, PHP, PLN, RON, RUB, SEK, SGD, THB, TRY, USD, ZAR");

        Scanner input = new Scanner(System.in);
        System.out.println(
                "Choose the starting currency: AUD, BGN, BRL, CAD, CHF, CNY, CZK, DKK, EUR, GBP, HKD, HRK, HUF, IDR, ILS, INR, ISK, JPY, KRW, MXN, MYR, NZD,  NOK, PHP, PLN, RON, RUB, SEK, SGD, THB, TRY, USD, ZAR");
        String startingCurrency = input.nextLine();
        double startingCurrencyAmount = input.nextDouble();
        System.out.println("You entered " + startingCurrencyAmount + startingCurrency
                + ", is this correct?");
        Scanner input2 = new Scanner(System.in);
        String confirmStartingCurrency = input2.nextLine();
        if (confirmStartingCurrency.equals("yes")) {
            Scanner input3 = new Scanner(System.in);
            System.out.println(
                    "Choose the ending currency: AUD, BGN, BRL, CAD, CHF, CNY, CZK, DKK, EUR, GBP, HKD, HRK, HUF, IDR, ILS, INR, ISK, JPY, KRW, MXN, MYR, NZD, NOK, PHP, PLN, RON, RUB, SEK, SGD, THB, TRY, USD, ZAR");
            String endingCurrency = input3.nextLine();
            System.out.println("You entered " + endingCurrency + ", is this correct?");
            Scanner input4 = new Scanner(System.in);
            String confirmEndingCurrency = input4.nextLine();
            if (confirmEndingCurrency.equals("yes") || confirmEndingCurrency.equals("y")) {
                // TODO: Code to grab conversion to
                double convertedAmount = startingCurrencyAmount * 10.61;
                System.out.println(startingCurrencyAmount + startingCurrency + "converted to" + endingCurrency + "is "
                        + convertedAmount);
            } else {
                // code to deal with negative path
            }
        } else {
            // code to deal with negative path
        }

    }
}
