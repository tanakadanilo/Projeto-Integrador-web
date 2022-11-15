package bancodedados.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Estoque extends ModelBanco {

	@OneToOne
	@JoinColumn(name = "idProduto")
	private Produto idProduto;

	@Column
	private int quantidade;

	public Estoque() {
	}

	public Estoque(Produto idProduto, int quantidade) {
		super();
		this.idProduto = idProduto;
		this.quantidade = quantidade;
	}

	public Estoque(int id, Produto idProduto, int quantidade) {
		super(id);
		this.idProduto = idProduto;
		this.quantidade = quantidade;
	}

	public Produto getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Produto idProduto) {
		this.idProduto = idProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Estoque [id=" + super.id + ", idProduto=" + idProduto + ", quantidade=" + quantidade + "]";
	}

}
