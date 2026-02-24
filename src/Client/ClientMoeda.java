package Client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientMoeda{
    private final String apiKey = System.getenv("apiKey");
    private final HttpClient client = HttpClient.newHttpClient();

    public String BuscarMoeda(String uf) throws IOException, InterruptedException{
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/"+apiKey+"/latest/"+uf))
                .build();

        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
