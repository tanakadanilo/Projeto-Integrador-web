package br.com.amogus.entidade;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrdemDeServicoServico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(optional = false)
	private Servico servico;

	private Integer quantidade;

	private BigDecimal preco;

	public BigDecimal getTotal() {
		return BigDecimal.valueOf(getPreco().doubleValue() * quantidade);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		setPreco(null);
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = servico.getPreco().multiply(BigDecimal.valueOf(quantidade));
	}

	@Override
	public String toString() {
		return servico.getNome();
	}

}
