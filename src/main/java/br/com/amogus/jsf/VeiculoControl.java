package br.com.amogus.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.amogus.dao.VeiculoDao;
import br.com.amogus.entidade.Modelo;
import br.com.amogus.entidade.Veiculo;

@Component
@SessionScoped
public class VeiculoControl {

	@Autowired
	private VeiculoDao veiculoDao;

	@Autowired
	private ModeloControl modeloControl;

	private Veiculo veiculo = new Veiculo();

	private List<Veiculo> veiculos = new ArrayList<>();

	private String nomeMarca;

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

	public List<Veiculo> completeVeiculo(String placa) {
		return veiculoDao.completeVeiculo(placa);
	}

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

}
