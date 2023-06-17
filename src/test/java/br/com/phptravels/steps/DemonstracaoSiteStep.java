package br.com.phptravels.steps;

import br.com.phptravels.logic.HomePageLogic;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class DemonstracaoSiteStep {
	private HomePageLogic home;

	public DemonstracaoSiteStep() {
		home = new HomePageLogic();
	}

	@Dado("que estou na página inicial")
	public void queEstouNaPáginaInicial() {
		home.navegarParaPaginaInicial();
	}

	@Quando("preencho o campo nome")
	public void preenchoOCampoNome() {
		home.preencherCampoNome();
	}

	@Quando("preencho o campo sobrenome")
	public void preenchoOCampoSobrenome() {
		home.preencherCampoSobrenome();
	}

	@Quando("preencho o campo nome da empresa")
	public void preenchoOCampoNomeDaEmpresa() {
		home.preencherCampoNomeDaEmpresa();
	}

	@Quando("preencho o campo email")
	public void preenchoOCampoEmail() {
		home.preencherCampoEmail();
	}

	@Quando("preencho o campo resultado")
	public void preenchoOCampoResultado() {
		home.preencherCampoResultado();
	}

	@Quando("clico no botão enviar")
	public void clicoNoBotãoEnviar() {
		home.clicarBotaoEnviar();
	}

	@Então("uma mensagem de envio bem sucedido é mostrada")
	public void umaMensagemDeEnvioBemSucedidoÉMostrada() {
		home.getMensagemSucesso();
	}

}