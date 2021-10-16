![POD](https://img.shields.io/badge/version-v1.0.0-green.svg) ![POD](https://img.shields.io/badge/language-Java-green.svg) 

# Validar Senha - REST API

O serviçoi foi criado para realizar a validação lógica de um senha enviada através de requisição POST na aplicação. 
Para que uma senha seja válida, os seguintes requisitos devem ser atendidos:
- Nove ou mais caracteres
- Ao menos 1 dígito
- Ao menos 1 letra minúscula
- Ao menos 1 letra maiúscula
- Ao menos 1 caractere especial
    - Considere como especial os seguintes caracteres: !@#$%^&*()-+
- Não possuir caracteres repetidos dentro do conjunto

Exemplo:

```c#
IsValid("") // false  
IsValid("aa") // false  
IsValid("ab") // false  
IsValid("AAAbbbCc") // false  
IsValid("AbTp9!foo") // false  
IsValid("AbTp9!foA") // false
IsValid("AbTp9 fok") // false
IsValid("AbTp9!fok") // true
```

> **_Nota:_**  Espaços em branco não devem ser considerados como caracteres válidos.

## Problema

Construa uma aplicação que exponha uma api web que valide se uma senha é válida.

Input: Uma senha (string).  
Output: Um boolean indicando se a senha é válida.

Embora nossas aplicações sejam escritas em Kotlin e C# (.net core), você não precisa escrever sua solução usando elas. Use a linguagem de programação que considera ter mais conhecimento.


## Tecnologias Utilizadas
- Para esse projeto, a seguinte stack foi escolhida:
  - Java 11;
  - SpringBoot 2.5.5;
  - Swagger Docs 3.0.0
  - Maven 3;

## Compilando a aplicação

Para compilar a aplicação, utilize a sua IDE de preferẽncia ou execute o seguinte comando no terminal/cmd:
```bash
mvn clean install 
```

## Executando a aplicação

Para executar a aplicação, execute na sua IDE de preferência a classe `com/soave/backendchallenge/BackendChallengeApplication.java`
ou no seu terminal/cmd, execute o seguinte comando (na pasta da aplicação):
```bash
mvn spring-boot:run 
```

A aplicação irá subir localmente e estará exposta na porta 8080, que é a padrão utilizada pelo TomCat embarcado.

![](https://i.ibb.co/pPNbkxq/spring-running.png)

## Utilizando a aplicação

Existem várias formas de se validar a senha utilizando a aplicação, como o cURL, Swagger ou até mesmo criando uma collection
postman com as requisições. Irei abordar as duas primeiras citadas

### Via Swagger:
Acesse o Swagger disponibilizado através da URL http://localhost:8080/swagger-ui/
A definição atual é a V1, já pensando em uma evolução de aplicação aplicada a versionamento de API. 

![](https://i.ibb.co/MpjqmLq/swagger-01.png)

Selecione a Controller _Valida Senha Controller_ recurso POST _/v1/validacoes/validacao_, clique em _try it out_ e preencha o
body da requisição de acordo com o modelo apresentado:
![](https://i.ibb.co/6RfFZ2y/swagger-02.png)

Ao clicar em *Execute* a requisição será realizada e a resposta booleana será obtida:
![](https://i.ibb.co/9rLds02/swagger-03.png)

### Via cURL:
Para executar dessa forma, você precisa ter o cURL instalado no seu dispositivo. Você pode [consultar a documentação ](https://curl.se/)
e realizar a instalação. 

Com a aplicação em execução, abra uma instancia do terminal/cmd e execute o seguinte comando:
```bash
curl -X POST "http://localhost:8080/v1/validacoes/validacao" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"senha\": \"&CaracaQueSenhaForte6578&\"}" 
```

Você irá receber a resposta no seu terminal:
![](https://i.ibb.co/0q549bM/curl.png)


## Escolha de tecnologia e método de desenvolvimento:
A linguagem escolhida foi o Java principalmente por ser a linguagem que eu possuo maior dominio e me sinto confortável em codificar.
A documentação de API construída com swagger permite que, durante o processo de concepção da API o desenvolvedor já codifique os 
recursos documentando corretamente todos os pontos que fazem parte da implementação, desde detalhes como descrição, contato, versão, até
pontos importantes para implementação de quem vai consumir essa API como Http Response Codes, Content-types aceitos, verbos que 
devem ser utilizados, eventual autenticação e modelos de contratos de request/response;

Para o código no geral, a metodologia escolhida foi o TDD, principalmente para garantir que todos os cenários fossem atingidos.
Escrevendo inicialmente os testes e sabendo quais situações o seu código deve atender, fica muito mais fácil de chegar ao resultado
esperado com qualidade e segurança de que seu código não irá levar um bug ao ambiente produtivo. Também torna mais produtivo
o processo de se atingir uma cobertura de testes que seja compatível com a complexidade do projeto:
![](https://i.ibb.co/kD8cRRz/code-coverage.png)

Foquei em deixar a classe Senha (_com/soave/backendchallenge/domain/model/Senha.java_) o mais coesa e responsável o possível, senhdo
a classe responsável por criar, manipular e validar as senhas que chegam;
Para evitar que apenas uma classe tenha N responsabilidades, criei uma classe para Request e outra para Response.

Toda a documentação swagger da Controller é feita da Interface que é implementada, tornando o código mais limpo e garantindo que
a controller implemente corretamente os métodos e seus respectivos verbos, entradas e saídas;

Independente do resultado, aguardo o feedback do time. 

Obrigado pela oportunidade.