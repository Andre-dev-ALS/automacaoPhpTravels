package br.com.phptravels.steps;

import br.com.phptravels.logic.HomePageLogic;
import br.com.phptravels.model.HomePageModel;
import br.com.phptravels.pages.PageObjectManager;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class DemonstracaoSiteStep {
	HomePageModel dadosPessoais;
	HomePageLogic home;

	@Dado("que estou na página inicial")
	public void que_estou_na_página_inicial() {
		PageObjectManager.getHomePage().navegarParaPaginaInicial();
	}

	@Quando("preencho o campo nome")
	public void preencho_o_campo_nome() {
		dadosPessoais = new HomePageModel();
		home = new HomePageLogic();

		home.preencherCampoNome(dadosPessoais.getNome());
	}

	@Quando("preencho o campo sobrenome")
	public void preencho_o_campo_sobrenome() {

		dadosPessoais = new HomePageModel();
		home = new HomePageLogic();
		home.preencherCampoSobrenome(dadosPessoais.getSobreNome());
	}

	@Quando("preencho o campo nome da empresa")
	public void preencho_o_campo_nome_da_empresa() {

		dadosPessoais = new HomePageModel();
		home = new HomePageLogic();
		home.preencherCampoNomeDaEmpresa(dadosPessoais.getNomeDaEmpresa());
	}

	@Quando("preencho o campo email")
	public void preencho_o_campo_email() {
		dadosPessoais = new HomePageModel();
		home = new HomePageLogic();
		home.preencherCampoEmail(dadosPessoais.getEmail());
	}

	@Quando("preencho o campo resultado")
	public void preencho_o_campo_resultado() {
		home = new HomePageLogic();
		home.preencherCampoResultado();
	}

	@Quando("clico no botão enviar")
	public void clico_no_botão_enviar() {
		home.clicarBotaoEnviar();
	}

	@Então("uma mensagem de envio bem sucedido é mostrada")
	public void uma_mensagem_de_envio_bem_sucedido_é_mostrada() {
		home.getMensagemSucesso();
	}

}
