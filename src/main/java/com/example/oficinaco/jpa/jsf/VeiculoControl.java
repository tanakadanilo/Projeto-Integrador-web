package com.example.oficinaco.jpa.jsf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.example.oficinaco.jpa.dao.ModeloDao;
import com.example.oficinaco.jpa.dao.VeiculoDao;
import com.example.oficinaco.jpa.entidade.Modelo;
import com.example.oficinaco.jpa.entidade.Veiculo;

@Component
@SessionScoped
public class VeiculoControl {

	@Autowired
	VeiculoDao veiculoDao;
	@Autowired
	ModeloDao modeloDao;
	@Autowired
	ModeloControl modeloControl;
	Veiculo veiculo = new Veiculo();
	Integer modeloId;
	List<Veiculo> veiculos = new ArrayList<>();

	@PostConstruct
	public void init() {
		listar();
	}

	public void salvar() {
		if (veiculo.getModelo() == null) {// * modelo não salvo
			System.out.println("ID do modelo: " + modeloId);
			veiculo.setModelo(modeloDao.findById(modeloId).get());
		}
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

	public Integer getModeloId() {
		return modeloId;
	}

	public void setModeloId(Integer modeloId) {
		this.modeloId = modeloId;
	}
public List<Veiculo> completeVeiculo(String placa) {
		return veiculoDao.completeVeiculo(placa);
	}

	public List<Modelo> completeModelo(String nome) {
		List<Modelo> modelos = new ArrayList<>();
		var modelosCompletos = new ModeloControl().getModelos();
		for (Modelo modelo : modelosCompletos) {
			if (modelo.getNome().contains(nome))
				modelos.add(modelo);
		}

		return modelos;
	}

	public void updateModelo(String nomeModelo) {
		String nome = "";
		String marca = "";
		try {
			nome = nomeModelo.substring(0, nomeModelo.indexOf("-")).trim();
			marca = nomeModelo.substring(nomeModelo.indexOf("-")).trim();
			Modelo modelo = modeloControl.buscar(nome, marca);
			this.veiculo.setModelo(modelo);
		} catch (Exception e) {
			System.out.println("modelo: " + nomeModelo);
			System.out.println("nome: " + nome);
			System.out.println("marca: " + marca);
			e.printStackTrace();
		}
	}
}
