public class Questions {

  Currencies currencyChoices = new Currencies();
  String currencies = currencyChoices.getCurrencies();

  void greetings() {
    System.out.println(
      "Greetings! This is a basic currency converter. It uses the freecurrencyapi. Currently it can convert the 33 currencies: \nChoose the starting currency: " +
      currencies
    );
  }

  void askQuestion() {
    System.out.println("Choose the amount exp: 1.00");
  }

  void askQuestion(String arg) {
    System.out.println("You entered " + arg + ", is this correct? Y/N");
  }

  void askQuestion(String startingCurrencyAmount, String startingCurrency) {
    System.out.println(
      "You entered " +
      startingCurrencyAmount +
      " " +
      startingCurrency +
      ", is this correct? Y/N"
    );
  }

  void askQuestion(
    String startingCurrencyAmount,
    String startingCurrency,
    String endingCurrency,
    double convertedAmount
  ) {
    System.out.println(
      startingCurrencyAmount +
      " " +
      startingCurrency +
      " converted to " +
      endingCurrency +
      " is " +
      convertedAmount +
      "\n" +
      "Would you like to try again? Y/N"
    );
  }

  void chooseFinalCurrency(String currencyListAsArray) {
    System.out.println("Choose the ending currency: " + currencyListAsArray);
  }
}
