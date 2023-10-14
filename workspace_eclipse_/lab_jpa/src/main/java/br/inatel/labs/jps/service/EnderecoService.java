package br.inatel.labs.jps.service;

import org.springframework.stereotype.Service;

import br.inatel.labs.lab_jpa.entity.Endereco;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EnderecoService {
	
	@PersistenceContext
	private EntityManager em;
	
	public Endereco salvar(Endereco e) {
		return em.merge(e);
	}
}
