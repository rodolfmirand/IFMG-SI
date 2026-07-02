# Gestão de Riscos — Projeto EstocaBem

**Aluno:** Rodolfo Miranda
**Disciplina:** Gestão de Projetos — IFMG / Sistemas de Informação

## 1. Introdução

O gerenciamento de riscos é uma das áreas mais importantes da gestão de projetos.
Todo projeto convive com incertezas capazes de impactar prazo, custo, qualidade,
escopo, pessoas, comunicação e a satisfação do cliente. Uma abordagem estruturada de
riscos permite **reduzir perdas, aumentar a previsibilidade, melhorar a comunicação,
responder rápido a crises e proteger prazo, custo e qualidade**.

Adota-se aqui a definição usual: risco é *"um evento ou condição incerta que, se
ocorrer, terá impacto positivo ou negativo em um ou mais objetivos do projeto"*.
Ou seja, riscos não são só ameaças — também há oportunidades a explorar.

---

## 2. Descrição do Projeto

### 2.1 Projeto
Desenvolvimento do **EstocaBem**, sistema **web + mobile** de gestão de estoque,
vendas (PDV) e financeiro para micro e pequenas empresas do varejo.

### 2.2 Objetivo
Entregar uma plataforma integrada que controle estoque em tempo real, registre vendas
no balcão (inclusive **offline**, com sincronização posterior), gerencie o caixa e o
financeiro e forneça indicadores gerenciais, com conformidade à LGPD.

### 2.3 Principais Módulos
- Autenticação e controle de acesso (perfis: dono, gerente, vendedor);
- Cadastro de produtos e controle de estoque (estoque mínimo, curva ABC);
- PDV / vendas com múltiplos meios de pagamento (Pix, cartão, dinheiro);
- Financeiro / caixa (abertura/fechamento, sangria, contas a pagar/receber);
- Relatórios e dashboard gerencial;
- Integração com meios de pagamento e (opcional) emissão de NFC-e.

### 2.4 Prazo
Aproximadamente **3,5 meses** (73 dias úteis).

### 2.5 Equipe
1 gerente de projetos, 1 analista de requisitos, 1 arquiteto, 3 desenvolvedores
full-stack, 1 desenvolvedor mobile, 1 QA, 1 designer UX/UI e 1 DevOps.

### 2.6 Orçamento estimado
R$ 220.000,00 (equipe, infraestrutura em nuvem, licenças e reserva de contingência).

---

## 3. Análise SWOT do Projeto

A análise SWOT foi usada como uma das técnicas de **identificação de riscos** (forças
e fraquezas = fatores internos/controláveis; oportunidades e ameaças = fatores
externos). As ameaças e fraquezas alimentam diretamente o registro de riscos; as
forças e oportunidades embasam as estratégias de resposta.

| **FORÇAS (Strengths)** | **FRAQUEZAS (Weaknesses)** |
|---|---|
| Equipe técnica enxuta e integrada | Equipe pequena → baixa redundância (bus factor) |
| Escopo bem delimitado (MVP claro) | Pouca experiência prévia com sincronização offline |
| Stack moderna e conhecida pela equipe | Orçamento limitado, sem folga para grandes imprevistos |
| Arquitetura offline-first como diferencial | Dependência de poucos desenvolvedores-chave |
| **OPORTUNIDADES (Opportunities)** | **AMEAÇAS (Threats)** |
| Grande mercado de PMEs ainda sem sistema | Concorrentes consolidados (PDVs de mercado) |
| Popularização do Pix e pagamentos digitais | Mudanças regulatórias (fiscais/LGPD) |
| Baixa digitalização do varejo de bairro | Instabilidade de APIs de terceiros (pagamento) |
| Possibilidade de expandir para NFC-e e fidelidade | Cenário econômico e câmbio (custos de nuvem em USD) |

### 3.1 Cruzamentos estratégicos (transformando SWOT em ação)
- **FO (Forças + Oportunidades):** usar a arquitetura offline-first como diferencial
  de venda para o varejo de bairro com internet instável.
- **FA (Forças + Ameaças):** usar o escopo enxuto e a stack conhecida para lançar o
  MVP rápido, antes que concorrentes ampliem vantagem.
- **WO (Fraquezas + Oportunidades):** compensar a equipe pequena priorizando
  fortemente o backlog e usando o Pix (integração relativamente simples) para entregar
  valor cedo.
- **WT (Fraquezas + Ameaças):** mitigar defensivamente — documentação contínua
  (reduz dependência de pessoas-chave) e reserva de contingência (protege contra
  custos e imprevistos).

---

## 4. Conceitos Fundamentais de Risco

- **Probabilidade:** chance de o risco ocorrer.
- **Impacto:** consequência caso o risco aconteça.
- **Exposição ao risco:** `Exposição = Probabilidade × Impacto`.
- **Risco residual:** o que permanece mesmo após as ações de mitigação.
- **Risco secundário:** novo risco criado por uma ação de resposta.

### 4.1 Escala adotada
Para permitir a análise quantitativa, adoto escalas numéricas de 1 a 3:

| Nível | Probabilidade | Impacto |
|:-----:|:-------------:|:-------:|
| 1 (Baixo) | improvável (< 25%) | pequeno atraso/custo, contornável |
| 2 (Médio) | possível (25–60%) | atraso/custo relevante |
| 3 (Alto) | provável (> 60%) | compromete prazo, custo ou qualidade |

A **exposição** (P × I) classifica a severidade:
**1–2 = Aceitável**, **3–4 = Moderado**, **6–9 = Crítico**.

---

## 5. Categorias de Riscos

Técnicos · Cronograma · Financeiros · Recursos Humanos · Segurança da Informação ·
Jurídicos/Regulatórios · Fornecedores/Integrações · Operacionais · Infraestrutura ·
Requisitos/Escopo.

---

## 6. Processo de Gerenciamento de Riscos

1. **Planejar** — definir metodologia, responsáveis, ferramentas, frequência de
   revisão e critérios de severidade (esta seção 4/5).
2. **Identificar** — brainstorming com a equipe, entrevistas com lojistas, análise
   SWOT, checklists e histórico de projetos semelhantes.
3. **Análise qualitativa** — classificar por probabilidade, impacto e prioridade
   (matriz P × I).
4. **Análise quantitativa** — estimar exposição e impacto em dias/custo para os
   riscos críticos.
5. **Planejar respostas** — evitar, mitigar, transferir ou aceitar.
6. **Monitorar** — acompanhar riscos ativos, gatilhos, eficácia das respostas e
   novos riscos em reuniões semanais.

---

## 7. Matriz de Probabilidade e Impacto

Cada célula mostra a exposição (P × I). Verde = Aceitável, Amarelo = Moderado,
Vermelho = Crítico.

| P \ I | Impacto 1 | Impacto 2 | Impacto 3 |
|:-----:|:---------:|:---------:|:---------:|
| **Prob. 3 (Alta)** | 3 (Moderado) | 6 (Crítico) | 9 (Crítico) |
| **Prob. 2 (Média)** | 2 (Aceitável) | 4 (Moderado) | 6 (Crítico) |
| **Prob. 1 (Baixa)** | 1 (Aceitável) | 2 (Aceitável) | 3 (Moderado) |

---

## 8. Registro de Riscos (Risk Register)

| ID | Risco | Categoria | P | I | Exp. | Severidade | Estratégia | Resposta / Mitigação | Responsável |
|----|-------|-----------|:-:|:-:|:----:|:----------:|:----------:|----------------------|-------------|
| R01 | Complexidade da **sincronização offline** do PDV subestimada | Técnico | 3 | 3 | 9 | Crítico | Mitigar | Prova de conceito (PoC) na fase de arquitetura; biblioteca de sync consolidada; testes de conflito antecipados | Arquiteto |
| R02 | **Atraso no backend (A6)**, que está no caminho crítico | Cronograma | 3 | 3 | 9 | Crítico | Mitigar | Dividir em entregas semanais; priorizar módulos do caminho crítico; buffer de contingência | Gerente de Projetos |
| R03 | **Instabilidade/atraso na integração** de pagamento (Pix/TEF/gateway) | Fornecedores | 2 | 3 | 6 | Crítico | Mitigar/Transferir | Iniciar homologação cedo; ambiente sandbox; PSP alternativo como plano B | Líder técnico |
| R04 | **Vazamento/violação de dados** (dados financeiros e pessoais) | Segurança | 2 | 3 | 6 | Crítico | Mitigar | Criptografia em repouso/trânsito, RBAC, testes OWASP, auditoria de logs | DevOps/Segurança |
| R05 | **Não conformidade com a LGPD** | Jurídico | 2 | 3 | 6 | Crítico | Mitigar/Transferir | Consultoria jurídica; consentimento e anonimização; DPO responsável | Gerente de Projetos |
| R06 | **Saída de desenvolvedor-chave** (equipe pequena) | RH | 2 | 3 | 6 | Crítico | Mitigar | Documentação contínua, pair programming, versionamento e backup de conhecimento | Gerente de Projetos |
| R07 | **Scope creep** (NFC-e, fidelidade, multi-loja) | Escopo | 3 | 2 | 6 | Crítico | Evitar/Mitigar | Controle formal de mudanças; escopo do MVP congelado; backlog priorizado | Gerente de Projetos |
| R08 | **Estimativas otimistas** → estouro de cronograma | Cronograma | 3 | 2 | 6 | Crítico | Mitigar | Estimativa por 3 pontos; buffers; replanejamento em ondas | Gerente de Projetos |
| R09 | **Requisitos mal levantados** com os lojistas | Requisitos | 2 | 3 | 6 | Crítico | Mitigar | Protótipos validados cedo; homologação incremental com usuário | Analista de Requisitos |
| R10 | **Baixa performance** sob pico de vendas (ex.: datas comemorativas) | Técnico | 2 | 2 | 4 | Moderado | Mitigar | Cache (Redis), índices, testes de carga antes do go-live | Arquiteto |
| R11 | **Falha de infraestrutura / indisponibilidade** da nuvem | Infraestrutura | 1 | 3 | 3 | Moderado | Transferir/Mitigar | SLA do provedor, redundância, backups automáticos e plano de DR | DevOps |
| R12 | **Aumento de custo de nuvem** (câmbio/USD) estoura orçamento | Financeiro | 2 | 2 | 4 | Moderado | Mitigar | Reserva de contingência; monitorar consumo; otimizar recursos | Gerente de Projetos |
| R13 | **Baixa adesão dos lojistas** ao novo sistema (resistência a mudança) | Operacional | 2 | 2 | 4 | Moderado | Mitigar | Treinamento; UX simples no PDV; suporte próximo no piloto | Gerente de Projetos |
| R14 | **Perda de dados** por falha de backup | Infraestrutura | 1 | 3 | 3 | Moderado | Mitigar | Backups redundantes automatizados e testes de restauração | DevOps |
| R15 | **Fornecedor de gateway indisponível** no lançamento | Fornecedores | 1 | 2 | 2 | Aceitável | Aceitar/Transferir | Contrato com PSP alternativo; aceitar risco residual baixo | Líder técnico |

---

## 9. Exemplo Prático (risco em detalhe)

Aplicando o processo passo a passo ao risco mais severo, **R01 – Sincronização
offline do PDV**:

1. **Identificação:** *"A sincronização de vendas feitas offline pode gerar conflitos
   de dados (estoque negativo, venda duplicada) ao reconectar."*
2. **Causas:** arquitetura offline-first é complexa; equipe com pouca experiência no
   tema; múltiplos dispositivos vendendo o mesmo produto simultaneamente.
3. **Probabilidade:** Alta (3).
4. **Impacto:** Alto (3) — afeta a confiabilidade do estoque e do financeiro, coração
   do produto. **Exposição = 9 (Crítico).**
5. **Estratégia de mitigação (ações preventivas):**
   1. Fazer uma **prova de conceito** de sincronização já na fase de arquitetura (A3);
   2. Adotar biblioteca/algoritmo de resolução de conflitos consolidado (ex.:
      *last-write-wins* com fila e reconciliação por servidor);
   3. Definir regra de negócio clara para estoque em concorrência;
   4. Antecipar **testes de conflito** antes dos testes integrados (A12);
   5. Reuniões técnicas semanais de acompanhamento.
6. **Plano de contingência (se ocorrer):**
   1. Congelar temporariamente o modo offline e operar somente online;
   2. Priorizar a correção com o desenvolvedor mobile + arquiteto;
   3. Reprocessar manualmente as vendas conflitantes;
   4. Renegociar prazo parcial do piloto, se necessário.
7. **Responsável:** Arquiteto de software.
8. **Monitoramento (indicadores):** nº de conflitos por sincronização, tempo médio de
   reconciliação, divergências de estoque detectadas nos testes.

---

## 10. Estratégias de Resposta aos Riscos

- **Evitar** — eliminar o risco na origem. *Ex.:* tirar a emissão de NFC-e do MVP
  (R07) para não depender da homologação SEFAZ agora.
- **Mitigar** — reduzir probabilidade e/ou impacto. *Ex.:* PoC de sincronização (R01),
  testes de carga (R10).
- **Transferir** — repassar a responsabilidade a terceiros. *Ex.:* SLA/seguro de
  nuvem (R11), consultoria jurídica de LGPD (R05).
- **Aceitar** — conviver conscientemente com riscos de baixa exposição, mantendo
  reserva. *Ex.:* R15 (fornecedor de gateway).

---

## 11. Plano de Contingência (genérico)

Fluxo de acionamento quando um risco se concretiza:

1. **Detectar** o incidente (por indicador ou gatilho definido);
2. **Avaliar** a gravidade e a exposição real;
3. **Acionar** o responsável e a equipe pertinente;
4. **Executar** a contenção (ações emergenciais previstas);
5. **Restaurar** a operação normal;
6. **Revisar** a causa raiz e registrar lições aprendidas.

Cada plano define: ações emergenciais, responsáveis, comunicação, recursos
necessários e critérios de ativação.

---

## 12. Indicadores de Risco (KPIs)

- Quantidade de riscos ativos e de riscos **críticos** abertos;
- Custo consumido da **reserva de contingência**;
- Desvio de prazo acumulado (dias) frente à linha de base;
- Incidentes por sprint e taxa de retrabalho;
- Nº de riscos que se concretizaram × previstos (acurácia da identificação).

---

## 13. Comunicação dos Riscos

Toda comunicação de risco deve conter: descrição do risco, impacto, urgência, ações
tomadas, responsável e prazo de resolução. Os riscos são revisados semanalmente na
reunião de acompanhamento e registrados em planilha compartilhada / ferramenta de
gestão (ex.: Trello ou Jira).

---

## 14. Ferramentas Utilizadas

Planilha de registro de riscos, matriz de probabilidade × impacto, análise SWOT,
diagrama de Ishikawa (causa raiz), Trello/Jira para acompanhamento e reuniões
semanais de risco.

---

## 15. Boas Práticas e Lições Aprendidas

**Boas práticas:** monitorar riscos continuamente, manter o registro atualizado,
comunicar problemas cedo, manter reserva de contingência, priorizar os riscos
críticos e documentar tudo.

**Lições aprendidas (a registrar no encerramento):** documentar quais riscos se
concretizaram, avaliar a eficácia das respostas, registrar melhorias e alimentar o
histórico para os próximos projetos.

---

## 16. Conclusão

O EstocaBem apresenta um perfil de risco típico de sistema de varejo com dados
financeiros: os riscos mais severos concentram-se na **sincronização offline (R01)**,
no **caminho crítico do backend (R02)**, nas **integrações de pagamento (R03)** e na
**segurança/LGPD (R04/R05)**. A estratégia central é **mitigar cedo** (provas de
conceito, testes antecipados, homologação precoce com terceiros) e **transferir** o
que for possível (SLA de nuvem, consultoria jurídica), sempre sustentado por uma
reserva de contingência e por controle formal de mudanças para conter o *scope creep*.
Gerenciados dessa forma, os riscos deixam de ser incertezas paralisantes e passam a
ser decisões controladas — aumentando a probabilidade de sucesso do projeto.
