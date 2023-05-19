$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/feature/demonstracaoSite.feature");
formatter.feature({
  "name": "demonstração do site php travels",
  "description": "como um usuário pretendo acessar o site e fazer uma solicitação de uma  demonstração bem sucedida",
  "keyword": "Funcionalidade"
});
formatter.scenario({
  "name": "Requisitar demonstração do site",
  "description": "",
  "keyword": "Cenário",
  "tags": [
    {
      "name": "@id_001"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que estou na página inicial",
  "keyword": "Dado "
});
formatter.match({
  "location": "DemonstracaoSiteStep.que_estou_na_página_inicial()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "preencho o campo nome",
  "keyword": "Quando "
});
formatter.match({
  "location": "DemonstracaoSiteStep.preencho_o_campo_nome()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "preencho o campo sobrenome",
  "keyword": "E "
});
formatter.match({
  "location": "DemonstracaoSiteStep.preencho_o_campo_sobrenome()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "preencho o campo nome da empresa",
  "keyword": "E "
});
formatter.match({
  "location": "DemonstracaoSiteStep.preencho_o_campo_nome_da_empresa()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "preencho o campo email",
  "keyword": "E "
});
formatter.match({
  "location": "DemonstracaoSiteStep.preencho_o_campo_email()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "preencho o campo resultado",
  "keyword": "Quando "
});
formatter.match({
  "location": "DemonstracaoSiteStep.preencho_o_campo_resultado()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico no botão enviar",
  "keyword": "E "
});
formatter.match({
  "location": "DemonstracaoSiteStep.clico_no_botão_enviar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "uma mensagem de envio bem sucedido é mostrada",
  "keyword": "Então "
});
formatter.match({
  "location": "DemonstracaoSiteStep.uma_mensagem_de_envio_bem_sucedido_é_mostrada()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});