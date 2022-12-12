package br.com.amogus.validation;

import java.util.InputMismatchException;

public class ValidaPessoa {

	public boolean validaTelefone(String telefoneParaValidar) {
		telefoneParaValidar = telefoneParaValidar.trim();
		if (telefoneParaValidar.matches("^\\([1-9]{2}\\) 9[7-9]{1}[0-9]{3}\\-[0-9]{4}$")) {
			return true;
		} else {
			telefoneParaValidar = formataTelefone(telefoneParaValidar);// formatando o telefone para colocar os
																		// parenteses no DDD e o hifen no meio do numero
			return (telefoneParaValidar.matches("^\\([1-9]{2}\\) 9[7-9]{1}[0-9]{3}\\-[0-9]{4}$"));
		}
		// o método matches, diz se uma String segue o padrão informado, que no caso é o
		// padrão de telefone, com parênteses e o hifen "(xx) 9XXXX-XXXX"
	}

	public String formataTelefone(String telefoneParaFormatar) {
		if (telefoneParaFormatar.length() < 7) {// se for menor q 7 não dá pra formatar
			return "O Telefone: " + telefoneParaFormatar + "é inválido";
		}

		StringBuilder telefoneFormatado = new StringBuilder();
		telefoneFormatado.append('(').append(telefoneParaFormatar.substring(0, 2)).append(')');
		telefoneFormatado.append(' ').append(telefoneParaFormatar.substring(2, 7)).append('-');
		telefoneFormatado.append(telefoneParaFormatar.substring(7));

		return String.valueOf(telefoneFormatado);
	}

	public boolean validaEmail(String email) {
		return email.matches(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}

	public static boolean validaCPF(String CPF) {
		CPF = desformatarCPF(CPF);
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || (CPF.length() != 11)) {
			return (false);
		}

		char dig10, dig11;
		int sm, i, r, num, peso;

		sm = 0;
		peso = 10;
		for (i = 0; i < 9; i++) {
			num = (int) (CPF.charAt(i) - 48);
			sm = sm + (num * peso);
			peso = peso - 1;
		}

		r = 11 - (sm % 11);
		if ((r == 10) || (r == 11)) {
			dig10 = '0';
		} else {
			dig10 = (char) (r + 48);
		}

		sm = 0;
		peso = 11;
		for (i = 0; i < 10; i++) {
			num = (int) (CPF.charAt(i) - 48);
			sm = sm + (num * peso);
			peso = peso - 1;
		}

		r = 11 - (sm % 11);
		if ((r == 10) || (r == 11)) {
			dig11 = '0';
		} else {
			dig11 = (char) (r + 48);
		}

		if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
			return (true);
		} else {
			return (false);
		}

	}

	public static String formataCPF(String CPF) {
		CPF = desformatarCPF(CPF);
		return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-"
				+ CPF.substring(9, 11));

	}

	public static String desformatarCPF(String cpf) {
		if (cpf.matches("^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$")) {
			return cpf.substring(0, 3) + cpf.substring(4, 7) + cpf.substring(8, 11) + cpf.substring(12);
		} else {
			return cpf;
		}
	}

	public static boolean validaCNPJ(String CNPJ) {
		// considera-se erro CNPJ's formados por uma sequencia de numeros iguais
		if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") || CNPJ.equals("22222222222222")
				|| CNPJ.equals("33333333333333") || CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555")
				|| CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") || CNPJ.equals("88888888888888")
				|| CNPJ.equals("99999999999999") || (CNPJ.length() != 14)) {
			return (false);
		}

		char dig13, dig14;
		int sm, i, r, num, peso;

		// "try" - protege o código para eventuais erros de conversao de tipo (int)
		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 2;
			for (i = 11; i >= 0; i--) {
				// converte o i-ésimo caractere do CNPJ em um número:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posição de '0' na tabela ASCII)
				num = (int) (CNPJ.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10) {
					peso = 2;
				}
			}

			r = sm % 11;
			if ((r == 0) || (r == 1)) {
				dig13 = '0';
			} else {
				dig13 = (char) ((11 - r) + 48);
			}

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 2;
			for (i = 12; i >= 0; i--) {
				num = (int) (CNPJ.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10) {
					peso = 2;
				}
			}

			r = sm % 11;
			if ((r == 0) || (r == 1)) {
				dig14 = '0';
			} else {
				dig14 = (char) ((11 - r) + 48);
			}

			// Verifica se os dígitos calculados conferem com os dígitos informados.
			if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13))) {
				return (true);
			} else {
				return (false);
			}
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

	public static String formataCNPJ(String CNPJ) {
		// máscara do CNPJ: 99.999.999/9999-99
		return (CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "." + CNPJ.substring(5, 8) + "/"
				+ CNPJ.substring(8, 12) + "-" + CNPJ.substring(12, 14));
	}

	public static String desformatarCNPJ(String CNPJ) {
		return CNPJ.substring(0, 2) + CNPJ.substring(3, 6) + CNPJ.substring(7, 10) + CNPJ.substring(11, 15)
				+ CNPJ.substring(16, 18);

	}

}
