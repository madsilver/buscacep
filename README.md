# BuscaCep
Serviço de busca de endereço

# BuscaCep
BuscaCep é um webservice para consultar Códigos de Endereçamento Postal (CEP) do Brasil. O serviço recebe uma requisição com um objeto json que informa um cep e retorna um objeto json com dados do endereço.

Ao depositar o projeto no servidor é possível acessar um template no link http://localhost:8080/buscacep/

## Arquitetura

O projeto baseado no Maven foi desenhado no padrão MVC utilizando o framework Spring MVC. A estrutura inicial foi criada com a ferramenta Jboss Forge que criou o padrão de pastas e arquivos. Para o armazenamento de dados foi escolhido o MySQL e a persistência é feita através do framework hibernate.

A base de dados é muito simples e pode ser criada através do script:

CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `street` varchar(45) DEFAULT NULL,
  `number` varchar(45) DEFAULT NULL,
  `complement` varchar(45) DEFAULT NULL,
  `neighborhood` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zipcode` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
);



## Exemplos

## Acesso via Javascript

script src="http://localhost:8080/buscacep/findAddress?callback=functionCall" type="application/javascript"
functionCall(zipcode){
    console.log(zipcode.address);
}

## Acesso via Javascript (AJAX)

$.ajax({
    url:"http://localhost:8080/buscacep/findAddress",
    data:{"zipcode":zipcode},
    dataType:"json",
    success: function(address){
        console.log(address);
    }
});

