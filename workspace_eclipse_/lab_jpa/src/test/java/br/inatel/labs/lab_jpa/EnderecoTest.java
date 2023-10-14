package br.inatel.labs.lab_jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.inatel.labs.jps.service.EnderecoService;
import br.inatel.labs.lab_jpa.entity.Endereco;

@SpringBootTest
public class EnderecoTest {
	
	@Autowired
	private EnderecoService service;
	
	@Test
	public void testarUUIDGeradoPeloJPAListener() {
		
		Endereco addressereco = new Endereco();
		addressereco.setRua("Av. Joao de Camargo");
		addressereco.setCidade("Santa Rita");
		addressereco.setNumero("510");
		addressereco.setUf("MG");
		
		service.salvar(addressereco);
		
		System.out.println(addressereco);
	}
}