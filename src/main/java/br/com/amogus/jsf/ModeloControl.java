package br.com.amogus.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.amogus.dao.ModeloDao;
import br.com.amogus.entidade.Modelo;

@Component
@SessionScoped
public class ModeloControl {

	@Autowired
	private ModeloDao modeloDao;

	private Modelo modelo = new Modelo();

	private List<Modelo> modelos = new ArrayList<>();

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
		return modeloDao.completeModelo("%" + nome + "%");
	}

	public List<String> completeMarca(String nome) {
		List<String> marcas = new ArrayList<>();
		if (modelos.isEmpty()) {
			return marcas;
		}
		for (Modelo modelo : modelos) {
			if (modelo.getMarca().toUpperCase().contains(nome.toUpperCase())) {
				marcas.add(modelo.getMarca());
			}
		}
		return marcas;
	}
}
