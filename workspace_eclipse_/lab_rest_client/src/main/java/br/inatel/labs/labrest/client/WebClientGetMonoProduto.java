package br.inatel.labs.labrest.client;

import br.inatel.labs.labrest.client.model.dto.ProdutoDTO;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

public class WebClientGetMonoProduto {
    private static final String BASE_URL = "http://localhost:8080";

    public static void main(String[] args) {
        WebClient webClient = WebClient.create(BASE_URL);

        Mono<ProdutoDTO> monoProduto = webClient.get()
                                                .uri("/produto/{id}", 1)
                                                .retrieve()
                                                .bodyToMono(ProdutoDTO.class);

        try {
            ProdutoDTO produto = monoProduto.block();

            System.out.println("Produto encontrado:");
            System.out.println(produto);
        } catch (WebClientResponseException e) {
            System.err.println("Erro ao buscar produto. Status Code: " + e.getStatusCode());
            System.err.println("Mensagem: " + e.getMessage());
        }
    }
}
