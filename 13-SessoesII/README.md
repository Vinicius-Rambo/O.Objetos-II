# Projeto: Persistência Lab 

Sistema web desenvolvido com Spring Boot para fins educacionais, com foco em persistência de dados, autenticação, MVC e integração com banco de dados.

## 📚 Objetivo

Este projeto foi criado para auxiliar no aprendizado de:

- Spring Boot
- Spring MVC
- Spring Data JPA
- Persistência de dados
- Thymeleaf
- Autenticação
- Sessões
- Criptografia de senhas com BCrypt
- Arquitetura em camadas

---

## 🚀 Tecnologias utilizadas

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Thymeleaf
- Maven
- MySQL (ou H2, dependendo da configuração)
- HTML/CSS
- BCrypt Password Encoder

---

## 📂 Estrutura do projeto

```text
src/
 ├── main/
 │   ├── java/
 │   │   └── com.example.persistencia_lab/
 │   │        ├── controllers/
 │   │        ├── models/
 │   │        ├── repositories/
 │   │        ├── services/
 │   │        └── PersistenciaLabApplication.java
 │   │
 │   └── resources/
 │        ├── templates/
 │        ├── static/
 │        └── application.properties
```

---

## ⚙️ Funcionalidades

- Cadastro de usuários/professores
- Login de usuários
- Criptografia de senha
- Controle de sessão
- Persistência em banco de dados
- Validação de autenticação
- Redirecionamentos com mensagens
- CRUD de entidades

---

## 🔐 Autenticação

As senhas são armazenadas utilizando BCrypt:

```java
PasswordEncoder encoder = new BCryptPasswordEncoder();
```

A validação é realizada com:

```java
encoder.matches(senhaDigitada, senhaCriptografada);
```

---

## ▶️ Como executar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/Web3-2026/persistencia_lab_projeto.git
```

---

### 2. Abrir no VSCode ou IntelliJ

Recomenda-se instalar:

- Extension Pack for Java
- Spring Boot Tools

---

### 3. Configurar o banco de dados

Edite o arquivo:

```text
src/main/resources/application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/persistencia_lab
spring.datasource.username=root
spring.datasource.password=senha

spring.jpa.hibernate.ddl-auto=update
```

---

### 4. Executar o projeto

Via Maven:

```bash
./mvnw spring-boot:run
```

Ou executando a classe:

```java
PersistenciaLabApplication
```

---

## 🌐 Rotas principais

| Método | Rota | Descrição |
|---|---|---|
| GET | /login | Tela de login |
| POST | /logar | Realiza autenticação |
| GET | /professores | Lista professores |
| GET | /professores/novo | Formulário de cadastro |
| POST | /professores/salvar | Salva professor |

---

## 🧠 Conceitos abordados

- MVC
- Repository Pattern
- EntityManager
- Sessões HTTP
- Cookies
- RedirectAttributes
- Hash de senhas
- Injeção de dependência
- Beans do Spring
- ORM com JPA/Hibernate

---

## 📸 Screenshots

Adicione aqui imagens do sistema:

```text
docs/images/login.png
docs/images/dashboard.png
```

---

## 🛠️ Melhorias futuras

- Spring Security
- Controle de permissões
- Testes automatizados
- API REST
- Docker
- Deploy em nuvem
- Paginação
- Upload de imagens

---

## 👨‍🏫 Finalidade acadêmica

Projeto desenvolvido com fins educacionais para estudos de persistência de dados e desenvolvimento web com Java/Spring.

---

## 📄 Licença

Este projeto é destinado para uso acadêmico e educacional.
