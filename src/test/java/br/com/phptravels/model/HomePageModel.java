package br.com.phptravels.model;

import br.com.phptravels.utilities.Context;
import br.com.phptravels.utilities.ExcelActions;

public class HomePageModel {
	private static final String NOME_DA_PLANILHA = "dadosPessoais";
	private static final String COLUNA_NOME = "nome";
	private static final String COLUNA_SOBRENOME = "sobrenome";
	private static final String COLUNA_NOME_DA_EMPRESA = "nomeDaEmpresa";
	private static final String COLUNA_EMAIL = "email";

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

	public static String nomeDaPlanilha() {
		return NOME_DA_PLANILHA;
	}

	public static String getColunaNome() {
		return COLUNA_NOME;
	}

	public static String getColunaSobrenome() {
		return COLUNA_SOBRENOME;
	}

	public static String getColunaNomeDaEmpresa() {
		return COLUNA_NOME_DA_EMPRESA;
	}

	public static String getColunaEmail() {
		return COLUNA_EMAIL;
	}

	public String getNome() {
		return nome;
	}

	private void setNome() {
		nome = setAtributo(getColunaNome());
	}

	public String getSobreNome() {
		return sobreNome;
	}

	private void setSobreNome() {
		sobreNome = setAtributo(COLUNA_SOBRENOME);
	}

	public String getNomeDaEmpresa() {
		return nomeDaEmpresa;
	}

	private void setNomeDaEmpresa() {
		nomeDaEmpresa = setAtributo(COLUNA_NOME_DA_EMPRESA);
	}

	public String getEmail() {
		return email;
	}

	private void setEmail() {
		email = setAtributo(COLUNA_EMAIL);
	}

	private String setAtributo(String coluna) {
		return excel.getValueInTheWorksheet(NOME_DA_PLANILHA, Context.getId(), coluna);

	}

}
