package br.com.phptravels.model;

import br.com.phptravels.enums.Colunas;
import br.com.phptravels.enums.Planilhas;
import br.com.phptravels.utilities.Context;
import br.com.phptravels.utilities.ExcelActions;

public class HomePageModel {
	private String nome;
	private String sobreNome;
	private String nomeDaEmpresa;
	private String email;
	private ExcelActions excel;

	public HomePageModel() {

		excel = new ExcelActions();
		setNome();
		setSobreNome();
		setNomeDaEmpresa();
		setEmail();
	}

	public String getNome() {
		return nome;
	}

	private void setNome() {
		nome = setAtributo(Colunas.NOME.getValor());
	}

	public String getSobreNome() {
		return sobreNome;
	}

	private void setSobreNome() {
		sobreNome = setAtributo(Colunas.SOBRENOME.getValor());
	}

	public String getNomeDaEmpresa() {
		return nomeDaEmpresa;
	}

	private void setNomeDaEmpresa() {
		nomeDaEmpresa = setAtributo(Colunas.NOME_DA_EMPRESA.getValor());
	}

	public String getEmail() {
		return email;
	}

	private void setEmail() {
		email = setAtributo(Colunas.EMAIL.getValor());
	}

	private String setAtributo(String coluna) {
		return excel.buscarValorNaPlanilha(Planilhas.DADOS_PESSOAIS.getValor(), Context.getId(), coluna);

	}

}
