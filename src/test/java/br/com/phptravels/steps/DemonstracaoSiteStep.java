package br.com.phptravels.steps;

import br.com.phptravels.managers.PageObjectManager;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class DemonstracaoSiteStep {

	@Dado("que estou na página inicial")
	public void que_estou_na_página_inicial() {
		PageObjectManager.getHomePage().navegarParaPaginaInicial();
	}

	@Quando("preencho o campo nome")
	public void preencho_o_campo_nome() {

	}

	@Quando("preencho o campo sobrenome")
	public void preencho_o_campo_sobrenome() {

	}

	@Quando("preencho o campo nome da empresa")
	public void preencho_o_campo_nome_da_empresa() {

	}

	@Quando("preencho o campo email")
	public void preencho_o_campo_email() {

	}

	@Quando("preencho o campo resultado")
	public void preencho_o_campo_resultado() {

	}

	@Quando("clico no botão enviar")
	public void clico_no_botão_enviar() {

	}

	@Então("uma mensagem de envio bem sucedido é mostrada")
	public void uma_mensagem_de_envio_bem_sucedido_é_mostrada() {

	}

}
