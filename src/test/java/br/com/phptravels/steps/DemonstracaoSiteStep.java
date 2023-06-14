package br.com.phptravels.steps;

import br.com.phptravels.logic.HomePageLogic;
import br.com.phptravels.model.HomePageModel;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class DemonstracaoSiteStep {
	private HomePageModel dadosPessoais;
	private HomePageLogic home;

	@Dado("que estou na página inicial")
	public void queEstouNaPáginaInicial() {
		dadosPessoais = new HomePageModel();
		home = new HomePageLogic();
		home.navegarParaPaginaInicial();
	}

	@Quando("preencho o campo nome")
	public void preenchoOCampoNome() {
		dadosPessoais = new HomePageModel();
		home = new HomePageLogic();
		home.preencherCampoNome(dadosPessoais.getNome());
	}

	@Quando("preencho o campo sobrenome")
	public void preenchoOCampoSobrenome() {
		dadosPessoais = new HomePageModel();
		home = new HomePageLogic();
		home.preencherCampoSobrenome(dadosPessoais.getSobreNome());
	}

	@Quando("preencho o campo nome da empresa")
	public void preenchoOCampoNomeDaEmpresa() {
		dadosPessoais = new HomePageModel();
		home = new HomePageLogic();
		home.preencherCampoNomeDaEmpresa(dadosPessoais.getNomeDaEmpresa());
	}

	@Quando("preencho o campo email")
	public void preenchoOCampoEmail() {
		dadosPessoais = new HomePageModel();
		home = new HomePageLogic();
		home.preencherCampoEmail(dadosPessoais.getEmail());

	}

	@Quando("preencho o campo resultado")
	public void preenchoOCampoResultado() {
		home = new HomePageLogic();
		home.preencherCampoResultado();
	}

	@Quando("clico no botão enviar")
	public void clicoNoBotãoEnviar() {
		home = new HomePageLogic();
		home.clicarBotaoEnviar();
	}

	@Então("uma mensagem de envio bem sucedido é mostrada")
	public void umaMensagemDeEnvioBemSucedidoÉMostrada() {
		home = new HomePageLogic();
		home.getMensagemSucesso();
	}

}