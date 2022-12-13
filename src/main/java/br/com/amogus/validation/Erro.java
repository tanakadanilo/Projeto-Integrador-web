package br.com.amogus.validation;

import org.springframework.stereotype.Component;

@Component
public class Erro {

	private static String message;

	public static String getMessage() {
		return message;
	}

	public static void setMessage(String novaMessage) {
		message = novaMessage;
	}

}
