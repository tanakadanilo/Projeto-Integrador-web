package br.com.amogus.validation;

import java.math.BigDecimal;
import java.util.Date;

import br.com.amogus.entidade.OrdemDeServico;
import br.com.amogus.exceptions.ExcecaoDadoInvalido;

public class ValidaOrdemDeServico {

	public boolean validaOrdemDeServico(OrdemDeServico os) throws ExcecaoDadoInvalido {

		boolean isDatasValidas = validadeDatas(os.getDataEntrada(), os.getDataInicioServico(), os.getDataFimServico(),
				os.getDataEntrega());
		boolean isDescontoValido = validaDesconto(os.getDesconto(), os.getTotalServicos());
		return isDatasValidas && isDescontoValido;

	}

	public boolean validadeDatas(Date dataEntradaVeiculo, Date dataInicioServico, Date dataSaidaVeiculo,
			Date dataEntregaServico) throws ExcecaoDadoInvalido{
		if (dataEntradaVeiculo.after(dataSaidaVeiculo)) {
			throw new ExcecaoDadoInvalido("A Data de saida do veiculo não pode ser antes da data de entrada");

		}
		if (dataInicioServico.after(dataEntregaServico)) {
			throw new ExcecaoDadoInvalido(
					"A data de entrega do servico não pode ser antes da data de entrada do veiculo");
		}
		if (dataInicioServico.before(dataEntradaVeiculo)) {
			throw new ExcecaoDadoInvalido(
					"A data de início do serviço não pode ser antes da data de entrada do veiculo");
		}
		if (dataSaidaVeiculo.before(dataEntregaServico)) {
			throw new ExcecaoDadoInvalido(
					"A data de entrega do veículo não pode ser antes da data de entrega do serviço");
		}
		return true;
	}

	public boolean validaDesconto(BigDecimal desconto, BigDecimal valorSemDesconto) throws ExcecaoDadoInvalido {
		if (desconto.doubleValue() < 0) {
			throw new ExcecaoDadoInvalido("O valor do desconto não pode ser negativo");
		}
		if (desconto.compareTo(valorSemDesconto) < 0) {
			throw new ExcecaoDadoInvalido("O valor do desconto não pode ser maior do que o valor total");
		}
		return true;
	}
}
