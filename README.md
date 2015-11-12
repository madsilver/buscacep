# BuscaCep
Serviço de busca de endereço

# BuscaCep
BuscaCep é um webservice para consultar Códigos de Endereçamento Postal (CEP) do Brasil. O serviço recebe uma requisição com um objeto json que informa um cep e retorna um objeto json com dados do endereço.

Ao depositar o projeto no servidor é possível acessar um template no link http://localhost:8080/buscacep/

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

