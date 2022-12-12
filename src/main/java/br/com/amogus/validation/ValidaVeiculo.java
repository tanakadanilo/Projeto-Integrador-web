package br.com.amogus.validation;

public class ValidaVeiculo {
	public boolean validaRenavan(String renavan) {
		final String FORMATED = "(\\d{4})[.](\\d{6})-(\\d{1})";
		final String UNFORMATED = "(\\d{4})(\\d{6})(\\d{1})";
		return renavan.matches(FORMATED) || renavan.matches(UNFORMATED);
	}

	public boolean validaPlaca(String placa) {
		return placa.replace("-", "").matches("[a-zA-Z]{3}[0-9]{1}[a-zA-Z0-9]{1}[0-9]{2}");
	}

	public boolean validaChassi(String chassi) {
		chassi = chassi.toUpperCase().replace(" ", "");
		return !chassi.matches("^O") && !chassi.matches(" ") && !chassi.matches("[iIoOqQ]") && chassi.length() == 17;
	}

}