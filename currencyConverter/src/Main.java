public class Main {

        public static void main(String[] args) {
                boolean continueApp = true;
                Game application = new Game();
                do {
                        if (!application.runCurrencyCoverter()) {
                                application.terminateApplication();
                                continueApp = false;
                        }
                } while (continueApp);
        }
}
