import java.net.http.HttpResponse;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

class CallApi {
        String apiKey = "?apikey=fca_live_M3gDuHzOzkNIu8cuzkPwtifj2DmYJOXCazyOxhRc";

        String convertJson(String response, String endingCurency) {
                int findCurrencyIndex = response.indexOf(endingCurency);
                String findConversionString = response.substring(findCurrencyIndex + 5, response.length() - 3);
                return findConversionString;
        }

        String res(String startingCurrency, String endingCurency) throws IOException, InterruptedException {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create("https://api.freecurrencyapi.com/v1/latest" + apiKey + "&currencies="
                                                + endingCurency + "&base_currency=" + startingCurrency))
                                .build();

                HttpResponse<String> response = client.send(request,
                                HttpResponse.BodyHandlers.ofString());

                return convertJson(response.body(), endingCurency);
        }
}