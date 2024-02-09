import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Currencies {

  String[] currencyArray = {
    "AUD",
    "BGN",
    "BRL",
    "CAD",
    "CHF",
    "CNY",
    "CZK",
    "DKK",
    "EUR",
    "GBP",
    "HKD",
    "HRK",
    "HUF",
    "IDR",
    "ILS",
    "INR",
    "ISK",
    "JPY",
    "KRW",
    "MXN",
    "MYR",
    "NZD",
    "NOK",
    "PHP",
    "PLN",
    "RON",
    "RUB",
    "SEK",
    "SGD",
    "THB",
    "TRY",
    "USD",
    "ZAR",
  };
  String currencies = Arrays.toString(currencyArray);
  List<String> currencylist = new ArrayList<String>(
    Arrays.asList(currencyArray)
  );

  String getCurrencies () {
        return currencies;
  }

  String getModifiedArray() {
    return Arrays.toString(currencylist.toArray());
  }

  boolean isValidInput(String startingCurrency) {
    return Arrays.asList(currencyArray).contains(startingCurrency);
  }

  boolean isValidAmount(String startingCurrencyAmount) {
    if (startingCurrencyAmount.length() < 1) return false;
    if (
      startingCurrencyAmount.matches("[0-9]+") &&
      !startingCurrencyAmount.matches("[.]+")
    ) {
      return true;
    } else if (startingCurrencyAmount.matches("[0-9.]+")) {
      return true;
    }

    return false;
  }

  String addDecimalValue(String startingCurrencyAmount) {
    if (
      startingCurrencyAmount.matches("[0-9]+") &&
      !startingCurrencyAmount.matches("[.]+")
    ) {
      return startingCurrencyAmount + ".00";
    } else if (
      startingCurrencyAmount.matches("[0-9.]+")
    ) return startingCurrencyAmount;

    return startingCurrencyAmount;
  }

  void removeSelectedCurrency(String startingCurrency) {
    currencylist.remove(startingCurrency);
  }
}
