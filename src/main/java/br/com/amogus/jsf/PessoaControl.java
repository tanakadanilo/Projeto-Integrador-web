package br.com.amogus.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.amogus.dao.PessoaDao;
import br.com.amogus.entidade.Pessoa;
import br.com.amogus.validation.ValidaPessoa;

@Component
@SessionScoped
public class PessoaControl {

	@Autowired
	private PessoaDao PessoaDao;
	private Pessoa Pessoa = new Pessoa();
	private List<Pessoa> Pessoas = new ArrayList<>();

	@PostConstruct
	public void init() {
		listar();
	}

	public void salvar() {
		if (ValidaPessoa.validaCPF(Pessoa.getCpf()) && ValidaPessoa.validaTelefone(Pessoa.getTelefone())) {
			PessoaDao.save(Pessoa);
		}
		Pessoa = new Pessoa();
		listar();
	}

	public void listar() {
		Pessoas = PessoaDao.findAll();
	}

	public void excluir(Integer id) {
		PessoaDao.deleteById(id);
		listar();
	}

	public Pessoa getPessoa() {
		return Pessoa;
	}

	public void setPessoa(Pessoa Pessoa) {
		this.Pessoa = Pessoa;
	}

	public PessoaDao getPessoaDao() {
		return PessoaDao;
	}

	public void setPessoaDao(PessoaDao pessoaDao) {
		PessoaDao = pessoaDao;
	}

	public List<Pessoa> getPessoas() {
		return Pessoas;
	}

	public void setPessoas(List<Pessoa> Pessoas) {
		this.Pessoas = Pessoas;
	}

	public List<Pessoa> completePessoa(String nome) {
		return PessoaDao.completePessoa("%" + nome + "%");
	}

	public List<Pessoa> completeCliente(String nome) {
		var lista = PessoaDao.completePessoa("%" + nome + "%");
		return lista.stream().filter(p -> !p.isFuncionario()).toList();
	}

	public List<Pessoa> completeFuncionario(String nome) {
		var lista = PessoaDao.completePessoa("%" + nome + "%");
		return lista.stream().filter(p -> p.isFuncionario()).toList();
	}

}
