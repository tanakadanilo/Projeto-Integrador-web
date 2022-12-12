package br.com.amogus.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.amogus.entidade.Servico;

@Repository
public interface ServicoDao extends JpaRepository<Servico, Integer>{
	
	@Query(nativeQuery = true, value = "select * from servico s where lower(s.nome) like lower(:nome)")
	List<Servico> listarPorNome(@Param("nome") String nome);

}
