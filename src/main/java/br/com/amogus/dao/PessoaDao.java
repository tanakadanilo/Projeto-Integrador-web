package br.com.amogus.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.amogus.entidade.Pessoa;

@Repository
public interface PessoaDao extends JpaRepository<Pessoa, Integer> {

	@Query(nativeQuery = true, value = "select * from pessoa p where lower(p.nome) like lower(:nome)")
	List<Pessoa> completePessoa(@Param("nome") String nome);

	@Query(nativeQuery = true, value = "select * from pessoa p where  (lower(p.nome) like lower(:nome)) and (p.funcionario = true)")
	List<Pessoa> completeFuncionario(@Param("nome") String nome);

	@Query(nativeQuery = true, value = "select * from pessoa p where lower(p.nome) like lower(:nome) and not(p.funcionario) ")
	List<Pessoa> completeCliente(@Param("nome") String nome);

}
