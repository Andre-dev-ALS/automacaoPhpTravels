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
		nome = excel.buscarValorNaPlanilha("dadosPessoais", Context.getId(), "nome");
	}

	public String getSobreNome() {
		return sobreNome;
	}

	private void setSobreNome() {
		sobreNome = excel.buscarValorNaPlanilha("dadosPessoais", Context.getId(), "sobrenome");
	}

	public String getNomeDaEmpresa() {
		return nomeDaEmpresa;
	}

	private void setNomeDaEmpresa() {
		nomeDaEmpresa = excel.buscarValorNaPlanilha("dadosPessoais", Context.getId(), "nomeDaEmpresa");
	}

	public String getEmail() {
		return email;
	}

	private void setEmail() {
		email = excel.buscarValorNaPlanilha("dadosPessoais", Context.getId(), "email");
	}

}
