package bancodedados.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pessoa extends ModelBanco {

	private String nome;
	private String cpf;
	private String endereco;
	private String bairro;
	private String cep;

	@ManyToOne
	@JoinColumn(name = "idMunicipio")
	private Municipio idMunicipio;
	private String telefone;
	private boolean whatsapp;
	private boolean funcionario;

	public Pessoa() {
	}

	public Pessoa(int id, String nome, String cpf, String endereco, String bairro, String cep, Municipio idMunicipio,
			String telefone, boolean whatsapp, boolean funcionario) {
		super(id);
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cep = cep;
		this.idMunicipio = idMunicipio;
		this.telefone = telefone;
		this.whatsapp = whatsapp;
		this.funcionario = funcionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Municipio getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(Municipio idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean isWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(boolean whatsapp) {
		this.whatsapp = whatsapp;
	}

	public boolean isFuncionario() {
		return funcionario;
	}

	public void setFuncionario(boolean funcionario) {
		this.funcionario = funcionario;
	}

}
