package br.inatel.labs.labrest.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class WebClientDeleteProdutoPeloId {
    private static final String BASE_URL = "http://localhost:8080/";

    public static void main(String[] args) {
        WebClient webClient = WebClient.create(BASE_URL);

        try {
            ResponseEntity<Void> responseEntity = webClient.delete()
                                                          .uri("produto/3")
                                                          .retrieve()
                                                          .toEntity(Void.class)
                                                          .block();

            System.out.println("Produto Removido");
            System.out.println("Status Code: " + responseEntity.getStatusCode());
        } catch (WebClientResponseException e) {
            System.err.println("Erro ao remover produto: " + e.getMessage());
            System.err.println("Status Code: " + e.getStatusCode());
        }
    }
}
