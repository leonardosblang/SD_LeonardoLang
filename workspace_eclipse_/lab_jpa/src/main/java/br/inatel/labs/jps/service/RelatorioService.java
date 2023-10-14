package br.inatel.labs.jps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.inatel.labs.lab_jpa.dto.TotalCompradoPorFornecedorDTO;
import br.inatel.labs.lab_jpa.repository.RelatorioRepository;

@Service
public class RelatorioService {
	
	@Autowired
	private RelatorioRepository repository;
	
	public List<TotalCompradoPorFornecedorDTO> pesquisarTotalCompradoPorFornecedor() {
		return repository.pesquisarTotalCompradoPorFornecedor();
	}


}
