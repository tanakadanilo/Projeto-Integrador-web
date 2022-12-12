package br.com.amogus.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.amogus.dao.ServicoDao;
import br.com.amogus.entidade.Servico;


@Component
@SessionScoped
public class SpringManagedBean {

	private String seiLa = "OK ";
	
	private List<Servico> servicos = new ArrayList<>();
	
	@Autowired
	private ServicoDao servicoDao;
	
	@PostConstruct
	public void init() {
		this.servicos = servicoDao.findAll();
	}
	
	public void acao() {
		seiLa += " Clicou";
	}

	public String getMessage() {
		return seiLa.toUpperCase();
	}

	public void setMessage(String message) {
		this.seiLa = message;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
	

}
