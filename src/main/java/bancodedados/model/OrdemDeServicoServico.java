package bancodedados.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class OrdemDeServicoServico extends ModelBanco {

	@OneToOne
	private Servico Servico;

	@OneToOne
	private OrdemDeServico OrdemDeServico;
	private int quantidade;
	private float preco;

	public OrdemDeServicoServico() {
	}

	public OrdemDeServicoServico(Servico servico,
			OrdemDeServico ordemDeServico, int quantidade, float preco) {
		Servico = servico;
		OrdemDeServico = ordemDeServico;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Servico getServico() {
		return Servico;
	}

	public void setServico(Servico servico) {
		Servico = servico;
	}

	public OrdemDeServico getOrdemDeServico() {
		return OrdemDeServico;
	}

	public void setOrdemDeServico(OrdemDeServico ordemDeServico) {
		OrdemDeServico = ordemDeServico;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

}
