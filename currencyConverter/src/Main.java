import java.io.IOException;

public class Main {

        public static void main(String[] args) throws IOException, InterruptedException {
                CallApi test = new CallApi();

                try {
                        test.res();

                } catch (Exception e) {
                        System.err.println(e);
                }
                // boolean continueApp = true;
                // Game application = new Game();
                // do {
                //         if (!application.runCurrencyCoverter()) {
                //                 application.terminateApplication();
                //                 continueApp = false;
                //         }
                // } while (continueApp);

        }

}
