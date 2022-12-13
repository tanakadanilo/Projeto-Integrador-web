package br.com.amogus.validation;

import java.math.BigDecimal;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.amogus.entidade.OrdemDeServico;
import br.com.amogus.exceptions.ExcecaoDadoInvalido;

public class ValidaOrdemDeServico {

	public static boolean validaOrdemDeServico(OrdemDeServico os) throws ExcecaoDadoInvalido {

		boolean isDatasValidas = validadeDatas(os.getDataEntrada(), os.getDataInicioServico(), os.getDataEntrega(),
				os.getDataFimServico());

		boolean isDescontoValido = validaDesconto(os.getDesconto(), BigDecimal.valueOf(os.getTotalServicos()));
		return isDatasValidas && isDescontoValido;

	}

	public static boolean validadeDatas(Date dataEntradaVeiculo, Date dataInicioServico, Date dataSaidaVeiculo,
			Date dataEntregaServico) {

		if (!validaDataEntrega(dataEntregaServico, dataInicioServico)) {
			return false;
		}
		if (!validaDataInicioServico(dataInicioServico, dataEntradaVeiculo)) {
			return false;
		}
		if (!validaDataSaida(dataEntregaServico, dataSaidaVeiculo)) {
			return false;
		}
		return true;
	}

	public static boolean validaDataFimServico(Date dataFimServico, Date dataInicioServico) {

		if (dataFimServico == null) {
			return true;
		}
		if (dataFimServico.after(dataInicioServico)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("A data de entrega do serviço não pode ser antes da data de inicio do serviço"));
			return false;
		}
		return true;
	}

	public static boolean validaDataEntrega(Date dataEntregaServico, Date dataInicioServico) {
		if (dataEntregaServico == null) {
			return true;
		}
		if (dataInicioServico.after(dataEntregaServico)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("A data de entrega do servico não pode ser antes da data de entrada do veiculo"));
			return false;
		}
		return true;
	}

	public static boolean validaDataInicioServico(Date dataInicioServico, Date dataEntradaVeiculo) {
		if (dataInicioServico == null) {
			return true;
		}
		if (dataInicioServico.before(dataEntradaVeiculo)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("A data de início do serviço não pode ser antes da data de entrada do veiculo"));
			return false;
		}
		return true;
	}

	public static boolean validaDataSaida(Date dataEntregaServico, Date dataSaidaVeiculo) {
		if (dataSaidaVeiculo == null) {
			return true;
		}
		if (dataEntregaServico.after(dataSaidaVeiculo)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("A Data de saida do veiculo não pode ser antes da data de entrada"));
			return false;
		}
		return true;
	}

	public static boolean validaDesconto(BigDecimal desconto, BigDecimal valorSemDesconto) {
		if (desconto == null) {
			return true;
		}
		if (valorSemDesconto == null) {
			return true;
		}

		if (desconto.doubleValue() < 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("O valor do desconto não pode ser negativo"));
		}
		if (desconto.compareTo(valorSemDesconto) > 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("O valor do desconto não pode ser maior do que o valor total"));
		}
		return true;
	}
}
