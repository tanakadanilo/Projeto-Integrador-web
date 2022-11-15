package bancodedados.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class OrdemDeServico extends ModelBanco {

	@OneToOne
	private Pessoa Cliente;

	@OneToOne
	private Pessoa Funcionario;

	@OneToOne
	private Veiculo Veiculo;
	private Date data;
	private Date dataEntrada;
	private Date dataOrdemDeServico;
	private Date dataInicioServico;
	private Date dataFimServico;
	private Date dataEntrega;
	private float desconto;

	public OrdemDeServico() {
	}

	public OrdemDeServico(Pessoa cliente, Pessoa funcionario, Veiculo veiculo, Date data, Date dataEntrada,
			Date dataOrdemDeServico, Date dataInicioServico, Date dataFimServico, Date dataEntrega, float desconto) {
		Cliente = cliente;
		Funcionario = funcionario;
		Veiculo = veiculo;
		this.data = data;
		this.dataEntrada = dataEntrada;
		this.dataOrdemDeServico = dataOrdemDeServico;
		this.dataInicioServico = dataInicioServico;
		this.dataFimServico = dataFimServico;
		this.dataEntrega = dataEntrega;
		this.desconto = desconto;
	}

	public Pessoa getCliente() {
		return Cliente;
	}

	public void setCliente(Pessoa cliente) {
		Cliente = cliente;
	}

	public Pessoa getFuncionario() {
		return Funcionario;
	}

	public void setFuncionario(Pessoa funcionario) {
		Funcionario = funcionario;
	}

	public Veiculo getVeiculo() {
		return Veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		Veiculo = veiculo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataOrdemDeServico() {
		return dataOrdemDeServico;
	}

	public void setDataOrdemDeServico(Date dataOrdemDeServico) {
		this.dataOrdemDeServico = dataOrdemDeServico;
	}

	public Date getDataInicioServico() {
		return dataInicioServico;
	}

	public void setDataInicioServico(Date dataInicioServico) {
		this.dataInicioServico = dataInicioServico;
	}

	public Date getDataFimServico() {
		return dataFimServico;
	}

	public void setDataFimServico(Date dataFimServico) {
		this.dataFimServico = dataFimServico;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}

}
