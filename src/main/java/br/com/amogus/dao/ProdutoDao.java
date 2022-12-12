package br.com.amogus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.amogus.entidade.Produto;

@Repository
public interface ProdutoDao extends JpaRepository<Produto, Integer>{

}
