package br.inatel.labs.labrest.client;

import br.inatel.labs.labrest.client.model.dto.ProdutoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class WebClientPutProduto {
    private static final String BASE_URL = "http://localhost:8080";

    public static void main(String[] args) {
        WebClient webClient = WebClient.create(BASE_URL);

        ProdutoDTO produtoExistente = new ProdutoDTO();
        produtoExistente.setId(1L);
        produtoExistente.setDescricao("test");

        try {
            ResponseEntity<Void> responseEntity = webClient.put()
                                                          .uri("/produto/{id}", 1)
                                                          .bodyValue(produtoExistente)
                                                          .retrieve()
                                                          .toBodilessEntity()
                                                          .block();

            System.out.println("O produto foi atualizado");
            System.out.println("Status Code:" + responseEntity.getStatusCode());
        } catch (WebClientResponseException
