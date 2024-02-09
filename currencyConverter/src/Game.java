import java.io.IOException;
import java.util.Scanner;

public class Game {

  Scanner stringInput = new Scanner(System.in);
  Questions questions = new Questions();
  Currencies currencyChoices = new Currencies();
  String startingCurrency;
  String startingCurrencyAmount;
  String confirmStartingCurrency;
  String endingCurrency;
  String confirmEndingCurrency;
  String continueWithApp;
  double convertedAmount;
  boolean isGoingToNextStep;

  void startGrettings() {
    do {
      questions.greetings();
      startingCurrency = stringInput.nextLine();
    } while (!currencyChoices.isValidInput(startingCurrency));
  }

  void requestAmount() {
    do {
      questions.askQuestion();
      startingCurrencyAmount = stringInput.nextLine();
    } while (!currencyChoices.isValidAmount(startingCurrencyAmount));
  }

  void confirmChoices() {
    startingCurrencyAmount =
      currencyChoices.addDecimalValue(startingCurrencyAmount);
    questions.askQuestion(startingCurrencyAmount, startingCurrency);
    confirmStartingCurrency = stringInput.nextLine();
  }

  boolean confrimChoiceIsYes(String confirmStatementString) {
    return (
        !confirmStatementString.equals("y") &&
        !confirmStatementString.equals("Y")
      )
      ? false
      : true;
  }

  void terminateApplication() {
    stringInput.close();
  }

  void startStep() throws IOException, InterruptedException {
    startGrettings();
    requestAmount();
    confirmChoices();
    isGoingToNextStep = confrimChoiceIsYes(confirmStartingCurrency);
    if (isGoingToNextStep) {
      try {
        stepTwo();
      } catch (Exception e) {
        startStep();
        System.err.println(e);
      }
    } else {
      startStep();
    }
  }

  void stepTwo() throws IOException, InterruptedException {
    currencyChoices.removeSelectedCurrency(startingCurrency);
    currencyChoices.getModifiedArray();

    do {
      questions.chooseFinalCurrency(currencyChoices.getModifiedArray());
      endingCurrency = stringInput.nextLine();
    } while (!currencyChoices.isValidInput(endingCurrency));

    questions.askQuestion(endingCurrency);
    confirmEndingCurrency = stringInput.nextLine();
    if (confrimChoiceIsYes(confirmEndingCurrency)) {
      try {
        isfinalStepDone();
      } catch (Exception e) {
        stepTwo();
        System.err.println(e);
      }
    } else {
      stepTwo();
    }
  }

  void isfinalStepDone() throws IOException, InterruptedException {
    CallApi test = new CallApi();
    String responseConvertRate;
    try {
      responseConvertRate = test.res(startingCurrency, endingCurrency);
      convertedAmount =
        Double.parseDouble(startingCurrencyAmount) *
        Double.parseDouble(responseConvertRate);
      questions.askQuestion(
        startingCurrencyAmount,
        startingCurrency,
        endingCurrency,
        convertedAmount
      );
      continueWithApp = stringInput.nextLine();
      if (
        continueWithApp.equals("n") && continueWithApp.equals("N")
      ) terminateApplication();
      startStep();
    } catch (Exception e) {
      System.err.println(e);
    }
  }

  void runCurrencyCoverter() {
    try {
      startStep();
    } catch (Exception e) {
      System.err.println(e);
    }
  }
}
