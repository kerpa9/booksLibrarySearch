package libraryBook.Library.helpers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConsultLibraryAPI {

    public String consultAPI(String url) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        HttpResponse<String> response = null;

        try {

            response = client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode rootNode = objectMapper.readTree(json);
            JsonNode resultsNode = rootNode.get("results");
            // return resultsNode.toString();
            if (resultsNode.isArray() && resultsNode.size() > 0) {
                JsonNode firstResult = resultsNode.get(0); 
                return firstResult.toString(); 
            } else {
                return "{}"; 
            }
        } catch (IOException e) {
            throw new RuntimeException("Error", e);

        }
    }

}
