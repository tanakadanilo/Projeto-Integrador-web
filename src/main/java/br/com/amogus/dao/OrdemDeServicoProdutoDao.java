package br.com.amogus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.amogus.entidade.OrdemDeServicoProduto;

@Repository
public interface OrdemDeServicoProdutoDao extends JpaRepository<OrdemDeServicoProduto, Integer> {

}
