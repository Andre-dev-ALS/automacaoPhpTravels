package br.com.phptravels.enums;

public enum Planilhas {
	DADOS_PESSOAIS("dadosPessoais");

	String valor;

	Planilhas(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return this.valor;
	}
}
