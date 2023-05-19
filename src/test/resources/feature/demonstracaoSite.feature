 #language: pt
 
Funcionalidade: demonstração do site php travels 


como um usuário pretendo acessar o site e fazer uma solicitação de uma  demonstração bem sucedida
@id_001 
 Cenário: Requisitar demonstração do site
 Dado que estou na página inicial
Quando preencho o campo nome
E preencho o campo sobrenome
E preencho o campo nome da empresa
E preencho o campo email
Quando preencho o campo resultado  
E clico no botão enviar
Então uma mensagem de envio bem sucedido é mostrada  