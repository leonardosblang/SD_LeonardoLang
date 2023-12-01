package br.inatel.labs.labrest.client;

import br.inatel.labs.labrest.client.model.dto.ProdutoDTO;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;

public class WebClientPostProduto {
    private static final String BASE_URL = "http://localhost:8080";

    public static void main(String[] args) {
        ProdutoDTO novoProduto = new ProdutoDTO();
        novoProduto.setDescricao("Martelo");
        novoProduto.setPreco(new BigDecimal("25.00"));

        WebClient webClient = WebClient.create(BASE_URL);

        ProdutoDTO produtoCriado = webClient.post()
                                            .uri("/produto")
                                            .bodyValue(novoProduto)
                                            .retrieve()
                                            .bodyToMono(ProdutoDTO.class)
                                            .block();

        System.out.println("Produto criado:");
        System.out.println(produtoCriado);
    }
}
