package br.com.amogus.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.amogus.dao.ProdutoDao;
import br.com.amogus.entidade.Produto;

@Component
@SessionScoped
public class ProdutoControl {

	@Autowired
	private ProdutoDao produtoDao;
	private Produto produto = new Produto();
	private List<Produto> produtos = new ArrayList<>();

	@PostConstruct
	public void init() {
		listar();
	}

	public void salvar() {
//		produtoDao.save(produto);
//		produto = new Produto();
//		listar();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Autor não existente no banco de dados."));
	}

	public void listar() {
		produtos = produtoDao.findAll();
	}

	public void excluir(Integer id) {
		produtoDao.deleteById(id);
		listar();
	}

	public ProdutoDao getProdutoDao() {
		return produtoDao;
	}

	public void setProdutoDao(ProdutoDao produtoDao) {
		this.produtoDao = produtoDao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Produto> completeProduto(String nome) {
		return produtoDao.completeProduto("%" + nome + "%");
	}

}
