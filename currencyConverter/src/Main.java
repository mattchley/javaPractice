public class Main {

  // TODO decimals input that is more than .00
  // TODO decimal round up for conversion rate
  // TODO kill switch when Q/q is placed in input
  // TODO auto uppercase with input?

  public static void main(String[] args) {
    Game application = new Game();
    try {
      application.startStep();
    } catch (Exception e) {
      System.err.println(e);
    }
  }
}
