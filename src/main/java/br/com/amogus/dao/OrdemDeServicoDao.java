package br.com.amogus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.amogus.entidade.OrdemDeServico;

@Repository
public interface OrdemDeServicoDao extends JpaRepository<OrdemDeServico, Integer> {

}
