# Proposta Inicial do Projeto - FazTudo

## 1. Identificação
- **Universidade:** Universidade Europeia 
- **Faculdade:** IADE 
- **Grupo:** Paulo Alberto 20240873, Mateus Reis 20241799, Ngweza Van-Dúnem 20240075, Bruno Gouveia 20240181
- **Nome do Projeto:** FazTudo - Plataforma de Serviços  
- **Repositório GitHub:**  [FazTudo](https://github.com/Pmca23/FazTudo)  

---

## 2. Enquadramento
- **Ideia principal:**  
  O FazTudo é uma aplicação de serviços que liga clientes e prestadores, semelhante ao Fiverr ou Oscar.  
  Os utilizadores podem **contratar serviços** ou **oferecer os seus serviços** diretamente através da aplicação.
  

- **Pesquisa de aplicações semelhantes:**  
  Foram analisadas plataformas como Fiverr e Oscar, identificando oportunidades para simplificação e maior foco no mercado local.

- **Contexto e motivação:**  
  Muitos prestadores de serviços independentes têm dificuldade em promover o seu trabalho e chegar a potenciais clientes. A FazTudo cria uma ponte simples e eficiente para esse contacto.

- **Objetivos:**  
  - Criar uma aplicação intuitiva para clientes e prestadores de serviços.  
  - Garantir processos de pagamento seguros e transparentes.  
  - Oferecer funcionalidades rápidas de pesquisa e avaliação de serviços.

- **Público-alvo:**  
  - Pessoas que procuram serviços rápidos e acessíveis.  
  - Prestadores de serviços independentes.

---

## 3. Casos de Utilização
### Caso 1: Core do Projeto - Contratar um Serviço
**Descrição:**  
1. Cliente pesquisa por um serviço.  
2. Escolhe prestador com base em avaliações.  
3. Efetua o pagamento diretamente na aplicação.  
4. Recebe confirmação e acompanha o serviço.  

### Caso 2: Ser Prestador de Serviços
**Descrição:**  
1. Prestador cria perfil com descrição e preços.  
2. Recebe pedidos de clientes.  
3. Aceita ou recusa serviços.  
4. Recebe pagamento após conclusão.  

### Caso 3: Sistema de Avaliações
**Descrição:**  
1. Cliente avalia o prestador após o serviço.  
2. Avaliações ficam visíveis para outros clientes.  

---

## 4. Plano de Trabalhos

### 4.1 Project Charter
| Elemento              | Descrição                                                        |
|-----------------------|------------------------------------------------------------------|
| Nome do Projeto       | FazTudo - Plataforma de Serviços                                 |
| Objetivo Principal    | Ligar clientes e prestadores num só ambiente                     |
| Stakeholders          | Clientes, Prestadores, Equipa de Desenvolvimento                 |
| Equipa                | Paulo Alberto, Mateus Reis, Ngweza Van-Dúnem, Bruno Gouveia      |
| Tecnologia            | Android (Kotlin/Java)                                            |
| Entregas Principais   | App Android, Documentação, Vídeo, Poster                         |
| Riscos                | Atrasos no desenvolvimento, Falhas técnicas                      |

---

### 4.2 WBS (Work Breakdown Structure)
1. **Planeamento**  
   1.1 Recolha de requisitos  
   1.2 Pesquisa de mercado  
2. **Desenvolvimento**  
   2.1 Design da Interface (Figma)  
   2.2 Backend e Base de Dados  
   2.3 Integração Pagamentos  
3. **Testes e Lançamento**  
   3.1 Testes Funcionais  
   3.2 Publicação Beta  

---

### 4.3 Requisitos Funcionais e Não Funcionais
**Funcionais:**  
- O utilizador deve poder criar uma conta.  
- O prestador deve poder listar os seus serviços.  
- O cliente deve poder pagar diretamente pela app.  

**Não Funcionais:**  
- Disponível apenas para **Android**.  
- Interface simples e responsiva.  
- Tempo de resposta inferior a 2 segundos para ações principais.  

---

### 4.4 Modelo do Domínio
- Entidades:  
  - Utilizador  
  - Prestador  
  - Serviço  
  - Avaliação  
  - Pagamento  

---

### 4.5 Mockups e Interfaces
Mockups disponíveis em: [FazTudo - Figma](https://www.figma.com/make/2AUanzGmjUeCrwQQst3u65/FazTudo-Service-App?node-id=0-1&t=71l5VkpcWlIXZ80o-1)  

---

### 4.6 Planeamento (Gráfico de Gantt)

| Fase | Início | Fim | Responsável |
|------|---------|-----|--------------|
| Análise de Requisitos | 01/10/2025 | 05/10/2025 | Paulo Alberto |
| Planeamento do Projeto e WBS | 06/10/2025 | 08/10/2025 | Mateus Reis, Bruno Gouveia |
| Design UI (Figma) | 09/10/2025 | 15/10/2025 | Mateus Reis |
| Modelação da Base de Dados | 16/10/2025 | 20/10/2025 | Bruno Gouveia |
| Desenvolvimento do Backend | 21/10/2025 | 05/11/2025 | Ngweza Van-Dúnem |
| Desenvolvimento do Frontend Android | 06/11/2025 | 20/11/2025 | Paulo Alberto |
| Integração Backend + Frontend | 21/11/2025 | 27/11/2025 | Toda a Equipa |
| Testes Unitários e Funcionais | 28/11/2025 | 05/12/2025 | Bruno Gouveia, Mateus Reis |
| Otimização e Correção de Bugs | 06/12/2025 | 10/12/2025 | Toda a Equipa |
| Preparação da Apresentação e Vídeo | 11/12/2025 | 13/12/2025 | Paulo Alberto, Ngweza Van-Dúnem |
| Lançamento Beta Final | 14/12/2025 | 14/12/2025 | Toda a Equipa |

---

### 4.7 Plano de Trabalhos

1. **Planeamento Inicial**
   - Definir o escopo do projeto e os principais requisitos.
   - Recolher informação sobre aplicações semelhantes (Fiverr, Oscar).
   - Estabelecer cronograma e responsabilidades.

2. **Design e Modelação**
   - Criação do mockup no Figma: [FazTudo - Figma](https://www.figma.com/make/2AUanzGmjUeCrwQQst3u65/FazTudo-Service-App?node-id=0-1&t=71l5VkpcWlIXZ80o-1)
   - Definir o modelo de dados (entidades: Utilizador, Prestador, Serviço, Avaliação, Pagamento).
   - Especificar arquitetura da aplicação (Android + Firebase).

3. **Desenvolvimento**
   - Implementação do Backend (autenticação, gestão de serviços e utilizadores).
   - Desenvolvimento do Frontend em Android (Kotlin/Java).
   - Integração entre módulos e API REST.

4. **Testes**
   - Testes unitários e funcionais.
   - Testes de integração e desempenho.
   - Validação com casos de utilização definidos.

5. **Entrega e Divulgação**
   - Preparação do relatório final e exportação em PDF.
   - Criação do vídeo promocional (1-2 minutos, estilo anúncio).
   - Desenvolvimento do poster da aplicação.
   - Apresentação oral e demonstração da App no telemóvel.

---

**Observações:**
- O projeto decorre entre **1 de outubro e 14 de dezembro de 2025**.  
- A fase final inclui correções e otimizações com base nos testes e feedback dos utilizadores.

## 5. Base de Dados – Dicionário de Dados e Modelo Entidade-Relação

### 5.1. Introdução
A base de dados **FazTudoDB** foi concebida para suportar o funcionamento da aplicação “FazTudo”, permitindo gerir utilizadores, vendedores, categorias, serviços e avaliações de forma estruturada e segura.

---

### 5.2. Entidades e Estrutura Geral
A BD é composta por oito entidades principais, com relações normalizadas (1:1 e 1:N), garantindo integridade e consistência de dados.

| **Tabela** | **Descrição** |
|-------------|---------------|
| **localizacao** | Armazena morada, cidade e código postal dos utilizadores e vendedores. |
| **estado** | Define o estado de um serviço (ativo, pendente, concluído). |
| **categoria** | Classificação dos serviços disponíveis. |
| **user** | Representa os utilizadores (clientes) da aplicação. |
| **vendedor** | Representa os prestadores de serviço, podendo ter ligação 1:1 a um utilizador. |
| **vendedor_categoria** | Liga vendedores a categorias de serviço específicas. |
| **servico** | Serviços oferecidos pelos vendedores a utilizadores. |
| **avaliacao** | Avaliações e comentários realizados pelos utilizadores. |

---

### 5.3. Dicionário de Dados

#### **Tabela: localizacao**
| Campo | Tipo | Chave | Descrição |
|-------|------|-------|-----------|
| id_localizacao | INT | PK | Identificador único |
| cidade | VARCHAR(80) |  | Cidade |
| morada | VARCHAR(150) |  | Morada completa |
| codigo_postal | VARCHAR(15) |  | Código postal |

---

#### **Tabela: estado**
| Campo | Tipo | Chave | Descrição |
|-------|------|-------|-----------|
| id_estado | INT | PK | Identificador |
| nome | VARCHAR(50) |  | Nome do estado |

---

#### **Tabela: categoria**
| Campo | Tipo | Chave | Descrição |
|-------|------|-------|-----------|
| id_categoria | INT | PK | Identificador |
| nome | VARCHAR(100) |  | Nome da categoria |

---

#### **Tabela: user**
| Campo | Tipo | Chave | Descrição |
|-------|------|-------|-----------|
| id_user | INT | PK | Identificador do utilizador |
| nome | VARCHAR(100) |  | Nome completo |
| email | VARCHAR(150) | UNIQUE | Email |
| palavra_passe | VARCHAR(255) |  | Palavra-passe cifrada |
| telemovel | VARCHAR(20) |  | Contacto |
| data_registo | DATETIME |  | Data de registo |
| id_localizacao | INT | FK | FK → localizacao |

---

#### **Tabela: vendedor**
| Campo | Tipo | Chave | Descrição |
|-------|------|-------|-----------|
| id_vendedor | INT | PK | Identificador do vendedor |
| nome | VARCHAR(100) |  | Nome completo |
| email | VARCHAR(150) | UNIQUE | Email |
| telemovel | VARCHAR(20) |  | Contacto |
| data_registo | DATETIME |  | Data de registo |
| id_localizacao | INT | FK | FK → localizacao |
| id_user | INT | FK/UNIQUE | Ligação 1:1 opcional com user |

---

#### **Tabela: vendedor_categoria**
| Campo | Tipo | Chave | Descrição |
|-------|------|-------|-----------|
| id_vendedor_categoria | INT | PK | Identificador |
| id_categoria | INT | FK | FK → categoria |
| id_vendedor | INT | FK | FK → vendedor |
| descricao | VARCHAR(255) |  | Descrição dos serviços |
| data_registo | DATETIME |  | Data de registo |

---

#### **Tabela: servico**
| Campo | Tipo | Chave | Descrição |
|-------|------|-------|-----------|
| id_servico | INT | PK | Identificador |
| titulo | VARCHAR(150) |  | Título do serviço |
| preco | DECIMAL(10,2) |  | Preço |
| data_publicacao | DATETIME |  | Data de publicação |
| id_vendedor_categoria | INT | FK | FK → vendedor_categoria |
| id_user | INT | FK | FK → user |
| id_estado | INT | FK | FK → estado |

---

#### **Tabela: avaliacao**
| Campo | Tipo | Chave | Descrição |
|-------|------|-------|-----------|
| id_avaliacao | INT | PK | Identificador |
| id_user | INT | FK | FK → user |
| id_vendedor_categoria | INT | FK | FK → vendedor_categoria |
| nota | TINYINT |  | Pontuação (1 a 5) |
| comentario | TEXT |  | Comentário textual |
| data_avaliacao | DATETIME |  | Data e hora da avaliação |

---

### 5.4. Modelo Entidade-Relação (Descrição)
O modelo E-R apresenta as seguintes relações:

- **User (1)** → **Serviço (N)**  
- **User (1)** → **Avaliação (N)**  
- **Vendedor (1)** → **Vendedor_Categoria (N)**  
- **Categoria (1)** → **Vendedor_Categoria (N)**  
- **Vendedor_Categoria (1)** → **Serviço (N)**  
- **Estado (1)** → **Serviço (N)**  
- **Localização (1)** → **User / Vendedor (N)**  
- **Vendedor_Categoria (1)** → **Avaliação (N)**  

---

### 5.5. Guia de Dados (Exemplo)
| Tabela | Exemplo de Dados |
|---------|------------------|
| **localizacao** | (1, “Lisboa”, “Av. da Liberdade, 100”, “1000-000”) |
| **estado** | (1, “Ativo”), (2, “Concluído”), (3, “Cancelado”) |
| **categoria** | (1, “Canalização”), (2, “Limpeza”), (3, “Pintura”) |
| **user** | (1, “Maria Silva”, “maria@email.com”, “***”, “912345678”, “2025-01-01”, 1) |
| **vendedor** | (1, “João Santos”, “joao@email.com”, “913456789”, “2025-01-03”, 1, 1) |
| **vendedor_categoria** | (1, 1, 1, “Serviços de canalização residencial”, “2025-01-04”) |
| **servico** | (1, “Reparação de canos”, 50.00, “2025-02-01”, 1, 1, 1) |
| **avaliacao** | (1, 1, 1, 5, “Excelente serviço!”, “2025-02-05”) |

---

### 5.6. Estrutura dos Ficheiros

- **create.sql** → Criação de tabelas, chaves e restrições.  
- **populate.sql** → Inserção de dados de teste realistas.  
- **queries.sql** → Consultas exemplificativas, por exemplo:

```sql
-- Listar serviços ativos e respetivos vendedores
SELECT s.titulo, s.preco, v.nome AS vendedor, c.nome AS categoria
FROM servico s
JOIN vendedor_categoria vc ON s.id_vendedor_categoria = vc.id_vendedor_categoria
JOIN vendedor v ON vc.id_vendedor = v.id_vendedor
JOIN categoria c ON vc.id_categoria = c.id_categoria
JOIN estado e ON s.id_estado = e.id_estado
WHERE e.nome = 'Ativo';
```
### 5.7. Conclusão da Base de Dados

A base de dados **FazTudoDB** cumpre os requisitos funcionais identificados para a aplicação “FazTudo”, permitindo:
- gerir utilizadores e vendedores com localizações normalizadas;
- organizar serviços por categorias e por vendedor;
- controlar o estado de cada serviço;
- registar feedback dos utilizadores através de avaliações.

O modelo está normalizado e as **chaves estrangeiras** garantem a integridade referencial (por exemplo, um serviço só existe se existir o respetivo vendedor/categoria e o utilizador que o requisitou).  
A estrutura é suficientemente genérica para futuras extensões, como:
- novas tabelas de pagamentos/faturas;
- histórico de estados de serviço;
- mensagens entre utilizador e vendedor.

Assim, a BD serve de base estável para a API e para o frontend móvel, mantendo os dados consistentes e auditáveis.




6\. API REST da Aplicação FazTudo
---------------------------------

A API foi desenvolvida em **Spring Boot** e expõe endpoints REST para gerir utilizadores, vendedores, categorias, serviços e autenticação.A base de dados usada é MySQL (faztudodb).

Base URL (ambiente local):

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   http://localhost:8080   `

### 6.1. Autenticação e Utilizadores

#### 6.1.1. Listar todos os utilizadores

**GET** /api/users

**Descrição:** devolve todos os utilizadores registados no sistema.

**Resposta 200:**

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   [    {      "id_user": 1,      "nome": "João Silva",      "email": "joao@example.com",      "telemovel": "912345678"    }  ]   `

#### 6.1.2. Registar utilizador (com opção de vendedor)

**POST** /api/users/register

**Descrição:**

*   cria sempre um **user**;
    
*   se o campo is\_vendedor vier como true, cria também um **vendedor** associado a esse user;
    
*   se vier o array categorias, cria também registos em vendedor\_categoria.
    

**Body – utilizador normal:**

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   {    "nome": "Maria Silva",    "email": "maria@example.com",    "telemovel": "912345678",    "palavra_passe": "123456",    "is_vendedor": false  }   `

**Body – utilizador que é também vendedor:**

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   {    "nome": "Carlos Prestador",    "email": "carlos@example.com",    "telemovel": "919191919",    "palavra_passe": "abc123",    "is_vendedor": true,    "categorias": [1, 3, 5]  }   `

**Resposta 201 (quando também cria vendedor):**

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   {    "user": {      "id_user": 11,      "nome": "Carlos Prestador",      "email": "carlos@example.com"    },    "vendedor": {      "id_vendedor": 4,      "nome": "Carlos Prestador",      "email": "carlos@example.com"    },    "token": "JWT_AQUI"  }   `

**Erros:**

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   { "error": "Email já existe" }   `

#### 6.1.3. Login

**POST** /api/users/login

**Descrição:** valida as credenciais e devolve um token JWT e dados do utilizador. O backend também verifica se o utilizador tem perfil de vendedor.

**Body:**

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   {    "email": "carlos@example.com",    "palavra_passe": "abc123"  }   `

**Resposta 200:**

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   {    "token": "JWT_AQUI",    "id_user": 11,    "nome": "Carlos Prestador",    "is_vendedor": true  }   `

**Erros:**

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   { "error": "Credenciais inválidas" }   `

### 6.2. Vendedores

> Nota: neste projeto, o vendedor costuma ser criado automaticamente no /api/users/register quando o campo is\_vendedor = true. Estes endpoints servem sobretudo para consulta.

#### 6.2.1. Listar vendedores

**GET** /api/vendedores

**Resposta 200:**

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   [    {      "id_vendedor": 1,      "nome": "João Eletricista",      "email": "joao@eletric.pt",      "telemovel": "912345678"    }  ]   `

#### 6.2.2. Obter vendedor por ID

**GET** /api/vendedores/{id}

**Resposta 200:**

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   {    "id_vendedor": 3,    "nome": "Pedro Canalizador",    "email": "pedro@canos.pt"  }   `

**Resposta 404:**

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   { "error": "Vendedor não encontrado." }   `

#### 6.2.3. Obter vendedor pelo id do utilizador

**GET** /api/vendedores/user/{idUser}

**Descrição:** útil para o frontend/Android, para saber se o utilizador logado tem perfil de vendedor.

**Resposta 200:**

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   {    "id_vendedor": 4,    "nome": "Carlos Prestador",    "email": "carlos@example.com"  }   `

**Resposta 404:**

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   { "error": "Este utilizador não é vendedor." }   `

#### 6.2.4. Listar vendedores de uma categoria

**GET** /api/vendedores/categoria/{idCategoria}

**Descrição:** devolve os vendedores que pertencem a uma determinada categoria (com base na tabela de ligação vendedor\_categoria).

**Resposta 200:**

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   [    {      "id_vendedor": 4,      "nome": "Carlos Prestador",      "email": "carlos@example.com"    },    {      "id_vendedor": 6,      "nome": "Joana Limpezas",      "email": "joana@clean.pt"    }  ]   `

### 6.3. Serviços

#### 6.3.1. Criar serviço

**POST** /api/servicos

**Descrição:** cria um serviço associado a:

*   um utilizador (id\_user);
    
*   uma categoria de vendedor (id\_vendedor\_categoria);
    
*   e um estado (id\_estado).
    

**Body:**

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   {    "titulo": "Arranjar tomada",    "preco": 35.5,    "id_user": 11,    "id_vendedor_categoria": 2,    "id_estado": 1  }   `

**Resposta 201:**

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   {    "id_servico": 8,    "titulo": "Arranjar tomada",    "preco": 35.5  }   `

#### 6.3.2. Listar todos os serviços

**GET** /api/servicos

#### 6.3.3. Listar serviços de um utilizador

**GET** /api/servicos/user/{idUser}

**Descrição:** devolve todos os serviços criados por um determinado utilizador/prestador.

**Resposta 200:**

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   [    {      "id_servico": 8,      "titulo": "Arranjar tomada",      "preco": 35.5    }  ]   `

#### 6.3.4. Listar serviços por categoria de vendedor

**GET** /api/servicos/categoria/{idVendedorCategoria}

**Descrição:** útil para mostrar serviços ligados a uma categoria específica (ex.: canalização).

### 6.4. Categorias (sugestão)

Se quiseres expor as categorias para o frontend/Android:

**GET** /api/categorias

**Resposta 200:**

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   [    { "id_categoria": 1, "nome": "Canalização" },    { "id_categoria": 2, "nome": "Eletricidade" },    { "id_categoria": 3, "nome": "Limpezas" }  ]   `

7\. Estrutura de Dados
----------------------

### 7.1. Tabela user

*   id\_user INT PK
    
*   nome VARCHAR(100)
    
*   email VARCHAR(150) UNIQUE
    
*   palavra\_passe VARCHAR(255)
    
*   telemovel VARCHAR(20)
    
*   id\_localizacao INT NULL
    

### 7.2. Tabela vendedor

*   id\_vendedor INT PK
    
*   nome VARCHAR(100)
    
*   email VARCHAR(150) UNIQUE
    
*   telemovel VARCHAR(20)
    
*   id\_user INT NULL (1:1 com user)
    
*   id\_localizacao INT NULL
    

### 7.3. Tabela categoria

*   id\_categoria INT PK
    
*   nome VARCHAR(100)
    

### 7.4. Tabela vendedor\_categoria

*   id\_vendedor\_categoria INT PK
    
*   id\_vendedor INT FK
    
*   id\_categoria INT FK
    
*   descricao VARCHAR(255) NULL
    

### 7.5. Tabela servico

*   id\_servico INT PK
    
*   titulo VARCHAR(150)
    
*   preco DECIMAL(10,2)
    
*   data\_publicacao DATETIME
    
*   id\_vendedor\_categoria INT FK
    
*   id\_user INT FK
    
*   id\_estado INT FK
    

8\. Segurança / JWT
-------------------

*   O endpoint /api/users/login devolve um **token JWT**.
    
*   Authorization: Bearer
    
*   A configuração de segurança ainda não está a bloquear os endpoints (pode ser adicionada uma classe SecurityConfig e um filtro JWT para proteger rotas específicas).
    

9\. Fluxo de Registo Automático (User → Vendedor)
-------------------------------------------------

1.  O utilizador preenche o formulário no Android.
    
2.  O Android envia para /api/users/register o JSON com is\_vendedor.
    
3.  O backend:
    
    *   cria o user;
        
    *   se is\_vendedor = true, cria também vendedor;
        
    *   se vier categorias, cria em vendedor\_categoria.
        
4.  O backend devolve o user, o vendedor (se existir) e um token.
    

10\. Observações Finais
-----------------------

*   A API está preparada para crescer com:
    
    *   endpoint de avaliações (/api/avaliacoes);
        
    *   endpoint de estados de serviço;
        
    *   endpoint de imagens.
        
*   As foreign keys na BD garantem que não há serviços “soltos” sem vendedor/categoria/utilizador.

---

## 6. Conclusão
O projeto **FazTudo** irá criar uma aplicação eficiente e acessível para contratar e oferecer serviços num ambiente seguro, rápido e simples.


---

## 7. Bibliografia
- Fiverr: [https://www.fiverr.com](https://www.fiverr.com)  
- Oscar App: [https://oscarapp.io](https://oscarapp.io)  

