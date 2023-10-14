package br.inatel.labs.lab_jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.inatel.labs.lab_jpa.dto.TotalCompradoPorFornecedorDTO;
import br.inatel.labs.lab_jpa.entity.NotaCompraItem;

@Repository
public interface RelatorioRepository extends JpaRepository<NotaCompraItem, Long>{
	
	@Query(""" 
			select new br.inatel.labs.lab_jpa.dto.TotalCompraPorFornecedorDTO
				( f.razaoSocial
				, sum(i.quantidade * i.valorCompraProduto)	
				)
				from NotaCompraItem i
					join i.notaCompra n
					join n.fornecedor f
				group by f.razaoSocial
			""")
	public List<TotalCompradoPorFornecedorDTO> pesquisarTotalCompradoPorFornecedor();
}
