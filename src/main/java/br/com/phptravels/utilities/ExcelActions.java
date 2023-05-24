package br.com.phptravels.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.phptravels.managers.FileReaderManager;
import br.com.phptravels.utilities.exceptions.ArgumentoinvalidoException;

public class ExcelActions {

	private static XSSFWorkbook pastaDeTrabalho;
	private static XSSFSheet folha;
	private static XSSFCell celula;
	private String nomeDaPlanilha = "";

	public void setArquivoExcel(String nomeDaPlanilha) {
		try {
			File arquivo = new File(FileReaderManager.getInstance().getConfigReader().getExcelPath());
			pastaDeTrabalho = new XSSFWorkbook(arquivo);
		} catch (IOException | InvalidFormatException e) {
			System.out.println("pasta de trabalho não encontrada.");
			e.printStackTrace();
		}
		folha = pastaDeTrabalho.getSheet(nomeDaPlanilha);
		try {
			pastaDeTrabalho.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("erro ao fechar o excel");
		}

	}

	public int encontrarColuna(String nomeDaColuna) throws ArgumentoinvalidoException {
		setArquivoExcel(nomeDaPlanilha);
		int cellcount = folha.getRow(0).getLastCellNum();
		for (int indiceColuna = 0; indiceColuna < cellcount; indiceColuna++) {
			String atributo = getValorDaCelulaDoArquivo(0, indiceColuna);
			if (atributo.equalsIgnoreCase(nomeDaColuna)) {
				return indiceColuna;
			}
		}
		throw new ArgumentoinvalidoException(nomeDaColuna);
	}

	public String getValorDaCelulaDoArquivo(int iNumeroDaLinha, int iNumeroDaCelula) {
		try {
			setArquivoExcel(nomeDaPlanilha);
			if (folha.getRow(iNumeroDaLinha).getCell(iNumeroDaCelula) != null) {
				celula = folha.getRow(iNumeroDaLinha).getCell(iNumeroDaCelula);
				return celula.getStringCellValue();
			}
		} catch (Exception e) {
			try {
				pastaDeTrabalho.close();
			} catch (IOException e1) {
				e1.printStackTrace();
				System.out.println("Erro ao fechar o excel");
			}
		}
		return "esta célula está vazia";
	}

	public String buscarValorNaPlanilha(String nomeDaPlanilha, String id, String nomeDaColuna)
			throws NullArgumentException {
		this.nomeDaPlanilha = nomeDaPlanilha;
		setArquivoExcel(this.nomeDaPlanilha);
		int col = encontrarColuna(nomeDaColuna);
		String dadoProcurado = id;
		String dadoEncontrado = "";
		int indiceId = 0;
		for (; indiceId <= getTotalLinhasFolha(); indiceId++) {
			dadoEncontrado = getValorDaCelulaDoArquivo(indiceId, 0);
			if (dadoEncontrado.equalsIgnoreCase(dadoProcurado)) {
				return getValorDaCelulaDoArquivo(indiceId, col);
			}
		}
		throw new NullArgumentException();
	}

	public int getTotalLinhasFolha() {
		setArquivoExcel(nomeDaPlanilha);
		int totalDeLinhas = folha.getLastRowNum() - folha.getFirstRowNum();
		return totalDeLinhas;
	}

}