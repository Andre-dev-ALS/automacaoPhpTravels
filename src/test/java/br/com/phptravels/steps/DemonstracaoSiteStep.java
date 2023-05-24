package br.com.phptravels.steps;

import br.com.phptravels.logic.DemonstracaoLogic;
import br.com.phptravels.managers.PageObjectManager;
import br.com.phptravels.model.HomePageModel;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class DemonstracaoSiteStep {
	HomePageModel dadosPessoais = new HomePageModel();
	DemonstracaoLogic resultadoConta;

	@Dado("que estou na página inicial")
	public void que_estou_na_página_inicial() {

		PageObjectManager.getHomePage().navegarParaPaginaInicial();
	}

	@Quando("preencho o campo nome")
	public void preencho_o_campo_nome() {
		PageObjectManager.getHomePage().preencherCampoNome(dadosPessoais.getNome());
	}

	@Quando("preencho o campo sobrenome")
	public void preencho_o_campo_sobrenome() {
		PageObjectManager.getHomePage().preencherCampoSobrenome(dadosPessoais.getSobreNome());
	}

	@Quando("preencho o campo nome da empresa")
	public void preencho_o_campo_nome_da_empresa() {
		PageObjectManager.getHomePage().preencherCampoNomeDaEmpresa(dadosPessoais.getNomeDaEmpresa());
	}

	@Quando("preencho o campo email")
	public void preencho_o_campo_email() {
		PageObjectManager.getHomePage().preencherCampoEmail(dadosPessoais.getEmail());
	}

	@Quando("preencho o campo resultado")
	public void preencho_o_campo_resultado() {
		resultadoConta = new DemonstracaoLogic();
		PageObjectManager.getHomePage().preencherCampoResultado(resultadoConta.calcular());
	}

	@Quando("clico no botão enviar")
	public void clico_no_botão_enviar() {
		PageObjectManager.getHomePage().clicarBotaoEnviar();
	}

	@Então("uma mensagem de envio bem sucedido é mostrada")
	public void uma_mensagem_de_envio_bem_sucedido_é_mostrada() {
		// PageObjectManager.getHomePage().getMensagemSucesso();
	}

}
