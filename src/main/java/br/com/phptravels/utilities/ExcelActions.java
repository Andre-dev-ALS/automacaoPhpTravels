package br.com.phptravels.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.phptravels.managers.FileReaderManager;

public class ExcelActions {

	private static XSSFWorkbook pastaDeTrabalho;
	private static XSSFSheet folha;
	private static XSSFCell celula;
	private String nomeDaPlanilha = "";

	public void setArquivoExcel(String nomeDaPlanilha) {
		File arquivo = new File(FileReaderManager.getInstance().getConfigReader().getExcelPath());
		FileInputStream planilha = null;
		try {
			planilha = new FileInputStream(arquivo);
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrada.");
		}
		try {
			pastaDeTrabalho = new XSSFWorkbook(planilha);
		} catch (IOException e) {
			System.out.println("pasta de trabalho não encontrada.");
			e.printStackTrace();
		}
		folha = pastaDeTrabalho.getSheet(nomeDaPlanilha);
	}

	public int encontrarColuna(String nomeDaColuna) throws RuntimeException {

		int indiceColuna = 0;
		setArquivoExcel(nomeDaPlanilha);
		int cellcount = folha.getRow(0).getLastCellNum();
		for (; indiceColuna < cellcount; indiceColuna++) {
			if (getValorDaCelulaDoArquivo(0, indiceColuna).equalsIgnoreCase(nomeDaColuna)) {
				return indiceColuna;
			}

		}

		throw new RuntimeException("coluna não encontrada");
	}

	public String getValorDaCelulaDoArquivo(int iNumeroDaLinha, int iNumeroDaCelula) {
		String valorCelula = "";
		try {
			setArquivoExcel(nomeDaPlanilha);
			if (folha.getRow(iNumeroDaLinha).getCell(iNumeroDaCelula) != null) {
				celula = folha.getRow(iNumeroDaLinha).getCell(iNumeroDaCelula);
				valorCelula = celula.getStringCellValue();
				return valorCelula;
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

	public String buscarValorNaPlanilha(String nomeDaPlanilha, String id, String nomeDaColuna) {
		this.nomeDaPlanilha = nomeDaPlanilha;
		setArquivoExcel(this.nomeDaPlanilha);
		String dadoProcurado = id;
		String dadoEncontrado = "";
		int indiceId = 0;
		for (; indiceId < getTotalLinhasFolha(); indiceId++) {
			if (getValorDaCelulaDoArquivo(indiceId, 0).equalsIgnoreCase(dadoProcurado)) {
				dadoEncontrado = getValorDaCelulaDoArquivo(indiceId, encontrarColuna(nomeDaColuna));
			}
		}
		return dadoEncontrado;
	}

	public int getTotalLinhasFolha() {
		setArquivoExcel(nomeDaPlanilha);
		int totalDeLinhas = folha.getLastRowNum() - folha.getFirstRowNum();
		return totalDeLinhas;
	}

}