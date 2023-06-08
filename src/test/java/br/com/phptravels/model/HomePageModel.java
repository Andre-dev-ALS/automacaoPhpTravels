package br.com.phptravels.model;

import br.com.phptravels.managers.FileReaderManager;
import br.com.phptravels.utilities.ExcelActions;

public class HomePageModel {
	static final String caminhoDaPastaDeTrabalho = FileReaderManager.getInstance().getConfigReader().getExcelPath();
	static final String NOME_DA_PLANILHA = "dadosPessoais";
	static final String COLUNA_NOME = "nome";
	static final String COLUNA_SOBRENOME = "sobrenome";
	static final String COLUNA_NOME_DA_EMPRESA = "nomeDaEmpresa";
	static final String COLUNA_EMAIL = "email";

	private String nome;
	private String sobreNome;
	private String nomeDaEmpresa;
	private String email;
	private ExcelActions excel;

	public HomePageModel() {
		excel = new ExcelActions(caminhoDaPastaDeTrabalho, NOME_DA_PLANILHA);
		nome = setAtributo(COLUNA_NOME);
		sobreNome = setAtributo(COLUNA_SOBRENOME);
		nomeDaEmpresa = setAtributo(COLUNA_NOME_DA_EMPRESA);
		email = setAtributo(COLUNA_EMAIL);
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
