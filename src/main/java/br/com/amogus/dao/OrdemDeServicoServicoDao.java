package br.com.amogus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.amogus.entidade.Municipio;

@Repository
public interface OrdemDeServicoServicoDao extends JpaRepository<Municipio, Integer> {

}
