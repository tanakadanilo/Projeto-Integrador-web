package com.example.oficinaco.jpa.jsf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.oficinaco.jpa.dao.ModeloDao;
import com.example.oficinaco.jpa.entidade.Modelo;

@Component
@SessionScoped
public class ModeloControl {

	@Autowired
	private ModeloDao modeloDao;

	private Modelo modelo = new Modelo();

	private List<Modelo> modelos;

	@PostConstruct
	public void init() {
		listar();
	}

	public void salvar() {
		modeloDao.save(modelo);
		modelo = new Modelo();
		listar();
	}

	public void listar() {
		modelos = modeloDao.findAll();
		System.out.println(modeloDao.findAll());
		System.out.println(getModelos());
	}

	public Modelo buscar(String nome) {
		for (Modelo modelo : modelos) {// * procurando modelo com este nome
			if (modelo.getNome().equalsIgnoreCase(nome)) {
				return modelo;
			}
		}
		return null;// * não encontrado
	}

	public void excluir(Integer id) {
		modeloDao.deleteById(id);
		listar();
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public List<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}

	public List<Modelo> completeModelo(String nome) {
		List<Modelo> modelos = new ArrayList<>();
		for (Modelo modelo : this.modelos) {
			if (modelo.getNome().toUpperCase().contains(nome.toUpperCase()))
				modelos.add(modelo);
		}

		return modelos;
	}

}
