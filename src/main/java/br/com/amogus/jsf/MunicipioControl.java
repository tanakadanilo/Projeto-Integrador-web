package br.com.amogus.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.amogus.dao.MunicipioDao;
import br.com.amogus.entidade.Municipio;

@Component
@SessionScoped
public class MunicipioControl {

	@Autowired
	private MunicipioDao municipioDao;

	private Municipio municipio = new Municipio();

	private List<Municipio> Municipios = new ArrayList<>();

	@PostConstruct
	public void init() {
		listar();
	}

	public void salvar() {
		municipioDao.save(municipio);
		municipio = new Municipio();
		listar();
	}

	public void listar() {
		Municipios = municipioDao.findAll();
	}

	public void excluir(Integer id) {
		municipioDao.deleteById(id);
		listar();
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio Municipio) {
		this.municipio = Municipio;
	}

	public List<Municipio> getMunicipios() {
		return Municipios;
	}

	public void setMunicipios(List<Municipio> Municipios) {
		this.Municipios = Municipios;
	}

}
