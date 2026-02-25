# 💱 Conversor de Moedas — Challenge ONE

Aplicação Java desenvolvida com foco em Programação Orientada a Objetos (POO), que realiza a conversão de moedas em tempo real por meio do consumo da API pública ExchangeRate API.

Este projeto foi desenvolvido como parte do Challenge do programa Oracle Next Education (ONE), com o objetivo de aplicar conceitos como consumo de API REST, organização em camadas, uso de ```record```, tratamento de exceções e boas práticas de código.

## 🚀 Funcionalidades
* Conversão entre moedas internacionais:
  * USD → ARS
  * ARS → USD
  * USD → BRL
  * BRL → COP
  * USD → COP
  * COP → USD
* Menu interativo via terminal
* Consumo de API externa com taxas de câmbio atualizadas
* Tratamento de erros e entradas inválidas
* Arquitetura organizada em Client, Service e Model

# 🧭 Como funciona?
Ao iniciar a aplicação, o usuário visualiza um menu no terminal, onde escolhe o tipo de conversão e informa o valor desejado.

**A aplicação:**
1. Consulta a ExchangeRate API
2. Converte o retorno JSON em objetos Java
3. Calcula o valor convertido
4. Exibe o resultado formatado no terminal

Exemplo do menu:

<img width="356" height="232" alt="Menu do conversor de moedas no terminal" src="https://github.com/user-attachments/assets/7e911849-63ac-4302-9157-9bca967f28b9" />

## 🏗️ Arquitetura do Projeto
```bash
src/
├── Client/
│   └── ClientMoeda.java
├── Model/
│   ├── Moeda.java
│   └── RecordMoeda.java
├── Service/
│   └── ServiceMoeda.java
└── Main.java
```
### 📌 **Responsabilidade das camadas**

Client: Responsável pela comunicação com a API externa.
  * Utiliza HttpClient (Java 11+)
  * Monta a URL com base na moeda escolhida
  * Retorna a resposta em formato JSON
```Java
https://v6.exchangerate-api.com/v6/{apiKey}/latest/{MOEDA}
```

Model: Representa os dados retornados pela API.
* RecordMoeda: Mapeia diretamente o JSON retornado
  * base_code
  * conversion_rates
* Moeda: Classe de domínio responsável por
  * Encapsular os dados do record
  * Buscar a taxa de conversão desejada
  * Validar se a moeda existe

Service: Camada de regras de negócio.
* Chama o ClientMoeda
* Converte JSON em objetos Java com Gson
* Calcula o valor convertido
* Centraliza o tratamento de exceções

## 🔄 Fluxo da Conversão
1. Usuário escolhe a opção no menu
2. Informa o valor a ser convertido
3. ServiceMoeda chama o ClientMoeda
4. A API retorna os dados em JSON
5. O JSON é convertido em RecordMoeda
6. A classe Moeda calcula a taxa
7. O resultado final é exibido no terminal

## ⚙️ Tecnologias Utilizadas

![Java](https://img.shields.io/badge/Java-17%2B-red.svg)
![HttpClient](https://img.shields.io/badge/HttpClient-Java%2011%2B-blue.svg)
![Gson](https://img.shields.io/badge/Gson-JSON-green.svg)
![ExchangeRate API](https://img.shields.io/badge/ExchangeRate-API-orange.svg)

## 🔐 Configuração da API (.env)
A chave da API é armazenada em uma variável de ambiente para maior segurança.

Exemplo de variável:
```bash
apiKey=SUA_CHAVE_AQUI
```
O arquivo .env está corretamente incluído no .gitignore.

## 🛠️ Tratamento de Erros
A aplicação trata:
* Entrada inválida do usuário (InputMismatchException)
* Moeda inexistente (IllegalArgumentException)
* Erros de comunicação com a API
* Falhas na conversão do JSON
* Erros inesperados em tempo de execução

## ▶️ Como executar o projeto

1. Clone o repositório
2. Abra o projeto em uma IDE Java
3. Configure a variável de ambiente apiKey (Caso seja no Intelliji, baixe a extensão **EnvFile** e configure com base nas instruções)
4. Execute a classe Main
5. Interaja pelo terminal 🎉
   
# Emblema do Challenge
<img width="150" height="150" alt="Badge-Conversor" src="https://github.com/user-attachments/assets/7aa8b7dd-db37-4c2f-96b2-1422d4313e8b" />

