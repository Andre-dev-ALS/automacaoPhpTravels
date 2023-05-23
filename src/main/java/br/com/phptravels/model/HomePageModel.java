package br.com.phptravels.model;

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
		nome = setAtributo("nome");
	}

	public String getSobreNome() {
		return sobreNome;
	}

	private void setSobreNome() {
		sobreNome = setAtributo("sobrenome");
	}

	public String getNomeDaEmpresa() {
		return nomeDaEmpresa;
	}

	private void setNomeDaEmpresa() {
		nomeDaEmpresa = setAtributo("nomeDaEmpresa");
	}

	public String getEmail() {
		return email;
	}

	private void setEmail() {
		email = setAtributo("email");
	}

	private String setAtributo(String atributo) {
		return excel.buscarValorNaPlanilha("dadosPessoais", Context.getId(), atributo);

	}

}
