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

sql
-- Listar serviços ativos e respetivos vendedores
SELECT s.titulo, s.preco, v.nome AS vendedor, c.nome AS categoria
FROM servico s
JOIN vendedor_categoria vc ON s.id_vendedor_categoria = vc.id_vendedor_categoria
JOIN vendedor v ON vc.id_vendedor = v.id_vendedor
JOIN categoria c ON vc.id_categoria = c.id_categoria
JOIN estado e ON s.id_estado = e.id_estado
WHERE e.nome = 'Ativo';


---

## 6. Conclusão
O projeto **FazTudo** irá criar uma aplicação eficiente e acessível para contratar e oferecer serviços num ambiente seguro, rápido e simples.


---

## 7. Bibliografia
- Fiverr: [https://www.fiverr.com](https://www.fiverr.com)  
- Oscar App: [https://oscarapp.io](https://oscarapp.io)  

