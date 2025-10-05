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

---

## 5. Conclusão
O projeto **FazTudo** irá criar uma aplicação eficiente e acessível para contratar e oferecer serviços num ambiente seguro, rápido e simples.


---

## 6. Bibliografia
- Fiverr: [https://www.fiverr.com](https://www.fiverr.com)  
- Oscar App: [https://oscarapp.io](https://oscarapp.io)  

