package br.com.phptravels.enums;

public enum Colunas {
	NOME("nome"), SOBRENOME("sobrenome"), NOME_DA_EMPRESA("nomeDaEmpresa"), EMAIL("email");

	private String valor;

	Colunas(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return this.valor;
	}
}
