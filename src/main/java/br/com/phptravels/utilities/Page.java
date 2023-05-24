package br.com.phptravels.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.com.phptravels.managers.WebDriverManager;

public class Page {

	/********* TextField e TextArea ************/

	public void escrever(WebElement elemento, String texto) {
		elemento.clear();
		elemento.sendKeys(texto);
	}

	public String obterValorCampo(String id_campo) {
		return WebDriverManager.getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}

	/********* Radio e Check ************/

	public void clicarRadio(By by) {
		WebDriverManager.getDriver().findElement(by).click();
	}

	public void clicarRadio(String id) {
		clicarRadio(By.id(id));
	}

	public boolean isRadioMarcado(String id) {
		return WebDriverManager.getDriver().findElement(By.id(id)).isSelected();
	}

	public void clicarCheck(By by) {

		WebDriverManager.getDriver().findElement(by).click();
	}

	public void clicarCheck(String id) {
		WebDriverManager.getDriver().findElement(By.id(id)).click();
	}

	public boolean isCheckMarcado(String id) {
		return WebDriverManager.getDriver().findElement(By.id(id)).isSelected();
	}

// caixa de seleção 

	public void selecionar(By by, String valor) {
		WebElement elemento = WebDriverManager.getDriver().findElement(by);
		Select selecao = new Select(elemento);
		selecao.selectByVisibleText(valor);
	}

	/********* Combo ************/

	public void selecionarCombo(String id, String valor) {
		WebElement element = WebDriverManager.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}

	public void deselecionarCombo(String id, String valor) {
		WebElement element = WebDriverManager.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}

	public String obterValorCombo(String id) {
		WebElement element = WebDriverManager.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
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

	public int obterQuantidadeOpcoesCombo(String id) {
		WebElement element = WebDriverManager.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}

	public boolean verificarOpcaoCombo(String id, String opcao) {
		WebElement element = WebDriverManager.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for (WebElement option : options) {
			if (option.getText().equals(opcao)) {
				return true;
			}
		}
		return false;
	}

	public void selecionarComboPrime(String radical, String valor) {
		clicarRadio(By.xpath("//*[@id='" + radical + "_input']/../..//span"));
		clicarRadio(By.xpath("//*[@id='" + radical + "_items']//li[.='" + valor + "']"));
	}

	/********* Botao ************/

	public void clicarBotao(WebElement elemento) {
		elemento.click();
	}

	public String obterValueElemento(String id) {
		return WebDriverManager.getDriver().findElement(By.id(id)).getAttribute("value");
	}

	/********* Link ************/

	public void clicarLink(String link) {
		WebDriverManager.getDriver().findElement(By.linkText(link)).click();
	}

	/********* Textos ************/

	public String obterTexto(By by) {
		return WebDriverManager.getDriver().findElement(by).getText();
	}

	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}

	/********* Alerts ************/

	public String alertaObterTexto() {
		Alert alert = WebDriverManager.getDriver().switchTo().alert();
		return alert.getText();
	}

	public String alertaObterTextoEAceita() {
		Alert alert = WebDriverManager.getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;

	}

	public String alertaObterTextoENega() {
		Alert alert = WebDriverManager.getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();

		return valor;

	}

	public void alertaEscrever(String valor) {
		Alert alert = WebDriverManager.getDriver().switchTo().alert();
		alert.sendKeys(valor);
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
