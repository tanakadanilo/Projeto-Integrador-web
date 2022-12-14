package br.com.amogus.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.amogus.dao.OrdemDeServicoDao;
import br.com.amogus.dao.PessoaDaoImpl;
import br.com.amogus.dao.ProdutoDao;
import br.com.amogus.dao.ServicoDao;
import br.com.amogus.dao.VeiculoDao;
import br.com.amogus.entidade.OrdemDeServico;
import br.com.amogus.entidade.OrdemDeServicoProduto;
import br.com.amogus.entidade.OrdemDeServicoServico;
import br.com.amogus.entidade.Pessoa;
import br.com.amogus.entidade.Produto;
import br.com.amogus.entidade.Servico;
import br.com.amogus.entidade.Veiculo;
import br.com.amogus.validation.ValidaOrdemDeServico;

@Component
@SessionScoped
public class OrdemDeServicoControl {

	private Integer pessoaId;
	private Integer servicoId;
	private Integer funcionarioId;

	@Autowired
	private PessoaDaoImpl pessoaDaoImpl;

	@Autowired
	private VeiculoDao veiculoDao;

	@Autowired
	private OrdemDeServicoDao ordemDeServicoDao;

	@Autowired
	private ServicoDao servicoDao;

	@Autowired
	private ProdutoDao produtoDao;

	private String placa;
	private OrdemDeServico ordemDeServico = new OrdemDeServico();
	private OrdemDeServicoProduto ordemDeServicoProduto = new OrdemDeServicoProduto();
	private OrdemDeServicoServico ordemDeServicoServico = new OrdemDeServicoServico();
	List<OrdemDeServico> ordensDeServicos = new ArrayList<>();

	@PostConstruct
	public void init() {
		listar();
	}

	public void listar() {
		ordensDeServicos = ordemDeServicoDao.findAll();
	}

	public void excluir(Integer id) {
		ordemDeServicoDao.deleteById(id);
		listar();
	}

	public void salvar() {
		if (ValidaOrdemDeServico.validadeDatas(ordemDeServico.getDataEntrada(), ordemDeServico.getDataInicioServico(),
				ordemDeServico.getDataEntrega(), ordemDeServico.getDataFimServico())
				&& ValidaOrdemDeServico.validaDesconto(ordemDeServico.getDesconto(),
						ordemDeServico.getTotalSemDesconto())) {
			ordemDeServicoDao.save(ordemDeServico);

		}
		ordemDeServico = new OrdemDeServico();
		listar();

	}

	public void setVeiculo() {
		Veiculo veiculo = veiculoDao.consultarPorPlaca(placa);
		ordemDeServico.setVeiculo(veiculo);
	}

	public void setServico() {
		Servico servico = servicoDao.findById(servicoId).get();
		ordemDeServicoServico.setServico(servico);
		ordemDeServicoServico.setPreco(servico.getPreco());
	}

	public void addServico() {
		ordemDeServico.getServicos().add(ordemDeServicoServico);
		servicoId = null;
		ordemDeServicoServico = new OrdemDeServicoServico();
	}

	public void removeServico() {
		ordemDeServico.getServicos().remove(ordemDeServicoServico);
		servicoId = null;
		ordemDeServicoServico = new OrdemDeServicoServico();
	}

	public List<Pessoa> completePessoa(String query) {
		return pessoaDaoImpl.listarPorNome("%" + query + "%", null);
	}

	public List<Servico> completeServico(String query) {
		return servicoDao.listarPorNome("%" + query + "%");
	}

	public List<Produto> completeProduto(String query) {
		return produtoDao.completeProduto("%" + query + "%");
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

	public OrdemDeServico getOrdemServico() {
		return ordemDeServico;
	}

	public void setOrdemServico(OrdemDeServico ordemServico) {
		this.ordemDeServico = ordemServico;
	}

	public Integer getServicoId() {
		return servicoId;
	}

	public void setServicoId(Integer servicoId) {
		this.servicoId = servicoId;
	}

	public OrdemDeServicoServico getOrdemServicoServico() {
		return ordemDeServicoServico;
	}

	public void setOrdemServicoServico(OrdemDeServicoServico ordemServicoServico) {
		this.ordemDeServicoServico = ordemServicoServico;
	}

	public OrdemDeServico getOrdemDeServico() {
		return ordemDeServico;
	}

	public void setOrdemDeServico(OrdemDeServico ordemDeServico) {
		this.ordemDeServico = ordemDeServico;
	}

	public OrdemDeServicoProduto getOrdemDeServicoProduto() {
		return ordemDeServicoProduto;
	}

	public void setOrdemDeServicoProduto(OrdemDeServicoProduto ordemDeServicoProduto) {
		this.ordemDeServicoProduto = ordemDeServicoProduto;
	}

	public OrdemDeServicoServico getOrdemDeServicoServico() {
		return ordemDeServicoServico;
	}

	public void setOrdemDeServicoServico(OrdemDeServicoServico ordemDeServicoServico) {
		this.ordemDeServicoServico = ordemDeServicoServico;
	}

	public List<OrdemDeServico> getOrdensDeServicos() {
		return ordensDeServicos;
	}

	public void setOrdensDeServicos(List<OrdemDeServico> ordensDeServicos) {
		this.ordensDeServicos = ordensDeServicos;
	}

	public void adicionarOrdemDeServicoServico() {
		this.ordemDeServico.adicionarOrdemDeServicoServico(ordemDeServicoServico);
	}

	public void adicionarOrdemDeServicoProduto() {
		this.ordemDeServico.adicionarOrdemDeServicoProduto(ordemDeServicoProduto);
	}

}
