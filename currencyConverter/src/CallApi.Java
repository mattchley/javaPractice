import java.net.http.HttpResponse;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

class CallApi {
        void res() throws IOException, InterruptedException {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create("http://webcode.me"))
                                .build();

                HttpResponse<String> response = client.send(request,
                                HttpResponse.BodyHandlers.ofString());

                System.out.println(response.body());
        }

        void send(String Param) throws IOException, InterruptedException {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create("https://httpbin.org/post"))
                                .POST(HttpRequest.BodyPublishers.ofString(Param))
                                .build();

                HttpResponse<String> response = client.send(request,
                                HttpResponse.BodyHandlers.ofString());

                System.out.println(response.body());
        }
}