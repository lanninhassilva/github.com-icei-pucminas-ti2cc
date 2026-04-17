import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SentimentoAzure {

    public static void main(String[] args) throws Exception {

        String endpoint = "https://language-lanninha.cognitiveservices.azure.com";
        String key = "SUA_CHAVE_AQUI";

        String texto = """
        {
          "documents": [
            {
              "id": "1",
              "language": "pt",
              "text": "Eu gostei muito desse produto"
            }
          ]
        }
        """;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint + "/text/analytics/v3.1/sentiment"))
                .header("Ocp-Apim-Subscription-Key", key)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(texto))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());
    }
}