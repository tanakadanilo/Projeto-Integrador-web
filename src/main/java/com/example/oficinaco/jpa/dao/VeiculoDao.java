package com.example.oficinaco.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.oficinaco.jpa.entidade.Modelo;
import com.example.oficinaco.jpa.entidade.Veiculo;

@Repository
public interface VeiculoDao extends JpaRepository<Veiculo, Integer> {

	@Query(nativeQuery = true, value = "select * from veiculo where lower(placa) = lower(:placa)")
	Veiculo consultarPorPlaca(@Param("placa") String placa);

	@Query(nativeQuery = true, value = "select * from modelo m where lower(m.nome) like  lower(:nome)")
	List<Modelo> completeModelo(@Param("nome") String nome);

	@Query(nativeQuery = true, value = "select * from veiculo v join modelo m on modelo_id  = m.id where lower(m.nome) like lower(:nome)")
	List<Veiculo> completeVeiculo();
}
