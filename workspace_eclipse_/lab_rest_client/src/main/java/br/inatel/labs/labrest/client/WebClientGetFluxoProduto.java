package br.inatel.labs.labrest.client;

import br.inatel.labs.labrest.client.model.dto.ProdutoDTO;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

public class WebClientGetFluxoProduto {
    private static final String BASE_URL = "http://localhost:8080";

    public static void main(String[] args) {
        WebClient webClient = WebClient.create(BASE_URL);
        Flux<ProdutoDTO> fluxProduto = webClient.get()
                                                .uri("/produto")
                                                .retrieve()
                                                .bodyToFlux(ProdutoDTO.class);

        List<ProdutoDTO> listaProduto = fluxProduto.collectList().block();

        System.out.println("Lista dos Produtos: " + listaProduto);
    }
}
