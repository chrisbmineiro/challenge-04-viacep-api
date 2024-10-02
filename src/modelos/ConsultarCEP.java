package modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarCEP {
    public Endereco buscarEnderecoPorCEP(String cep) {
        String endereco = "https://viacep.com.br/ws/" + cep + "/json/";

        // Cria o cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Cria a requisição
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        try {
            // Captura a resposta
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Retorna o corpo da resposta (JSON)
            return new Gson().fromJson(response.body(), Endereco.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Ocorreu um erro: " + e);
        }
    }
}
