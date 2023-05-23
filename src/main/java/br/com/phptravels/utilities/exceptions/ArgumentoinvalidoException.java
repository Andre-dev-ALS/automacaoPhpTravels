package br.com.phptravels.utilities.exceptions;

import org.openqa.selenium.InvalidArgumentException;

@SuppressWarnings("serial")
public class ArgumentoinvalidoException extends InvalidArgumentException {
	private String nomeDoAtributoProcurado;

	public ArgumentoinvalidoException(String nomeDoAtributoProcurado) {
		super(nomeDoAtributoProcurado);
		this.nomeDoAtributoProcurado = nomeDoAtributoProcurado;
	}

	@Override
	public String getMessage() {
		return String.format("O atributo %s não existe ", nomeDoAtributoProcurado);
	}

	@Override
	public String toString() {
		return getMessage();
	}
}