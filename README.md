# Spring Boot 2026 REST API's do 0 à AWS e GCP c Java e Docker 🍃🐳

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
![AWS](https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white)

Este repositório contém o código desenvolvido durante o curso **"Spring Boot 2026 REST API's do 0 à AWS e GCP c Java e Docker"**, ministrado pelo professor Leandro Costa na Udemy.

O objetivo do projeto é construir uma API robusta, escalável e documentada, cobrindo desde os conceitos básicos de REST até o deploy em nuvem (AWS) utilizando containers.

## 🚀 Funcionalidades e Tópicos Abordados

O projeto evolui gradativamente implementando as seguintes features:

* **CRUD Completo**: Criação, Leitura, Atualização e Deleção de recursos (Person, Books).
* **Padrão VO (Value Object)**: Utilização de Dozer/ModelMapper para conversão de Entidades.
* **Versionamento de API**: Controle de versões de endpoints.
* **Banco de Dados e Migrations**: Persistência com MySQL e versionamento de banco com **Flyway**.
* **Content Negotiation**: Suporte a JSON, XML e YAML.
* **HATEOAS**: Adição de links hipermídia para navegabilidade da API.
* **Documentação**: Integração com **Swagger / OpenAPI** (SpringDoc).
* **Testes**: Testes Unitários e de Integração com JUnit 5, Mockito e Testcontainers.
* **Segurança**: Autenticação e Autorização com **Spring Security** e **JWT** (JSON Web Tokens).
* **Containerização**: Criação de imagens e orquestração com Docker e Docker Compose.
* **CI/CD**: Integração Contínua e Deploy Contínuo via Github Actions (Deploy na AWS).

## 🛠️ Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3.4.0**
* **Maven**
* **JPA / Hibernate**
* **MySQL**
* **Flyway Migration**
* **JUnit 5 / Mockito / REST Assured**
* **Docker**

## 📦 Como executar o projeto

### Pré-requisitos

* Java JDK 21.
* Maven instalado.
* MySQL instalado (ou Docker para rodar o banco).
* Git instalado.

### Passo a passo

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/brunosgs/spring-boot-erudio-training.git
    ```

2.  **Configuração do Banco de Dados:**
    * Crie um banco de dados no MySQL chamado `rest_with_spring_boot_erudio` (ou conforme configurado no `application.yml`).
    * Verifique as credenciais (`username` e `password`) no arquivo `src/main/resources/application.yml`.

3.  **Execute as Migrations e a Aplicação:**
    ```bash
    mvn spring-boot:run
    ```

4.  **Acesse a Documentação (Swagger):**
    Após a aplicação iniciar, acesse no seu navegador:
    ```
    http://localhost:8080/swagger-ui/index.html
    ```

## 🐳 Executando com Docker

Caso o projeto já tenha o `Dockerfile` e `docker-compose.yml` configurados:

```bash
docker-compose up --build -d