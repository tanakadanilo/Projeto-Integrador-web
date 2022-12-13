package br.com.amogus.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.amogus.entidade.Produto;

@Repository
public interface ProdutoDao extends JpaRepository<Produto, Integer> {

	@Query(nativeQuery = true, value = "select * from produto p where p.nome like (:nome)")
	List<Produto> completeProduto(@Param("nome") String nome);
}
