package com.example.oficinaco.jpa.jsf;

import java.util.List;

import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.oficinaco.jpa.dao.PessoaDao;
import com.example.oficinaco.jpa.dao.PessoaDaoImpl;
import com.example.oficinaco.jpa.dao.ServicoDao;
import com.example.oficinaco.jpa.dao.VeiculoDao;
import com.example.oficinaco.jpa.entidade.OrdemServico;
import com.example.oficinaco.jpa.entidade.OrdemServicoServico;
import com.example.oficinaco.jpa.entidade.Pessoa;
import com.example.oficinaco.jpa.entidade.Servico;
import com.example.oficinaco.jpa.entidade.Veiculo;

@Component
@SessionScoped
public class OrdemServicoControl {
	
	private Integer pessoaId;

	private Integer servicoId;

	private Integer funcionarioId;
	
	@Autowired
	private PessoaDao pessoaDao;
	
	@Autowired
	private VeiculoDao veiculoDao;
	
	private String placa;
	
	private OrdemServico ordemServico = new OrdemServico();
	
	private OrdemServicoServico ordemServicoServico = new OrdemServicoServico();
	
	@Autowired
	private PessoaDaoImpl pessoaDaoImpl;
	
	@Autowired
	private ServicoDao servicoDao;
	
	public void atualizarVeiculo() {
		Veiculo veiculo = veiculoDao.consultarPorPlaca(placa);
		ordemServico.setVeiculo(veiculo);
	}
	
	public void selecionarServico() {
		Servico servico = servicoDao.findById(servicoId).get();
		ordemServicoServico.setServico(servico);
		ordemServicoServico.setPreco(servico.getPreco());
	}
	
	public void addServico() {
		ordemServico.getServicos().add(ordemServicoServico);
		servicoId = null;
		ordemServicoServico = new OrdemServicoServico();
	}
	
    public List<Pessoa> completePessoa(String query) {
    	return pessoaDaoImpl.listarPorNome("%" + query + "%", null);
    }	

    public List<Servico> completeServico(String query) {
    	return servicoDao.listarPorNome("%" + query + "%");
    }	
    
    public List<Pessoa> completeFuncionario(String query) {
    	return pessoaDaoImpl.listarPorNome("%" + query + "%", true);
    }	

	public Integer getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Integer pessoaId) {
		this.pessoaId = pessoaId;
	}

	public Integer getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Integer funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public Integer getServicoId() {
		return servicoId;
	}

	public void setServicoId(Integer servicoId) {
		this.servicoId = servicoId;
	}

	public OrdemServicoServico getOrdemServicoServico() {
		return ordemServicoServico;
	}

	public void setOrdemServicoServico(OrdemServicoServico ordemServicoServico) {
		this.ordemServicoServico = ordemServicoServico;
	}

	
}
