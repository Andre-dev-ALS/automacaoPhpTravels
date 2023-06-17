package br.com.phptravels.model;

import static br.com.phptravels.utilities.Context.getConfigFileReader;

import br.com.phptravels.utilities.ExcelActions;

public class HomePageModel {
	static final String CAMINHO_DA_PASTA_DE_TRABALHO = getConfigFileReader().getExcelPath();
	static final String NOME_DA_PLANILHA = "dadosPessoais";

	private String nome;
	private String sobreNome;
	private String nomeDaEmpresa;
	private String email;
	private ExcelActions excel;

	public HomePageModel() {
		excel = new ExcelActions(CAMINHO_DA_PASTA_DE_TRABALHO, NOME_DA_PLANILHA);
		nome = setAtributo("nome");
		sobreNome = setAtributo("sobrenome");
		nomeDaEmpresa = setAtributo("nomeDaEmpresa");
		email = setAtributo("email");
		excel.closeExcel();
	}

	public String getNome() {
		return nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public String getNomeDaEmpresa() {
		return nomeDaEmpresa;
	}

	public String getEmail() {
		return email;
	}

	private String setAtributo(String coluna) {
		return excel.getValueInTheWorksheet(coluna);
	}

}
