package br.inatel.labs.lab_jpa.service;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.inatel.labs.jps.service.RelatorioService;
import br.inatel.labs.lab_jpa.dto.TotalCompradoPorFornecedorDTO;

@SpringBootTest
public class RelatorioServiceTest {
	
	@Autowired
	private RelatorioService service;
	
	@Test
	void test() {
		List<TotalCompradoPorFornecedorDTO> purchaseTotalsBySupplier = service.pesquisarTotalCompradoPorFornecedor();
		
		assertFalse(purchaseTotalsBySupplier.isEmpty());
		






		
		purchaseTotalsBySupplier.forEach(r -> System.out.println(r));
		
		purchaseTotalsBySupplier.forEach(System.out :: println);
	}
}