package com.example.oficinaco.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.oficinaco.jpa.entidade.Modelo;

@Repository
public interface ModeloDao extends JpaRepository<Modelo, Integer> {

	@Query(nativeQuery = true, value = "select * from modelo m where lower(m.nome) like lower(:nome)")
	List<Modelo> completeModelo(@Param("nome") String nome);

}
