package br.inatel.labs.labrest.server;

import br.inatel.labs.labrest.server.model.Produto;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProdutoControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void dadoProdutoIdValido_quandoDeleteProdutoPeloId_entaoRespondeComStatusNoContent() {
        Long idValido = 2L;

        webTestClient.delete().uri("/produto/{id}", idValido).exchange().expectStatus().isNoContent();
    }

    @Test
    void dadoProdutoIdInvalido_quandoDeleteProdutoPeloId_entaoRespondeComStatusNotFound() {
        Long idInvalido = 2L;

        webTestClient.delete().uri("/produto/{id}", idInvalido).exchange().expectStatus().isNotFound();
    }

    @Test
    void dadoProdutoExistente_quandoPutProduto_entaoRespondeComStatusNoContent() {
        Produto produtoExistente = new Produto();
        produtoExistente.setId(1L);
        produtoExistente.setDescricao("Furadeira à Bateria");
        produtoExistente.setPreco(new BigDecimal("800.00"));

        webTestClient.put().uri("/produto").bodyValue(produtoExistente).exchange().expectStatus().isNoContent();
    }

    @Test
    void dadoNovoProduto_quandoPostProduto_entaoRespondeComStatusCreatedEProdutoValido() {
        Produto novoProduto = new Produto();
        novoProduto.setDescricao("Tupia de Mesa");
        novoProduto.setPreco(new BigDecimal("9000.00"));

        Produto produtoRespondido = webTestClient.post().uri("/produto").bodyValue(novoProduto).exchange().expectStatus().isCreated().expectBody(Produto.class).returnResult().getResponseBody();

        AssertionsForClassTypes.assertThat(produtoRespondido).isNotNull();
        AssertionsForClassTypes.assertThat(produtoRespondido.getId()).isNotNull();
    }

    @Test
    void dadoProdutoIdInvalido_quandoGetProdutoPeloId_entaoRespondeComStatusNotFound() {
        Long idInvalido = 99L;

        webTestClient.get().uri("/produto/{id}", idInvalido).exchange().expectStatus().isNotFound();
    }

    @Test
    void dadoProdutoIdValido_quandoGetProdutoPeloId_entaoRespondeComProdutoValido() {
        Long produtoIdValido = 1L;

        Produto produtoRespondido = webTestClient.get().uri("/produto/{id}", produtoIdValido).exchange().expectStatus().isOk().expectBody(Produto.class).returnResult().getResponseBody();

        Assertions.assertNotNull(produtoRespondido);
        Assertions.assertEquals(produtoIdValido, produtoRespondido.getId());
    }

    @Test
    void deveListarProdutos() {
        webTestClient.get().uri("/produto").exchange().expectStatus().isOk().expectBody().returnResult();
    }
}
