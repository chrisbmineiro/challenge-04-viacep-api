
# Consulta de CEPs e Geração de JSON

Este programa em Java permite que o usuário insira múltiplos CEPs, obtenha as informações de endereço correspondentes via a API ViaCEP e gere um arquivo JSON contendo todos os endereços consultados.

## Estrutura do Projeto

- **main/Main.java**: Ponto de entrada do programa. Solicita que o usuário insira múltiplos CEPs. As informações de endereço são armazenadas em uma lista e, ao final, é gerado um arquivo JSON com todos os dados.
- **modelos/ConsultarCEP.java**: Classe responsável por realizar a consulta do CEP via API ViaCEP e retornar as informações em um objeto `Endereco`.
- **modelos/Endereco.java**: Classe que representa o endereço retornado pela consulta, com atributos como CEP, logradouro, bairro, localidade e UF.
- **modelos/GeradorJson.java**: Classe responsável por converter a lista de endereços em um arquivo JSON.

## Como Funciona

1. O programa solicita ao usuário que insira um CEP ou digite "sair" para encerrar.
2. Cada CEP é consultado usando a API ViaCEP e as informações retornadas são armazenadas em uma lista.
3. Ao final, o programa gera um arquivo `enderecos.json` contendo todos os endereços consultados.

## Exemplo de Uso

```bash
Digite o CEP, ou 'sair' para finalizar: 01001000
CEP: 01001-000, Logradouro: Praça da Sé, Bairro: Sé, Cidade: São Paulo, UF: SP

Digite o CEP, ou 'sair' para finalizar: 20040002
CEP: 20040-002, Logradouro: Rua da Quitanda, Bairro: Centro, Cidade: Rio de Janeiro, UF: RJ

Digite o CEP, ou 'sair' para finalizar: sair
Arquivo JSON gerado com sucesso!
```

## Requisitos

- Java 11 ou superior
- Biblioteca [Gson](https://github.com/google/gson) para serialização de objetos Java para JSON

## Como Executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/projeto-ceps.git
   ```

2. Compile e execute o programa:
   ```bash
   javac -d bin src/main/*.java src/modelos/*.java
   java -cp bin principal.Main
   ```

3. Insira os CEPs conforme solicitado e ao final o arquivo `enderecos.json` será gerado no diretório principal.
