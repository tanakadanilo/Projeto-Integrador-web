package com.example.oficinaco.jpa.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.oficinaco.jpa.dao.VeiculoDao;
import com.example.oficinaco.jpa.entidade.Modelo;
import com.example.oficinaco.jpa.entidade.Veiculo;

@Component
@SessionScoped
public class VeiculoControl {

	@Autowired
	private VeiculoDao veiculoDao;

	@Autowired
	private ModeloControl modeloControl;

	private Veiculo veiculo = new Veiculo();

	private List<Veiculo> veiculos = new ArrayList<>();

	@PostConstruct
	public void init() {
		listar();
	}

	public void salvar() {
		veiculoDao.save(veiculo);
		veiculo = new Veiculo();
		listar();
	}

	public void listar() {
		veiculos = veiculoDao.findAll();
	}

	public void excluir(Integer id) {
		veiculoDao.deleteById(id);
		listar();
	}

	public VeiculoDao getVeiculoDao() {
		return veiculoDao;
	}

	public void setVeiculoDao(VeiculoDao veiculoDao) {
		this.veiculoDao = veiculoDao;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public List<Modelo> completeModelo(String nome) {
		return modeloControl.completeModelo(nome);
	}
}
