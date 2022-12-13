package br.com.amogus.entidade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.amogus.validation.ValidaOrdemDeServico;

@Entity
public class OrdemDeServico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(optional = false)
	private Pessoa cliente;

	@ManyToOne(optional = false)
	private Pessoa funcionario;

	@ManyToOne(optional = false)
	private Veiculo veiculo;

	private Double totalServicos;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ordem_servico_id")
	private List<OrdemDeServicoServico> servicos = new ArrayList<>();

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ordem_servico_id")
	private List<OrdemDeServicoProduto> produtos = new ArrayList<>();

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEntrada;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataOs;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicioServico;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFimServico;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEntrega;

	private BigDecimal desconto = BigDecimal.ZERO;

	public void setTotalServicos(Double totalServicos) {
		this.totalServicos = totalServicos;
	}

	public Double getTotalServicos() {
		BigDecimal vlr = BigDecimal.ZERO;
		for (OrdemDeServicoServico oss : servicos) {
			vlr = vlr.add(oss.getTotal());
		}
		totalServicos = vlr.doubleValue();
		return vlr.doubleValue();
	}

	public BigDecimal getTotalProdutos() {
		BigDecimal vlr = BigDecimal.ZERO;
		for (OrdemDeServicoProduto oss : produtos) {
			vlr = vlr.add(oss.getPreco());
		}
		return vlr;
	}

	public BigDecimal getTotalSemDesconto() {
		return getTotalProdutos().add(getTotalProdutos());
	}

	public BigDecimal getValorFinal() {
		return getTotalSemDesconto().subtract(desconto);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public Pessoa getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Pessoa funcionario) {
		this.funcionario = funcionario;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Date getData() {
		return data;
	}

	@PostConstruct
	public void setData(Date data) {
		this.dataOs = new Date();
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataOs() {
		return dataOs;
	}

	public void setDataOs(Date dataOs) {
		this.dataOs = dataOs;
	}

	public Date getDataInicioServico() {
		return dataInicioServico;
	}

	public void setDataInicioServico(Date dataInicioServico) {
		ValidaOrdemDeServico.validaDataInicioServico(dataInicioServico, dataEntrada);
		this.dataInicioServico = dataInicioServico;
	}

	public Date getDataFimServico() {
		return dataFimServico;
	}

	public void setDataFimServico(Date dataFimServico) {
		ValidaOrdemDeServico.validaDataFimServico(dataFimServico, dataInicioServico);
		this.dataFimServico = dataFimServico;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		ValidaOrdemDeServico.validaDataEntrega(dataEntrega, dataInicioServico);
		this.dataEntrega = dataEntrega;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		ValidaOrdemDeServico.validaDesconto(desconto, getTotalSemDesconto());
		this.desconto = desconto;
	}

	public void setServicos(List<OrdemDeServicoServico> servicos) {
		this.servicos = servicos;
	}

	public void setProdutos(List<OrdemDeServicoProduto> produtos) {
		this.produtos = produtos;
	}

	public List<OrdemDeServicoServico> getServicos() {
		return servicos;
	}

	public List<OrdemDeServicoProduto> getProdutos() {
		return produtos;
	}

	public void adicionarOrdemDeServicoServico(OrdemDeServicoServico oss) {
		this.servicos.add(oss);
	}

	public void adicionarOrdemDeServicoProduto(OrdemDeServicoProduto osp) {
		this.produtos.add(osp);
	}

}
