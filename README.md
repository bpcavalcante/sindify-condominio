# Sindify

## Visão Geral

O **Sindify** é um sistema de gestão para síndicos, criado para facilitar o gerenciamento de condomínios. Este projeto está desenvolvido em Java 17 e segue a arquitetura MVC em camadas.

## Requisitos

Antes de iniciar, certifique-se de ter os seguintes requisitos atendidos:

- **Java 17**: O projeto utiliza o Java 17. Certifique-se de que sua IDE está configurada com o Java 17.
- **Maven**: Usado para gerenciar dependências e construir o projeto.

## Passos para Configuração

1. **Clone o Repositório:**

   Abra o terminal e clone o repositório usando o comando:

   ```bash
   git clone https://github.com/bpcavalcante/sindify-condominio.git

2. **Acesse a Branch Develop:**

   Depois de clonar o repositório, navegue até o diretório do projeto e altere para a branch develop:

   ```bash
   cd sindify-condominio
   git checkout develop

3. **Importe o Projeto na IDE:**

- Abra sua IDE preferida (por exemplo, IntelliJ IDEA ou Eclipse).
- Certifique-se de que o **Java 17** está configurado como JDK.
- Importe o projeto como um projeto Maven existente.

4. **Construir o Projeto:**

   No terminal, dentro do diretório do projeto, execute o comando Maven para construir o projeto, ou em algumas IDE já constroem automaticamente:

   ```bash
   mvn clean install

5. **Executar o Projeto:**
   Depois de construir o projeto, você pode executá-lo diretamente na IDE ou via linha de comando:
   ```bash
   mvn spring-boot:run

  O servidor será iniciado na porta padrão **8080**

6. **Testando o Sistema:**
   Use os comandos curl abaixo para testar as funcionalidades do sistema:
   - **Listar Moradores**
     ```bash
     curl --request GET \
     --url http://localhost:8080/moradores \
     --header 'User-Agent: insomnia/9.3.3'
   - **Buscar Morador Por Nome**
     ```bash
     curl --request GET \
     --url 'http://localhost:8080/moradores?nome=Pericles' \
     --header 'User-Agent: insomnia/9.3.3'
   - **Buscar Morador por ID**
     ```bash
     curl --request GET \
     --url http://localhost:8080/moradores/2 \
     --header 'User-Agent: insomnia/9.3.3'
   - **Buscar Morador Por CPF**
     ```bash
     curl --request GET \
     --url 'http://localhost:8080/moradores?cpf=4' \
     --header 'User-Agent: insomnia/9.3.3'   
   - **Excluir Morador**
     ```bash
     curl --request DELETE \
     --url http://localhost:8080/moradores/1 \
     --header 'User-Agent: insomnia/9.3.3'
   - **Cadastrar Morador**
     ```bash
      curl --request POST \
        --url http://localhost:8080/moradores \
        --header 'Content-Type: application/json' \
        --header 'User-Agent: insomnia/9.3.3' \
        --data '{
        "nome": "Amanda Silva",
        "ddd": "21",
        "telefone": "912345678",
        "email": "maria.oliveira@example.com",
        "proprietario": false,
        "unidade": "Bloco B, Apt 302",
        "cpf": "43434103821",
        "dataNascimento": "1990-05-22"
      }'
   - **Atualizar Morador**
     ```bash
      curl --request PUT \
        --url http://localhost:8080/moradores/1 \
        --header 'Content-Type: application/json' \
        --header 'User-Agent: insomnia/9.3.3' \
        --data '{
        "nome": "Batata Silva",
        "ddd": "21",
        "telefone": "912345678",
        "email": "maria.oliveira@example.com",
        "proprietario": false,
        "unidade": "Bloco B, Apt 302",
        "cpf": "43434103821",
        "dataNascimento": "1990-05-22"
      }'     
