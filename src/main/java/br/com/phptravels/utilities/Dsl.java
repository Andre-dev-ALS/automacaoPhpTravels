package br.com.phptravels.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.com.phptravels.managers.WebDriverManager;

public class Dsl {

	/********* TextField e TextArea ************/

	public void escrever(WebElement elemento, String texto) {
		Espera.esperarElementoSerVisivel(elemento);
		elemento.clear();
		elemento.sendKeys(texto);
	}

	/********* Radio e Check ************/

	public void clicarRadio(WebElement elemento) {
		Espera.esperarBotaoSerClicado(elemento);
		elemento.click();
	}

	public void clicarCheck(WebElement elemento) {
		Espera.esperarBotaoSerClicado(elemento);
		elemento.click();
	}

// caixa de seleção 

	public void selecionar(WebElement elemento, String valor) {
		Espera.esperarElementoSerVisivel(elemento);
		Select selecao = new Select(elemento);
		selecao.selectByVisibleText(valor);
	}

	/********* Combo ************/

	public void selecionarCombo(WebElement elemento, String valor) {
		Espera.esperarElementoSerVisivel(elemento);
		Select combo = new Select(elemento);
		combo.selectByVisibleText(valor);
	}

	public void deselecionarCombo(WebElement elemento, String valor) {
		Select combo = new Select(elemento);
		combo.deselectByVisibleText(valor);
	}

	public String obterValorCombo(WebElement elemento) {
		Select combo = new Select(elemento);
		return combo.getFirstSelectedOption().getText();
	}

	public List<String> obterValoresCombo(String id) {
		WebElement element = WebDriverManager.getDriver().findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for (WebElement opcao : allSelectedOptions) {
			valores.add(opcao.getText());
		}
		return valores;
	}

	public int obterQuantidadeOpcoesCombo(WebElement elemento) {
		Select combo = new Select(elemento);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}

	public boolean verificarOpcaoCombo(WebElement elemento, String opcao) {
		Select combo = new Select(elemento);
		List<WebElement> options = combo.getOptions();
		for (WebElement option : options) {
			if (option.getText().equals(opcao)) {
				return true;
			}
		}
		return false;
	}

	/********* Botao ************/

	public void clicarBotao(WebElement elemento) {
		Espera.esperarBotaoSerClicado(elemento);
		elemento.click();
	}

	public String obterValueElemento(WebElement elemento) {
		return elemento.getAttribute("value");
	}

	/********* Link ************/

	public void clicarLink(String link) {
		WebDriverManager.getDriver().findElement(By.linkText(link)).click();
	}

	/********* Alerts ************/

	public String alertaObterTexto() {
		Espera.esperarAlertaAparecer();

		Alert alert = WebDriverManager.getDriver().switchTo().alert();
		return alert.getText();
	}

	public String alertaObterTextoEAceita() {
		Espera.esperarAlertaAparecer();

		Alert alert = WebDriverManager.getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
	}

	public String alertaObterTextoENega() {
		Espera.esperarAlertaAparecer();
		Alert alert = WebDriverManager.getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;
	}

	public void alertaEscrever(String texto) {
		Espera.esperarAlertaAparecer();
		Alert alert = WebDriverManager.getDriver().switchTo().alert();
		alert.sendKeys(texto);
		alert.accept();
	}

	public void trocarJanela(int numeroJanela) {
		WebDriverManager.getDriver().switchTo()
				.window((String) WebDriverManager.getDriver().getWindowHandles().toArray()[numeroJanela]);
	}

	/************** JS *********************/

	public Object executarJS(String cmd, Object... param) {
		JavascriptExecutor js = (JavascriptExecutor) WebDriverManager.getDriver();
		return js.executeScript(cmd, param);
	}

	/************** Tabela *********************/

	public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		// procurar coluna do registro
		WebElement tabela = WebDriverManager.getDriver().findElement(By.xpath("//*[@id='" + idTabela + "']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);

		// encontrar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);

		// procurar coluna do botao
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);

		// clicar no botao da celula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr[" + idLinha + "]/td[" + idColunaBotao + "]"));
		return celula;
	}

	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTabela);
		celula.findElement(By.xpath(".//input")).click();

	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td[" + idColuna + "]"));
		int idLinha = -1;
		for (int i = 0; i < linhas.size(); i++) {
			if (linhas.get(i).getText().equals(valor)) {
				idLinha = i + 1;
				break;
			}
		}
		return idLinha;
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for (int i = 0; i < colunas.size(); i++) {
			if (colunas.get(i).getText().equals(coluna)) {
				idColuna = i + 1;
				break;
			}
		}
		return idColuna;
	}
}