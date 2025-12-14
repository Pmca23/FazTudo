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
| latitude| DOUBLE|  |  |
| longitude| DOUBLE|  |  |  |  

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
| **localizacao** | (1, “Lisboa”, “Rua Augusta, 100”, “1000-000”,1100-053,38.7103, -9.1367) |
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
--DROP DATABASE IF EXISTS faztudodb;

CREATE DATABASE faztudodb
    DEFAULT CHARACTER SET utf8mb4
    DEFAULT COLLATE utf8mb4_unicode_ci;

USE faztudodb;

-- =========================================================
-- TABELAS
-- =========================================================

-- 1. LOCALIZACAO
CREATE TABLE localizacao (
    id_localizacao INT NOT NULL AUTO_INCREMENT,
    cidade VARCHAR(80),
    morada VARCHAR(150),
    codigo_postal VARCHAR(15),
    latitude DOUBLE,
    longitude DOUBLE,
    PRIMARY KEY (id_localizacao)
);

-- 2. ESTADO
CREATE TABLE estado (
    id_estado INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_estado)
);

-- 3. CATEGORIA
CREATE TABLE categoria (
    id_categoria INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    PRIMARY KEY (id_categoria)
);

-- 4. USER
CREATE TABLE user (
    id_user INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL,
    palavra_passe VARCHAR(255) NOT NULL,
    telemovel VARCHAR(20),
    data_registo DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id_localizacao INT,
    PRIMARY KEY (id_user),
    UNIQUE (email),
    FOREIGN KEY (id_localizacao) REFERENCES localizacao(id_localizacao)
        ON DELETE SET NULL ON UPDATE CASCADE
);

-- 5. VENDEDOR
CREATE TABLE vendedor (
    id_vendedor INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL,
    telemovel VARCHAR(20),
    data_registo DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id_localizacao INT,
    id_user INT,
    PRIMARY KEY (id_vendedor),
    UNIQUE (email),
    UNIQUE (id_user),
    FOREIGN KEY (id_localizacao) REFERENCES localizacao(id_localizacao)
        ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (id_user) REFERENCES user(id_user)
        ON DELETE SET NULL ON UPDATE CASCADE
);

-- 6. VENDEDOR_CATEGORIA
CREATE TABLE vendedor_categoria (
    id_vendedor_categoria INT NOT NULL AUTO_INCREMENT,
    id_categoria INT NOT NULL,
    id_vendedor INT NOT NULL,
    descricao VARCHAR(255),
    data_registo DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id_vendedor_categoria),
    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_vendedor) REFERENCES vendedor(id_vendedor)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- 7. SERVICO
CREATE TABLE servico (
    id_servico INT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(150) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL,
    data_publicacao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_conclusao DATETIME,
    id_vendedor_categoria INT NOT NULL,
    id_user INT NOT NULL,
    id_estado INT NOT NULL,
    PRIMARY KEY (id_servico),
    FOREIGN KEY (id_vendedor_categoria) REFERENCES vendedor_categoria(id_vendedor_categoria)
        ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (id_user) REFERENCES user(id_user)
        ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (id_estado) REFERENCES estado(id_estado)
        ON DELETE RESTRICT ON UPDATE CASCADE
);

-- 8. AVALIACAO
CREATE TABLE avaliacao (
    id_avaliacao INT NOT NULL AUTO_INCREMENT,
    id_user INT NOT NULL,
    id_vendedor_categoria INT NOT NULL,
    nota TINYINT,
    comentario TEXT,
    data_avaliacao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id_avaliacao),
    FOREIGN KEY (id_user) REFERENCES user(id_user)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_vendedor_categoria) REFERENCES vendedor_categoria(id_vendedor_categoria)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- =========================================================
-- ÍNDICES
-- =========================================================

CREATE INDEX idx_user_email ON user(email);
CREATE INDEX idx_vendedor_email ON vendedor(email);
CREATE INDEX idx_localizacao_coords ON localizacao(latitude, longitude);

```sql
-- Populate Base de Dados
USE faztudodb;

-- Estados
INSERT INTO estado (nome) VALUES
('Pendente'),
('Em Andamento'),
('Concluído'),
('Cancelado');

-- Categorias
INSERT INTO categoria (nome) VALUES
('Canalizador'),
('Eletricista'),
('Limpezas'),
('Pintura'),
('Jardinagem'),
('Reparações Gerais');

-- Localizações (com coordenadas de Lisboa)
INSERT INTO localizacao (cidade, morada, codigo_postal, latitude, longitude) VALUES
('Lisboa', 'Rua Augusta, 100', '1100-053', 38.7103, -9.1367),
('Lisboa', 'Avenida da Liberdade, 200', '1250-147', 38.7223, -9.1477),
('Cascais', 'Rua Frederico Arouca, 50', '2750-353', 38.6979, -9.4215),
('Sintra', 'Praça da República, 25', '2710-616', 38.8029, -9.3817),
('Lisboa', 'Rua do Ouro, 150', '1100-063', 38.7115, -9.1387),
('Oeiras', 'Avenida Marginal, 300', '2780-155', 38.6867, -9.3145),
('Almada', 'Praça da Liberdade, 10', '2800-180', 38.6784, -9.1567),
('Loures', 'Rua de São Pedro, 45', '2670-461', 38.8304, -9.1684);

-- Utilizadores (senha: 123456789)
INSERT INTO user (nome, email, palavra_passe, telemovel, id_localizacao) VALUES
('João Silva', 'joao.silva@email.com', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', '912345678', 1),
('Maria Santos', 'maria.santos@email.com', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', '923456789', 2),
('Pedro Costa', 'pedro.costa@email.com', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', '934567890', 3),
('Ana Ferreira', 'ana.ferreira@email.com', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', '945678901', 4);

-- Vendedores (com localização e coordenadas)
INSERT INTO vendedor (nome, email, telemovel, id_localizacao, id_user) VALUES
('Manuel Pereira', 'manuel.pereira@faztudo.pt', '961111111', 5, NULL),
('António Rodrigues', 'antonio.rodrigues@faztudo.pt', '962222222', 6, NULL),
('Sofia Martins', 'sofia.martins@faztudo.pt', '963333333', 7, NULL),
('Paulo Fernandes', 'paulo.fernandes@faztudo.pt', '964444444', 8, NULL);

-- Vendedor-Categoria
INSERT INTO vendedor_categoria (id_categoria, id_vendedor, descricao) VALUES
(1, 1, 'Especialista em canalização. 15 anos de experiência.'),
(2, 2, 'Instalações elétricas certificadas.'),
(3, 3, 'Limpezas domésticas e comerciais.'),
(6, 4, 'Pequenas reparações domésticas.');

-- Serviços
INSERT INTO servico (titulo, descricao, preco, id_vendedor_categoria, id_user, id_estado) VALUES
('Reparação de torneira', 'Torneira da cozinha com fuga', 45.00, 1, 1, 3),
('Instalação de tomadas', 'Instalação de 3 tomadas', 85.00, 2, 2, 3),
('Limpeza geral', 'Limpeza completa de T3', 120.00, 3, 3, 2),
('Reparação de porta', 'Porta que não fecha', 35.00, 4, 4, 1);

-- Avaliações
INSERT INTO avaliacao (id_user, id_vendedor_categoria, nota, comentario) VALUES
(1, 1, 5, 'Excelente profissional!'),
(2, 2, 4, 'Bom trabalho, pontual.'),
(3, 3, 5, 'Casa ficou impecável!');

-- =========================================================
-- VERIFICAÇÃO FINAL (Opcional, mas útil)
-- =========================================================
SELECT 'Base de dados populada com sucesso!' AS Resultado;
SELECT COUNT(*) AS Total_Servicos FROM servico;

```sql
-- 1 DETALHE DAS AVALIAÇÕES DADAS A UM SERVIÇO ESPECÍFICO (Canalizador)

SELECT
    u.nome AS Cliente,
    a.nota AS Nota,
    a.comentario AS Comentario,
    a.data_avaliacao AS Data_Avaliacao
FROM
    avaliacao a
JOIN
    user u ON a.id_user = u.id_user
JOIN
    vendedor_categoria vc ON a.id_vendedor_categoria = vc.id_vendedor_categoria
JOIN
    vendedor v ON vc.id_vendedor = v.id_vendedor
JOIN
    categoria c ON vc.id_categoria = c.id_categoria
WHERE
    v.nome = 'Manuel Pereira' AND c.nome = 'Canalizador';

-- 2. TOTAL DE SERVIÇOS POR ESTADO
-- Visão geral do volume de trabalho (pendente, concluído, etc.).
SELECT
    e.nome AS Estado,
    COUNT(s.id_servico) AS Total_Servicos
FROM
    estado e
LEFT JOIN
    servico s ON e.id_estado = s.id_estado
GROUP BY
    e.nome
ORDER BY
    Total_Servicos DESC;

-- 3. CLASSIFICAÇÃO MÉDIA E NÚMERO DE AVALIAÇÕES POR VENDEDOR

SELECT
    v.nome AS Vendedor,
    c.nome AS Categoria,
    COUNT(a.id_avaliacao) AS Total_Avaliacoes,
    ROUND(AVG(a.nota), 2) AS Classificacao_Media
FROM
    vendedor v
JOIN
    vendedor_categoria vc ON v.id_vendedor = vc.id_vendedor
LEFT JOIN
    avaliacao a ON vc.id_vendedor_categoria = a.id_vendedor_categoria
JOIN 
    categoria c ON vc.id_categoria = c.id_categoria -- Adicionei esta linha para garantir que 'c.nome' é reconhecido
GROUP BY
    v.nome, c.nome
ORDER BY
    Classificacao_Media DESC, Total_Avaliacoes DESC;

-- 4. Listar todos os serviços em 'Em Andamento' e quem os solicitou

SELECT
    s.titulo AS Servico,
    s.preco AS Preco,
    u.nome AS Cliente,
    v.nome AS Vendedor,
    c.nome AS Categoria,
    e.nome AS Estado
FROM
    servico s
JOIN
    user u ON s.id_user = u.id_user
JOIN
    estado e ON s.id_estado = e.id_estado
JOIN
    vendedor_categoria vc ON s.id_vendedor_categoria = vc.id_vendedor_categoria
JOIN
    vendedor v ON vc.id_vendedor = v.id_vendedor
JOIN
    categoria c ON vc.id_categoria = c.id_categoria
WHERE
    e.nome = 'Em Andamento';
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




# 6.FazTudo REST API Documentation

## Autenticação

A API utiliza autenticação baseada em JWT (JSON Web Tokens). Para acessar endpoints protegidos, inclua o token no header:

```
Authorization: Bearer {seu-token-jwt}
```

## Base URL

```
https://api.faztudo.pt/api
```

---

## Endpoints

### Auth

#### Registar Utilizador

Cria uma nova conta de utilizador.

```http
POST /auth/register
```

**Request Body:**
```json
{
    "nome": "João Silva",
    "email": "joao@example.com",
    "password": "senha123",
    "telefone": "912345678",
    "morada": "Rua Principal, 123",
    "latitude": 38.7223,
    "longitude": -9.1393
}
```

**Response:** `200 OK`
```json
{
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
    "user": {
        "id": 1,
        "nome": "João Silva",
        "email": "joao@example.com",
        "telefone": "912345678",
        "morada": "Rua Principal, 123"
    }
}
```

---

#### Login

Autentica um utilizador existente.

```http
POST /auth/login
```

**Request Body:**
```json
{
    "email": "joao@example.com",
    "password": "senha123"
}
```

**Response:** `200 OK`
```json
{
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
    "user": {
        "id": 1,
        "nome": "João Silva",
        "email": "joao@example.com",
        "telefone": "912345678",
        "morada": "Rua Principal, 123"
    }
}
```

---

### Users

#### Obter Perfil Atual

Retorna os dados do utilizador autenticado.

```http
GET /users/me
```

**Headers:**
```
Authorization: Bearer {token}
```

**Response:** `200 OK`
```json
{
    "id": 1,
    "nome": "João Silva",
    "email": "joao@example.com",
    "telefone": "912345678",
    "morada": "Rua Principal, 123",
    "latitude": 38.7223,
    "longitude": -9.1393,
    "dataCriacao": "2025-01-15T10:30:00"
}
```

---

#### Atualizar Perfil Atual

Atualiza os dados do utilizador autenticado.

```http
PUT /users/me
```

**Headers:**
```
Authorization: Bearer {token}
```

**Request Body:**
```json
{
    "nome": "João Pedro Silva",
    "telefone": "913456789",
    "morada": "Rua Nova, 456",
    "latitude": 38.7223,
    "longitude": -9.1393
}
```

**Response:** `200 OK`
```json
{
    "id": 1,
    "nome": "João Pedro Silva",
    "email": "joao@example.com",
    "telefone": "913456789",
    "morada": "Rua Nova, 456",
    "latitude": 38.7223,
    "longitude": -9.1393
}
```

---

#### Obter Utilizador por ID

Retorna os dados de um utilizador específico.

```http
GET /users/{id}
```

**Parameters:**
- `id` (path) - ID do utilizador

**Response:** `200 OK`
```json
{
    "id": 1,
    "nome": "João Silva",
    "email": "joao@example.com",
    "telefone": "912345678",
    "morada": "Rua Principal, 123"
}
```

---

#### Listar Todos os Utilizadores

Retorna a lista de todos os utilizadores.

```http
GET /users
```

**Headers:**
```
Authorization: Bearer {token}
```

**Response:** `200 OK`
```json
[
    {
        "id": 1,
        "nome": "João Silva",
        "email": "joao@example.com",
        "telefone": "912345678"
    },
    {
        "id": 2,
        "nome": "Maria Santos",
        "email": "maria@example.com",
        "telefone": "923456789"
    }
]
```

---

### Categorias

#### Listar Todas as Categorias

Retorna todas as categorias de serviços disponíveis.

```http
GET /categorias
```

**Response:** `200 OK`
```json
[
    {
        "id": 1,
        "nome": "Canalizador",
        "descricao": "Serviços de canalização e reparações hidráulicas"
    },
    {
        "id": 2,
        "nome": "Eletricista",
        "descricao": "Instalações e reparações elétricas"
    },
    {
        "id": 3,
        "nome": "Pintor",
        "descricao": "Pintura de interiores e exteriores"
    }
]
```

---

#### Obter Categoria por ID

Retorna os detalhes de uma categoria específica.

```http
GET /categorias/{id}
```

**Parameters:**
- `id` (path) - ID da categoria

**Response:** `200 OK`
```json
{
    "id": 1,
    "nome": "Canalizador",
    "descricao": "Serviços de canalização e reparações hidráulicas"
}
```

---

#### Pesquisar Categorias

Pesquisa categorias por termo.

```http
GET /categorias/search?termo={termo}
```

**Query Parameters:**
- `termo` (string, required) - Termo de pesquisa

**Exemplo:**
```http
GET /categorias/search?termo=eletric
```

**Response:** `200 OK`
```json
[
    {
        "id": 2,
        "nome": "Eletricista",
        "descricao": "Instalações e reparações elétricas"
    }
]
```

---

### Vendedores

#### Listar Todos os Vendedores

Retorna todos os vendedores registados.

```http
GET /vendedores
```

**Response:** `200 OK`
```json
[
    {
        "id": 1,
        "userId": 5,
        "nome": "Manuel Alves",
        "categoriaId": 1,
        "categoriaNome": "Canalizador",
        "avaliacaoMedia": 4.5,
        "numeroAvaliacoes": 23,
        "precoMedio": 35.00
    },
    {
        "id": 2,
        "userId": 8,
        "nome": "António Costa",
        "categoriaId": 2,
        "categoriaNome": "Eletricista",
        "avaliacaoMedia": 4.8,
        "numeroAvaliacoes": 45,
        "precoMedio": 40.00
    }
]
```

---

#### Obter Vendedor por ID

Retorna os detalhes de um vendedor específico.

```http
GET /vendedores/{id}
```

**Parameters:**
- `id` (path) - ID do vendedor

**Response:** `200 OK`
```json
{
    "id": 1,
    "userId": 5,
    "nome": "Manuel Alves",
    "email": "manuel@example.com",
    "telefone": "934567890",
    "categoriaId": 1,
    "categoriaNome": "Canalizador",
    "descricao": "Canalizador com 15 anos de experiência",
    "avaliacaoMedia": 4.5,
    "numeroAvaliacoes": 23,
    "precoMedio": 35.00,
    "latitude": 38.7223,
    "longitude": -9.1393
}
```

---

#### Listar Vendedores por Categoria

Retorna vendedores de uma categoria específica.

```http
GET /vendedores/categoria/{idCategoria}
```

**Parameters:**
- `idCategoria` (path) - ID da categoria

**Response:** `200 OK`
```json
[
    {
        "id": 1,
        "userId": 5,
        "nome": "Manuel Alves",
        "categoriaId": 1,
        "categoriaNome": "Canalizador",
        "avaliacaoMedia": 4.5,
        "numeroAvaliacoes": 23,
        "precoMedio": 35.00
    }
]
```

---

#### Pesquisar Vendedores Próximos

Retorna vendedores de uma categoria próximos de uma localização.

```http
GET /vendedores/categoria/{idCategoria}/proximos?latitude={lat}&longitude={lng}&raioKm={raio}
```

**Parameters:**
- `idCategoria` (path) - ID da categoria
- `latitude` (query, required) - Latitude da localização
- `longitude` (query, required) - Longitude da localização
- `raioKm` (query, optional) - Raio de pesquisa em km (default: 50)

**Exemplo:**
```http
GET /vendedores/categoria/1/proximos?latitude=38.7223&longitude=-9.1393&raioKm=10
```

**Response:** `200 OK`
```json
[
    {
        "id": 1,
        "userId": 5,
        "nome": "Manuel Alves",
        "categoriaId": 1,
        "categoriaNome": "Canalizador",
        "avaliacaoMedia": 4.5,
        "numeroAvaliacoes": 23,
        "precoMedio": 35.00,
        "distanciaKm": 2.5
    },
    {
        "id": 3,
        "userId": 12,
        "nome": "Pedro Santos",
        "categoriaId": 1,
        "categoriaNome": "Canalizador",
        "avaliacaoMedia": 4.2,
        "numeroAvaliacoes": 15,
        "precoMedio": 30.00,
        "distanciaKm": 5.8
    }
]
```

---

#### Obter Avaliações de um Vendedor

Retorna todas as avaliações de um vendedor.

```http
GET /vendedores/{id}/avaliacoes
```

**Parameters:**
- `id` (path) - ID do vendedor

**Response:** `200 OK`
```json
[
    {
        "id": 1,
        "servicoId": 10,
        "clienteNome": "João Silva",
        "nota": 5,
        "comentario": "Excelente profissional, muito pontual e eficiente!",
        "data": "2025-01-10T14:30:00"
    },
    {
        "id": 2,
        "servicoId": 15,
        "clienteNome": "Maria Costa",
        "nota": 4,
        "comentario": "Bom trabalho, mas demorou um pouco mais do que esperado.",
        "data": "2025-01-08T10:15:00"
    }
]
```

---

### Serviços

#### Criar Serviço

Cria um novo pedido de serviço.

```http
POST /servicos
```

**Headers:**
```
Authorization: Bearer {token}
```

**Request Body:**
```json
{
    "vendedorId": 1,
    "descricao": "Reparação de torneira na cozinha",
    "dataAgendada": "2025-01-20T14:00:00",
    "precoAcordado": 45.00
}
```

**Response:** `200 OK`
```json
{
    "id": 25,
    "clienteId": 1,
    "clienteNome": "João Silva",
    "vendedorId": 1,
    "vendedorNome": "Manuel Alves",
    "categoriaNome": "Canalizador",
    "descricao": "Reparação de torneira na cozinha",
    "estadoId": 1,
    "estadoNome": "Pendente",
    "dataAgendada": "2025-01-20T14:00:00",
    "precoAcordado": 45.00,
    "dataCriacao": "2025-01-15T11:00:00"
}
```

---

#### Obter Serviço por ID

Retorna os detalhes de um serviço específico.

```http
GET /servicos/{id}
```

**Headers:**
```
Authorization: Bearer {token}
```

**Parameters:**
- `id` (path) - ID do serviço

**Response:** `200 OK`
```json
{
    "id": 25,
    "clienteId": 1,
    "clienteNome": "João Silva",
    "clienteTelefone": "912345678",
    "clienteMorada": "Rua Principal, 123",
    "vendedorId": 1,
    "vendedorNome": "Manuel Alves",
    "vendedorTelefone": "934567890",
    "categoriaNome": "Canalizador",
    "descricao": "Reparação de torneira na cozinha",
    "estadoId": 1,
    "estadoNome": "Pendente",
    "dataAgendada": "2025-01-20T14:00:00",
    "dataInicio": null,
    "dataConclusao": null,
    "precoAcordado": 45.00,
    "dataCriacao": "2025-01-15T11:00:00"
}
```

---

#### Listar Meus Serviços (Cliente)

Retorna os serviços solicitados pelo utilizador autenticado como cliente.

```http
GET /servicos/meus
```

**Headers:**
```
Authorization: Bearer {token}
```

**Response:** `200 OK`
```json
[
    {
        "id": 25,
        "vendedorNome": "Manuel Alves",
        "categoriaNome": "Canalizador",
        "descricao": "Reparação de torneira na cozinha",
        "estadoNome": "Pendente",
        "dataAgendada": "2025-01-20T14:00:00",
        "precoAcordado": 45.00
    },
    {
        "id": 18,
        "vendedorNome": "António Costa",
        "categoriaNome": "Eletricista",
        "descricao": "Instalação de tomadas",
        "estadoNome": "Concluído",
        "dataAgendada": "2025-01-10T09:00:00",
        "precoAcordado": 60.00
    }
]
```

---

#### Listar Meus Serviços (Vendedor)

Retorna os serviços atribuídos ao utilizador autenticado como vendedor.

```http
GET /servicos/meus/vendedor
```

**Headers:**
```
Authorization: Bearer {token}
```

**Response:** `200 OK`
```json
[
    {
        "id": 25,
        "clienteNome": "João Silva",
        "clienteTelefone": "912345678",
        "clienteMorada": "Rua Principal, 123",
        "descricao": "Reparação de torneira na cozinha",
        "estadoNome": "Pendente",
        "dataAgendada": "2025-01-20T14:00:00",
        "precoAcordado": 45.00
    },
    {
        "id": 22,
        "clienteNome": "Maria Santos",
        "clienteTelefone": "923456789",
        "clienteMorada": "Avenida Central, 789",
        "descricao": "Desentupimento de cano",
        "estadoNome": "Em Progresso",
        "dataAgendada": "2025-01-16T10:00:00",
        "precoAcordado": 50.00
    }
]
```

---

#### Iniciar Serviço

Marca um serviço como "Em Progresso".

```http
PATCH /servicos/{id}/iniciar
```

**Headers:**
```
Authorization: Bearer {token}
```

**Parameters:**
- `id` (path) - ID do serviço

**Response:** `200 OK`
```json
{
    "id": 25,
    "estadoNome": "Em Progresso",
    "dataInicio": "2025-01-20T14:05:00"
}
```

---

#### Concluir Serviço

Marca um serviço como "Concluído".

```http
PATCH /servicos/{id}/concluir
```

**Headers:**
```
Authorization: Bearer {token}
```

**Parameters:**
- `id` (path) - ID do serviço

**Response:** `200 OK`
```json
{
    "id": 25,
    "estadoNome": "Concluído",
    "dataConclusao": "2025-01-20T16:30:00"
}
```

---

#### Cancelar Serviço

Marca um serviço como "Cancelado".

```http
PATCH /servicos/{id}/cancelar
```

**Headers:**
```
Authorization: Bearer {token}
```

**Parameters:**
- `id` (path) - ID do serviço

**Response:** `200 OK`
```json
{
    "id": 25,
    "estadoNome": "Cancelado",
    "dataCancelamento": "2025-01-19T10:00:00"
}
```

---

### Estados

#### Listar Todos os Estados

Retorna todos os estados possíveis de um serviço.

```http
GET /estados
```

**Response:** `200 OK`
```json
[
    {
        "id": 1,
        "nome": "Pendente",
        "descricao": "Serviço aguardando confirmação"
    },
    {
        "id": 2,
        "nome": "Em Progresso",
        "descricao": "Serviço em execução"
    },
    {
        "id": 3,
        "nome": "Concluído",
        "descricao": "Serviço finalizado"
    },
    {
        "id": 4,
        "nome": "Cancelado",
        "descricao": "Serviço cancelado"
    }
]
```

---

#### Obter Estado por ID

Retorna os detalhes de um estado específico.

```http
GET /estados/{id}
```

**Parameters:**
- `id` (path) - ID do estado

**Response:** `200 OK`
```json
{
    "id": 1,
    "nome": "Pendente",
    "descricao": "Serviço aguardando confirmação"
}
```

---


## Códigos de Status

| Código | Descrição |
|--------|-----------|
| 200 | OK - Requisição bem-sucedida |
| 201 | Created - Recurso criado com sucesso |
| 400 | Bad Request - Dados inválidos |
| 401 | Unauthorized - Autenticação necessária |
| 403 | Forbidden - Sem permissão |
| 404 | Not Found - Recurso não encontrado |
| 500 | Internal Server Error - Erro no servidor |

---
    

7\. Segurança / JWT
-------------------

*   O endpoint /api/users/login devolve um **token JWT**.
    
*   Authorization: Bearer
    
*   A configuração de segurança ainda não está a bloquear os endpoints (pode ser adicionada uma classe SecurityConfig e um filtro JWT para proteger rotas específicas).

## 8 Limitações de Implementação - Frontend vs Backend

Apesar de o backend possuir funcionalidades completas para gestão de serviços, a implementação no frontend apresenta limitações significativas que afetam a experiência de utilizadores e vendedores,
sendo o problema principal apenas o utilizador (user) conseguir cancelar pedidos através da interface, os vendedores (vendors) não têm acesso equivalente a esta funcionalidade.

Interface de Visualização:

Existe uma aba para visualizar serviços do utilizador (user), também existe uma aba para visualizar serviços do vendedor (vendor) Os pedidos efetuados não aparecem do lado do vendedor (vendor), o que impossibilita:

* Visualização de novos pedidos
 
* Aceitação de pedidos
 
* Cancelamento de pedidos pelo vendedor

* Gestão adequada do fluxo de trabalho

### Funcionalidades Não Implementadas

Embora o backend suporte estas operações, o frontend não implementa totalmente:

* Avaliação de serviços

* Interface incompleta ou ausente

* Aceitação de pedidos pelo vendedor

Não funcional apesar do backend suportar:

* Cancelamento pelo vendedor

 ### Para Utilizadores (Users)

 Podem cancelar os seus próprios pedidos
 
 Não recebem feedback visual adequado sobre o estado dos pedidos
 
 Não conseguem avaliar serviços mesmo após conclusão
 
 ### Para Vendedores (Vendors)
 
 Não visualizam pedidos recebidos
 
 Não podem aceitar/rejeitar pedidos
 
 Não conseguem gerir o seu pipeline de trabalho
 
 Impossibilitados de cancelar pedidos quando necessário

 Outra função que queriamos implementar porém nem no backend nem no frontend seria o pagamento através da app de forma segura e um sistema de chat entre o user e o vendedor.
    
---

## 9. Conclusão
O projeto **FazTudo** irá criar uma aplicação eficiente e acessível para contratar e oferecer serviços num ambiente seguro, rápido e simples.


---

## 9. Bibliografia
- Fiverr: [https://www.fiverr.com](https://www.fiverr.com)  
- Oscar App: [https://oscarapp.io](https://oscarapp.io)  

