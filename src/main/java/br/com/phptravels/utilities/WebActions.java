package br.com.phptravels.utilities;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebActions {
	private WebDriver driver;
	private WaitActions wait;

	public WebActions(WebDriver driver, WaitActions wait) {
		this.driver = driver;
		this.wait = wait;
	}

	/********* TextField e TextArea ************/

	public void escrever(WebElement elemento, String texto, int tempoDeEspera) {
		wait.waitForElementToBeVisible(elemento, tempoDeEspera);
		elemento.clear();
		elemento.sendKeys(texto);
	}

	public void escrever(WebElement elemento, String texto) {
		escrever(elemento, texto, WaitActions.STANDARD_TIME);
	}

	public void escrever(By by, String texto, int tempoDeEspera) {
		wait.waitForElementToBeVisible(by, tempoDeEspera);
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texto);
	}

	public void escrever(By by, String texto) {
		escrever(by, texto, WaitActions.STANDARD_TIME);
	}

	/********* Radio e Check ************/

	public void clicarRadio(WebElement elemento, int tempoDeEspera) {
		wait.waitButtonBeClickable(elemento, tempoDeEspera);
		elemento.click();
	}

	public void clicarRadio(WebElement element) {
		clicarRadio(element, WaitActions.STANDARD_TIME);
	}

	public void clicarRadio(By by, int tempoDeEspera) {
		wait.waitButtonBeClickable(by, tempoDeEspera);
		driver.findElement(by).click();
	}

	public void clicarRadio(By by) {
		clicarRadio(by, WaitActions.STANDARD_TIME);
	}

	public void clicarCheck(By by, int tempoDeEspera) {
		wait.waitButtonBeClickable(by, tempoDeEspera);
		driver.findElement(by).click();
	}

	public void clicarCheck(By by) {
		clicarCheck(by, WaitActions.STANDARD_TIME);
	}

// caixa de seleção 

	public void selecionar(WebElement elemento, String valor, int tempoDeEspera) {
		wait.waitForElementToBeVisible(elemento, tempoDeEspera);
		Select selecao = new Select(elemento);
		selecao.selectByVisibleText(valor);
	}

	public void selecionar(WebElement element, String valor) {
		selecionar(element, valor, WaitActions.STANDARD_TIME);
	}

	public void selecionar(By by, String valor, int tempoDeEspera) {
		wait.waitForElementToBeVisible(by, tempoDeEspera);
		WebElement element = driver.findElement(by);
		Select selecao = new Select(element);
		selecao.selectByVisibleText(valor);
	}

	public void selecionar(By by, String valor) {
		selecionar(by, valor, WaitActions.STANDARD_TIME);
	}

	/********* Combo ************/

	public void selecionarCombo(WebElement elemento, String valor, int tempoDeEspera) {
		wait.waitForElementToBeVisible(elemento, tempoDeEspera);
		Select combo = new Select(elemento);
		combo.selectByVisibleText(valor);
	}

	public void selecionarCombo(WebElement elemento, String valor) {
		selecionarCombo(elemento, valor, WaitActions.STANDARD_TIME);
	}

	public void deselecionarCombo(WebElement elemento, String valor, int tempoDeEspera) {
		wait.waitForElementToBeVisible(elemento, tempoDeEspera);
		Select combo = new Select(elemento);
		combo.deselectByVisibleText(valor);
	}

	public void deselecionarCombo(WebElement elemento, String valor) {
		deselecionarCombo(elemento, valor, WaitActions.STANDARD_TIME);
	}

	public String obterValorCombo(WebElement elemento, int tempoDeEspera) {
		wait.waitForElementToBeVisible(elemento, tempoDeEspera);
		Select combo = new Select(elemento);
		return combo.getFirstSelectedOption().getText();
	}

	public String obterValorCombo(WebElement elemento) {
		return obterValorCombo(elemento, WaitActions.STANDARD_TIME);
	}

	public void selecionarCombo(By by, String valor, int tempoDeEspera) {
		wait.waitForElementToBeVisible(by, tempoDeEspera);
		WebElement element = driver.findElement(by);
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}

	public void selecionarCombo(By by, String valor) {
		selecionarCombo(by, valor, WaitActions.STANDARD_TIME);
	}

	public void deselecionarCombo(By by, String valor, int tempoDeEspera) {
		wait.waitForElementToBeVisible(by, tempoDeEspera);
		WebElement element = driver.findElement(by);
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}

	public void deselecionarCombo(By by, String valor) {
		deselecionarCombo(by, valor, WaitActions.STANDARD_TIME);
	}

	public String obterValorCombo(By by, int tempoDeEspera) {
		wait.waitForElementToBeVisible(by, tempoDeEspera);
		WebElement element = driver.findElement(by);
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}

	public String obterValorCombo(By by) {
		return obterValorCombo(by, WaitActions.STANDARD_TIME);
	}

	/********* Botao ************/

	public void clicarBotao(WebElement elemento, int tempoDeEspera) {
		wait.waitButtonBeClickable(elemento, tempoDeEspera);
		elemento.click();
	}

	public void clicarBotao(WebElement elemento) {
		clicarBotao(elemento, WaitActions.STANDARD_TIME);
	}

	public String obterValueElemento(WebElement elemento, int tempoDeEspera) {
		wait.waitButtonBeClickable(elemento, tempoDeEspera);
		return elemento.getAttribute("value");
	}

	public String obterValueElemento(WebElement elemento) {
		return obterValueElemento(elemento, WaitActions.STANDARD_TIME);
	}

	public void clicarBotao(By by, int tempoDeEspera) {
		wait.waitButtonBeClickable(by, tempoDeEspera);
		WebElement element = driver.findElement(by);
		element.click();
	}

	public void clicarBotao(By by) {
		clicarBotao(by, WaitActions.STANDARD_TIME);
	}

	public String obterValueElemento(By by, int tempoDeEspera) {
		wait.waitButtonBeClickable(by, tempoDeEspera);
		WebElement element = driver.findElement(by);
		return element.getAttribute("value");
	}

	public String obterValueElemento(By by) {
		return obterValueElemento(by, WaitActions.STANDARD_TIME);
	}

	/********* Link ************/

	public void clicarLink(String link) {
		driver.findElement(By.linkText(link)).click();
	}

	public void clicarLink(By by, int waitingTime) {
		WebElement element = driver.findElement(by);
		wait.waitForElementToBeVisible(by, waitingTime);
		element.click();
	}

	public void clicarLink(By by) {

		clicarLink(by, WaitActions.STANDARD_TIME);
	}

	/********* Alerts ************/

	public String alertaObterTexto(int tempoDeEspera) {
		wait.waitTheAlertAppear(tempoDeEspera);
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public String alertaObterTexto() {
		return alertaObterTexto(WaitActions.STANDARD_TIME);
	}

	public String alertaObterTextoEAceita(int tempoDeEspera) {
		wait.waitTheAlertAppear(tempoDeEspera);
		Alert alert = driver.switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
	}

	public String alertaObterTextoEAceita() {
		return alertaObterTextoEAceita(WaitActions.STANDARD_TIME);
	}

	public String alertaObterTextoENega(int tempoDeEspera) {
		wait.waitTheAlertAppear(tempoDeEspera);
		Alert alert = driver.switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;
	}

	public String alertaObterTextoENega() {
		return alertaObterTextoENega(WaitActions.STANDARD_TIME);
	}

	public void alertaEscrever(String texto, int tempoDeEspera) {
		wait.waitTheAlertAppear(tempoDeEspera);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(texto);
		alert.accept();
	}

	public void alertaEscrever(String texto) {
		alertaEscrever(texto, WaitActions.STANDARD_TIME);
	}

	public void trocarJanela(int numeroJanela) {
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[numeroJanela]);
	}

	/************** JS *********************/

	public Object executarJS(String cmd, Object... param) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(cmd, param);
	}

	/************** Tabela *********************/

	public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		// procurar coluna do registro
		WebElement tabela = driver.findElement(By.xpath("//*[@id='" + idTabela + "']"));
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