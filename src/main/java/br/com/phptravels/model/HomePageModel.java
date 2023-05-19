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

	public void setNome() {
		nome = excel.buscarValorNaPlanilha("dadosPessoais", Context.getId(), "nome");
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome() {
		sobreNome = excel.buscarValorNaPlanilha("dadosPessoais", Context.getId(), "sobrenome");
	}

	public String getNomeDaEmpresa() {
		return nomeDaEmpresa;
	}

	public void setNomeDaEmpresa() {
		nomeDaEmpresa = excel.buscarValorNaPlanilha("dadosPessoais", Context.getId(), "nomeDaEmpresa");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail() {
		email = excel.buscarValorNaPlanilha("dadosPessoais", Context.getId(), "email");
	}

}
