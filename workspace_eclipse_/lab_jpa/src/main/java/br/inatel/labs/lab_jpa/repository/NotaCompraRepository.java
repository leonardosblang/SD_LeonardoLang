package br.inatel.labs.lab_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.inatel.labs.lab_jpa.entity.NotaCompra;

@Repository
public interface NotaCompraRepository extends JpaRepository<NotaCompra, Long>{

}
