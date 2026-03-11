# 🚀 Selenium + Cucumber + MongoDB Automation Framework

![Java](https://img.shields.io/badge/Java-20-orange)
![Selenium](https://img.shields.io/badge/Selenium-4.x-green)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-brightgreen)
![MongoDB](https://img.shields.io/badge/MongoDB-Atlas-darkgreen)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![CI](https://img.shields.io/badge/CI-GitHub_Actions-black)
![Status](https://img.shields.io/badge/Status-Active-success)

Framework de automação de testes **End-to-End** desenvolvido em **Java + Selenium + Cucumber + MongoDB**, com geração dinâmica de dados, persistência de execução e integração completa com **GitHub Actions CI/CD**.

O projeto foi estruturado seguindo **boas práticas de automação e arquitetura escalável**, permitindo fácil manutenção, reutilização de código e execução isolada de testes através de **Execution IDs**.

---

# 📌 Objetivo

Automatizar fluxos reais de aplicação web utilizando:

- automação de interface com Selenium
- testes BDD com Cucumber
- geração dinâmica de dados com Faker
- persistência de dados em MongoDB
- execução automatizada em CI/CD

O framework foi projetado para suportar:

✔ execução paralela  
✔ isolamento de dados por execução  
✔ pipelines automatizadas  
✔ rastreabilidade de execuções  
✔ fácil escalabilidade de cenários  

---

# 🧠 Arquitetura do Framework

O projeto segue uma arquitetura em camadas baseada em **Page Object Model + Action Layer**.

```
src
 ├─ main
 │   └─ java
 │       └─ org.framework
 │           ├─ driver
 │           │   └─ DriverFactory
 │           │
 │           ├─ mongo
 │           │   ├─ MongoConnection
 │           │   └─ MongoUtils
 │           │
 │           └─ utils
 │               ├─ ElementUtils
 │               ├─ WaitUtils
 │               └─ FakerUtils
 │
 └─ test
     ├─ java
     │   ├─ pages
     │   │   ├─ LoginPage
     │   │   ├─ CadastroPage
     │   │   └─ PerfilPage
     │   │
     │   ├─ actions
     │   │   ├─ loginAction
     │   │   ├─ cadastroAction
     │   │   ├─ cadastroFlowAction
     │   │   └─ perfilAction
     │   │
     │   ├─ steps
     │   │   ├─ LoginSteps
     │   │   ├─ cadastroSteps
     │   │   └─ validacaoCadastroSteps
     │   │
     │   ├─ hooks
     │   │   └─ Hooks
     │   │
     │   └─ runners
     │       └─ TestRunner
     │
     └─ resources
         └─ features
             ├─ cadastro.feature
             └─ login.feature
```

---

# 🧩 Padrão de Camadas

## Pages
Responsáveis por armazenar **elementos e localizadores da interface**.

```
pages/
   LoginPage
   CadastroPage
   PerfilPage
```

---

## Actions

Camada responsável por executar **ações do usuário na interface**.

```
actions/
   loginAction
   cadastroAction
   cadastroFlowAction
   perfilAction
```

---

## Steps

Integração entre os cenários **Cucumber (BDD)** e as ações do framework.

```
steps/
   LoginSteps
   cadastroSteps
   validacaoCadastroSteps
```

---

## Utils

Componentes reutilizáveis utilizados em todo o framework.

```
utils/
   WaitUtils
   ElementUtils
   FakerUtils
```

---

## Mongo

Gerenciamento de conexão e persistência de dados de execução.

```
mongo/
   MongoConnection
   MongoUtils
```

---

# 🧪 Cenários Automatizados

## Cadastro de usuário

Fluxo automatizado:

1️⃣ Acessa o site  
2️⃣ Navega para criação de conta  
3️⃣ Gera dados com **Faker**  
4️⃣ Persiste dados no **MongoDB** usando **Execution ID**  
5️⃣ Cria conta na aplicação  
6️⃣ Valida retorno da API (`201 Created`)

---

## Validação do cadastro

Fluxo:

1️⃣ Recupera dados persistidos no Mongo  
2️⃣ Realiza login  
3️⃣ Acessa página de perfil  
4️⃣ Valida nome exibido na interface

---

# 🧬 Geração de Dados Dinâmicos

O framework utiliza **Java Faker** para geração automática de dados.

Exemplo:

```
Nome: João Silva
Email: joao123@email.com
Senha: gerada automaticamente
```

Esses dados são armazenados no MongoDB com base no **Execution ID** da execução.

---

# 🔑 Execution ID

Cada execução possui um identificador único.

Exemplo:

```
local-run-001
```

ou em CI/CD:

```
github-run-384839
```

Benefícios:

✔ evita conflito entre execuções  
✔ permite paralelismo  
✔ facilita rastreabilidade  

---

# 📊 Relatórios

Após cada execução são gerados:

```
target/
 ├─ cucumber-report.html
 ├─ screenshots
 │   ├─ sucesso.png
 │   └─ erro.png
 └─ logs
```

O framework captura automaticamente:

✔ screenshots de sucesso  
✔ screenshots de erro  
✔ logs detalhados  
✔ relatório de execução  

---

# 📸 Evidências de Teste

O framework captura evidências automaticamente ao final de cada cenário:

- screenshot em caso de sucesso
- screenshot em caso de falha
- anexação no relatório Cucumber

Essas evidências são utilizadas para auditoria e debugging das execuções.

---

# ⚙️ Execução Local

## Clonar repositório

```bash
git clone https://github.com/seu-repositorio.git
```

---

## Configurar variáveis de ambiente

Para executar localmente é necessário configurar:

```
MONGO_URI
MONGO_DB
```

---

## Executar testes

```
mvn clean test -DexecutionId=local-run-001
```

---

# 🖥 Execução Headless

Para execução em ambiente CI/CD:

```
mvn clean test -DexecutionId=ci-run -Dheadless=true
```

---

# 🔁 CI/CD Pipeline

O projeto possui integração com **GitHub Actions**.

Pipeline localizada em:

```
.github/workflows/selenium-tests.yml
```

Fluxo da pipeline:

1️⃣ checkout do repositório  
2️⃣ instalação do Java  
3️⃣ build Maven  
4️⃣ execução dos testes  
5️⃣ publicação de artefatos  

---

# 📦 Artefatos da Pipeline

Após execução é possível baixar:

```
screenshots/
cucumber-report.html
logs
```

diretamente da execução do GitHub Actions.

---

# 🔐 Segurança e Configuração de Banco

As credenciais do banco **não estão versionadas no repositório**.

As configurações são armazenadas em **GitHub Secrets**.

Secrets utilizados:

```
MONGO_URI
MONGO_DB
```

---

## Banco de dados

O banco utilizado nos testes está hospedado no **MongoDB Atlas (Cloud)**.

Ele permanece **online para execução das pipelines e testes automatizados**.

Por questões de segurança, o acesso direto ao cluster não é público.

Caso seja necessário acesso ao banco para:

- inspeção de dados
- debugging
- análise de execuções

é necessário solicitar acesso ao mantenedor do projeto.

---

# 🛠 Tecnologias Utilizadas

| Tecnologia | Uso |
|--------|--------|
Java | Linguagem principal |
Selenium | Automação Web |
Cucumber | BDD |
Maven | Gerenciamento de dependências |
MongoDB Atlas | Persistência de dados |
Java Faker | Geração de dados |
WebDriverManager | Gerenciamento de drivers |
Logback | Logs |
GitHub Actions | CI/CD |

---

# 🚀 Possíveis Evoluções

- execução paralela
- integração com Allure Report
- gravação de vídeo das execuções
- Selenium Grid
- testes cross-browser

---

# 👨‍💻 Autor

Projeto desenvolvido por **Luis Matheus Vasconcelos de Farias**.


