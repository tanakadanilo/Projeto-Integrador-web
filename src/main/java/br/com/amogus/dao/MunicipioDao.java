package br.com.amogus.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.amogus.entidade.Municipio;

@Repository
public interface MunicipioDao extends JpaRepository<Municipio, Integer> {

	@Query(nativeQuery = true, value = "select * from municipio m where upper(m.nome) like upper(:nome)")
	public List<Municipio> completeMunicipio(@Param("nome") String nome);

}
