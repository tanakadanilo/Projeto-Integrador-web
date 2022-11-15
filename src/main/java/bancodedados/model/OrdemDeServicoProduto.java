package bancodedados.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class OrdemDeServicoProduto extends ModelBanco {

	@OneToOne
	private Produto produto;

	@OneToOne
	private OrdemDeServico OrdemServico;
	private int quantidade;
	private float preco;

	public OrdemDeServicoProduto() {
	}

	public OrdemDeServicoProduto(Produto produto, OrdemDeServico ordemServico, int quantidade, float preco) {
		this.produto = produto;
		OrdemServico = ordemServico;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public OrdemDeServico getOrdemServico() {
		return OrdemServico;
	}

	public void setOrdemServico(OrdemDeServico ordemServico) {
		OrdemServico = ordemServico;
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
