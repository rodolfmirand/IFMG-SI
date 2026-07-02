# Gestão da Qualidade e Testes de Software — Projeto EstocaBem

**Aluno:** Rodolfo Miranda
**Disciplina:** Gestão de Projetos — IFMG / Sistemas de Informação

## 0. Breve Descrição do Projeto

O **EstocaBem** é um sistema **web + mobile** de gestão de estoque, vendas (PDV) e
financeiro para micro e pequenas empresas do varejo (mercadinhos, papelarias,
petshops, lojas de roupa). Ele controla o estoque em tempo real, registra vendas no
balcão — inclusive **offline**, com sincronização posterior — gerencia o caixa e o
financeiro e fornece relatórios gerenciais, tudo em conformidade com a LGPD.

**Arquitetura resumida:** app mobile (Android) para o PDV, painel web para gestão, API
REST (backend), banco PostgreSQL, cache Redis, fila de sincronização e deploy em
nuvem com CI/CD. **Atores:** dono, gerente, vendedor e (indiretamente) o cliente
final. O objeto deste trabalho é o processo de **Garantia da Qualidade (QA)** e a
**validação** desse sistema antes da implantação.

---

## i. Plano de Qualidade

### i.1 Objetivos da qualidade
Garantir que o EstocaBem:
- atenda a 100% dos requisitos funcionais priorizados no MVP;
- mantenha **integridade do estoque e do caixa** (nunca vender sem baixar estoque,
  nunca duplicar venda na sincronização);
- esteja em conformidade com a **LGPD**;
- tenha disponibilidade ≥ **99,5%** e tempo de resposta < **1,5 s** (p95) nas
  operações do PDV;
- não apresente **defeitos críticos** em produção no go-live.

### i.2 Normas e referências adotadas
- **ISO/IEC 25010** (modelo de qualidade de produto de software);
- **ISO 9001** (gestão da qualidade de processo);
- **ISO/IEC 27001** (segurança da informação);
- **OWASP Top 10** e **OWASP ASVS** (segurança de aplicação);
- **LGPD** (Lei 13.709/2018);
- Boas práticas do **ISTQB** para o processo de testes.

### i.3 Papéis e responsabilidades
| Papel | Responsabilidade na qualidade |
|-------|-------------------------------|
| QA | Planeja, projeta e executa testes; reporta defeitos |
| Desenvolvedores | Testes unitários; correção de defeitos |
| Arquiteto | Revisão de design; testes de sincronização/performance |
| DevOps | Ambientes, segurança de infraestrutura, backups |
| Gerente de Projetos | Aprova critérios de aceite e o parecer Go/No-Go |

### i.4 Atividades de garantia (verificação x validação)
- **Verificação:** revisões de código, análise estática (SonarQube), revisão de
  requisitos e de design.
- **Validação:** testes funcionais, de integração, de sistema, de aceitação,
  segurança, performance e usabilidade.

---

## ii. Catálogo de Requisitos Funcionais

| ID | Requisito Funcional |
|----|---------------------|
| RF01 | Autenticar usuário e controlar sessão |
| RF02 | Gerenciar produtos (CRUD, SKU, código de barras, preço, custo) |
| RF03 | Controlar estoque (entrada, saída, ajuste, alerta de estoque mínimo) |
| RF04 | Registrar venda no PDV (carrinho, itens, desconto) |
| RF05 | Processar pagamento (dinheiro, Pix, cartão) |
| RF06 | Operar o PDV **offline** e **sincronizar** ao reconectar |
| RF07 | Gerenciar caixa (abertura, fechamento, sangria, suprimento) |
| RF08 | Gerenciar clientes e crediário/fiado |
| RF09 | Controlar financeiro (contas a pagar e a receber) |
| RF10 | Gerar relatórios e dashboard (mais vendidos, curva ABC, lucratividade) |
| RF11 | Controlar acesso por perfil (dono, gerente, vendedor) |
| RF12 | Emitir comprovante de venda (e, opcional, NFC-e) |

---

## iii. Catálogo de Requisitos Não Funcionais

| ID | Requisito Não Funcional |
|----|-------------------------|
| RNF01 | Disponibilidade mínima de 99,5% (mensal) |
| RNF02 | Tempo de resposta < 1,5 s (p95) nas operações do PDV |
| RNF03 | Criptografia AES-256 em repouso e TLS 1.3 em trânsito |
| RNF04 | Conformidade com a LGPD (consentimento, anonimização, exclusão) |
| RNF05 | Operação offline do PDV com sincronização confiável (sem duplicar/perder venda) |
| RNF06 | Backup diário automatizado; RPO ≤ 15 min e RTO ≤ 1 h |
| RNF07 | Registro de auditoria de ações sensíveis (venda, estorno, ajuste de estoque) |
| RNF08 | Escalabilidade horizontal para atender múltiplas lojas |
| RNF09 | Usabilidade: concluir uma venda simples no PDV em < 30 s |
| RNF10 | Compatibilidade: navegadores modernos e Android 8.0+ |

---

## iv. Matriz de Rastreabilidade de Requisitos

Permite verificar a **cobertura** de cada requisito por casos de teste.

| Requisito | Descrição | Casos de Teste | Status |
|-----------|-----------|----------------|:------:|
| RF01 | Autenticação | CT01, CT02 | Coberto |
| RF02 | Produtos | CT03 | Coberto |
| RF03 | Estoque | CT04, CT05 | Coberto |
| RF04 | Venda no PDV | CT06, CT07 | Coberto |
| RF05 | Pagamento | CT08, CT09 | Coberto |
| RF06 | Offline / sincronização | CT10, CT11, CT12 | Coberto |
| RF07 | Caixa | CT13 | Coberto |
| RF08 | Clientes / crediário | CT14 | Coberto |
| RF09 | Financeiro | CT15 | Coberto |
| RF10 | Relatórios | CT16 | Coberto |
| RF11 | Perfis / acesso | CT17, CT18 | Coberto |
| RF12 | Comprovante | CT19 | Coberto |
| RNF02 | Performance | PT01, PT02, PT03 | Coberto |
| RNF03/04/07 | Segurança / LGPD | ST01–ST10 | Coberto |
| RNF05 | Sincronização offline | CT10–CT12 | Coberto |
| RNF09 | Usabilidade | UT01–UT05 | Coberto |

---

## v. Critérios de Aceitação

**Venda no PDV (RF04/RF05):**
- Adicionar itens por código de barras ou busca;
- Aplicar desconto respeitando a permissão do perfil;
- Aceitar múltiplos meios de pagamento e calcular troco;
- **Baixar o estoque automaticamente** ao concluir a venda;
- Registrar a venda no caixa aberto e emitir comprovante.

**Operação offline (RF06/RNF05):**
- Permitir vender sem internet;
- Ao reconectar, sincronizar **sem duplicar** nem **perder** vendas;
- Resolver conflitos de estoque por regra definida (não permitir estoque negativo
  inconsistente);
- Exibir status de sincronização ao usuário.

**Controle de estoque (RF03):**
- Alertar quando o produto atingir o estoque mínimo;
- Impedir venda de item sem estoque (conforme configuração da loja);
- Registrar toda movimentação em auditoria.

**Controle de acesso (RF11):**
- Vendedor não acessa relatórios financeiros nem custos;
- Apenas gerente/dono autoriza estorno e ajuste de estoque.

**Segurança/LGPD (RNF03/04):**
- Dados sensíveis criptografados;
- Cliente pode solicitar exclusão/anonimização dos seus dados.

---

## vi. Plano Mestre de Testes

### vi.1 Objetivos
Validar funcionalidade, integração, segurança, desempenho, confiabilidade
(especialmente a sincronização offline) e conformidade regulatória do EstocaBem.

### vi.2 Escopo
Serão avaliados: app mobile (PDV), painel web, API/backend, banco de dados, fila de
sincronização e integrações de pagamento. **Fora de escopo:** emissão de NFC-e
(adiada para pós-MVP) e integração com e-commerce.

### vi.3 Tipos de teste
Unitários · Integração · Sistema · Aceitação (UAT) · Segurança · Performance ·
Usabilidade · Regressão.

### vi.4 Estratégia (pirâmide de testes)
Base de **testes unitários** (JUnit/Jest), camada de **integração** (Postman/REST
Assured), **E2E** (Cypress no web, Appium/Espresso no mobile), **segurança**
(OWASP ZAP) e **carga** (k6/JMeter). Testes exploratórios complementares.

### vi.5 Ambiente de testes
Ambiente de homologação isolado, com massa de dados sintética representativa
(3 lojas, ~5.000 produtos, ~50.000 vendas históricas). Dispositivos: 3 modelos
Android (8, 11 e 13) e navegadores Chrome/Firefox/Edge.

### vi.6 Critérios de entrada e saída
- **Entrada:** build implantado em homologação, requisitos aprovados, massa de dados
  carregada.
- **Saída (exit criteria):** 100% dos casos críticos aprovados, **zero defeitos
  críticos/altos abertos**, cobertura de requisitos = 100% e cobertura de código
  ≥ 80%.

### vi.7 Massa de dados
Dados sintéticos anonimizados: catálogo de produtos com códigos de barras válidos,
clientes fictícios, histórico de vendas e cenários de estoque baixo/zerado para
disparar as regras de negócio.

---

## vii. Casos de Teste

> Formato resumido: **Objetivo → Pré-condição → Entrada → Resultado esperado**.

**CT01 – Login válido (RF01).** Usuário cadastrado → credenciais corretas → acesso
concedido com perfil correspondente.

**CT02 – Login inválido / bloqueio (RF01).** Usuário cadastrado → senha errada 5×
→ conta temporariamente bloqueada e evento registrado em auditoria.

**CT03 – Cadastro de produto (RF02).** Perfil gerente → SKU único + código de barras
+ preço/custo → produto criado; SKU duplicado é rejeitado.

**CT04 – Entrada de estoque (RF03).** Produto existente → registrar entrada de 20 un.
→ saldo aumenta em 20 e movimentação fica na auditoria.

**CT05 – Alerta de estoque mínimo (RF03).** Produto com mínimo = 5 → venda deixa saldo
em 4 → sistema exibe alerta de reposição.

**CT06 – Venda simples no PDV (RF04).** Caixa aberto → 2 itens no carrinho, pagamento
em dinheiro → venda concluída, troco calculado, **estoque baixado**, comprovante
emitido.

**CT07 – Desconto sem permissão (RF04/RF11).** Perfil vendedor → tentar desconto acima
do limite → operação exige autorização do gerente.

**CT08 – Pagamento via Pix (RF05).** Venda pendente → gerar QR Pix → confirmação de
pagamento → venda concluída.

**CT09 – Pagamento recusado (RF05).** Cartão sem saldo → transação recusada → venda
**não** é concluída e estoque **não** é baixado.

**CT10 – Venda offline (RF06/RNF05).** Sem internet → concluir venda → venda gravada
localmente com status "pendente de sincronização".

**CT11 – Sincronização sem duplicar (RF06/RNF05).** 3 vendas offline → reconectar →
as 3 vendas sobem uma única vez; estoque reconciliado corretamente.

**CT12 – Conflito de estoque na sincronização (RF06/RNF05).** Dois dispositivos vendem
o último item offline → ao sincronizar → regra de conflito aplicada, sem estoque
negativo inconsistente; conflito registrado para o gerente.

**CT13 – Fechamento de caixa (RF07).** Caixa com vendas do dia → fechar caixa →
sistema confere valores e aponta divergência entre o contado e o esperado.

**CT14 – Venda no crediário/fiado (RF08).** Cliente com limite → venda a prazo →
saldo devedor atualizado; venda acima do limite é bloqueada.

**CT15 – Conta a pagar (RF09).** Lançar despesa com vencimento → aparece no fluxo de
caixa projetado e nas contas a pagar.

**CT16 – Relatório curva ABC (RF10).** Base com histórico → gerar curva ABC → produtos
classificados corretamente em A/B/C por faturamento.

**CT17 – Acesso negado a vendedor (RF11).** Perfil vendedor → tentar abrir relatório
financeiro → acesso negado.

**CT18 – Estorno restrito (RF11).** Perfil vendedor → tentar estornar venda → exige
autorização de gerente/dono.

**CT19 – Comprovante de venda (RF12).** Venda concluída → gerar comprovante →
documento com itens, total, forma de pagamento e data corretos.

*(Total de casos projetados no ciclo completo: 62 — os 19 acima são os
representativos; os demais são variações de borda: campos obrigatórios, valores
negativos, timeouts, permissões, etc.)*

---

## viii. Testes de Segurança (OWASP Top 10)

| ID | Categoria OWASP | Procedimento | Resultado esperado |
|----|-----------------|--------------|--------------------|
| ST01 | Broken Access Control | Vendedor tenta acessar endpoints de relatório/custo | Acesso negado (403) |
| ST02 | Cryptographic Failures | Inspecionar dados em repouso/trânsito | AES-256 e TLS 1.3 confirmados |
| ST03 | Injection (SQL) | Injeção em campos de busca/login | Bloqueado (queries parametrizadas) |
| ST04 | Insecure Design | Revisão de arquitetura e regras de negócio | Sem falhas de projeto críticas |
| ST05 | Security Misconfiguration | Varredura de configurações e headers | Configuração segura |
| ST06 | Vulnerable Components | SCA (Dependency Check/Snyk) | Sem CVEs críticos |
| ST07 | Authentication Failures | Força bruta / gestão de sessão | Rate limit e bloqueio ativos |
| ST08 | Software/Data Integrity | Validação de artefatos e pipeline CI/CD | Integridade garantida |
| ST09 | Logging & Monitoring | Verificar auditoria de ações sensíveis | Eventos registrados e monitorados |
| ST10 | SSRF | Tentativas de requisição interna indevida | Requisições bloqueadas |

Ferramentas: **OWASP ZAP, SonarQube, Dependency Check/Snyk**. Foco especial em
**controle de acesso por perfil** e proteção de **dados financeiros e pessoais**
(LGPD).

---

## ix. Testes de Performance

Metas calibradas para um SaaS de varejo de PMEs (múltiplas lojas, não milhões de
usuários simultâneos).

| ID | Teste | Meta / Cenário |
|----|-------|----------------|
| PT01 | Tempo de resposta (PDV) | p95 < 1,5 s ao concluir venda |
| PT02 | Throughput da API | ≥ 3.000 requisições/min |
| PT03 | Carga | 2.000 usuários simultâneos (≈ 400 lojas ativas) por 1 h |
| PT04 | Stress | Carga crescente até identificar o limite operacional |
| PT05 | Pico (spike) | Salto de 500 → 3.000 usuários (pico de fim de mês) |
| PT06 | Sincronização em lote | 1.000 vendas offline sincronizando de uma vez |

Ferramentas: **k6 / JMeter** (carga) e monitoramento com **Grafana/Prometheus**.

---

## x. Registro de Defeitos (Bug Tracking)

**Severidade:** Crítica · Alta · Média · Baixa. **Prioridade:** P1 (imediata) ·
P2 (alta) · P3 (média) · P4 (baixa).

| ID | Descrição | Severidade | Prioridade | Status |
|----|-----------|:----------:|:----------:|:------:|
| BUG001 | Venda offline duplicada após reconexão instável | Crítica | P1 | Corrigido |
| BUG002 | Estoque fica negativo em venda concorrente do mesmo item | Crítica | P1 | Corrigido |
| BUG003 | Fechamento de caixa não considera sangria do dia | Alta | P1 | Corrigido |
| BUG004 | Desconto acima do limite passa sem autorização do gerente | Alta | P2 | Corrigido |
| BUG005 | Sessão do vendedor não expira após inatividade | Alta | P2 | Corrigido |
| BUG006 | Relatório de curva ABC erra classificação com devoluções | Média | P3 | Corrigido |
| BUG007 | Pagamento recusado ainda baixa o estoque | Crítica | P1 | Corrigido |
| BUG008 | Lentidão do dashboard sob carga elevada (> 2 s) | Média | P3 | Corrigido |
| BUG009 | Comprovante exibe data em fuso incorreto | Baixa | P4 | Corrigido |
| BUG010 | Campo "custo" aceita valor negativo sem validação | Média | P3 | Aberto (P3, pós-MVP) |

---

## xi. Plano de Correção

| Defeito | Ação corretiva | Responsável | Prazo |
|---------|----------------|-------------|-------|
| BUG001 | Idempotência na sincronização (chave única por venda + fila) | Dev Mobile + Backend | 24 h |
| BUG002 | Reserva transacional de estoque + regra de conflito | Backend | 48 h |
| BUG003 | Corrigir cálculo de fechamento incluindo sangria/suprimento | Backend | 24 h |
| BUG004 | Validar limite de desconto por perfil no servidor | Backend | 24 h |
| BUG005 | Expiração de sessão/JWT por inatividade | Segurança | 24 h |
| BUG007 | Só baixar estoque após confirmação de pagamento | Backend | 24 h |
| BUG010 | Validação de valor ≥ 0 (agendado para o próximo sprint) | Backend | Pós-MVP |

Após correção, todos os itens P1/P2 passam por **reteste** e **teste de regressão**.

---

## xii. Relatório de Execução dos Testes

### xii.1 Resumo executivo
Foram executados testes funcionais, de integração, de segurança, de performance, de
sincronização offline e de usabilidade no ambiente de homologação.

### xii.2 Resultados por categoria
| Categoria | Executados | Aprovados | Reprovados |
|-----------|:----------:|:---------:|:----------:|
| Funcionais | 62 | 60 | 2 |
| Integração | 18 | 17 | 1 |
| Segurança | 10 | 10 | 0 |
| Performance | 6 | 6 | 0 |
| Usabilidade | 5 | 5 | 0 |
| **Total** | **101** | **98** | **3** |

### xii.3 Consolidação
- Total de testes: **101**
- Aprovados: **98**
- Reprovados: **3** (reprocessados após correção; 2 já reaprovados, 1 defeito baixo
  em aberto planejado para pós-MVP)
- **Taxa de sucesso = 97,03%**

---

## xiii. Métricas de Qualidade

**Cobertura de requisitos:**
`Cobertura = (Requisitos testados / Requisitos totais) × 100 = 100%`

**Cobertura de código:**
- Backend: 88% · Frontend web: 84% · App mobile: 82% · **Média ≈ 84,7%**

**Densidade de defeitos:**
`Densidade = Defeitos / KLOC = 10 / ~18 KLOC ≈ 0,56 defeitos por mil linhas`

**Defect Removal Efficiency (DRE):**
`DRE = (Defeitos removidos / Defeitos totais) × 100 = 9 / 10 × 100 = 90%`
*(1 defeito de baixa severidade permanece em aberto, planejado para o pós-MVP.)*

---

## xiv. Avaliação dos Testes

Os testes cobriram 100% dos requisitos e todos os fluxos críticos do PDV, do estoque e
do caixa. O ponto de maior atenção — a **sincronização offline** — teve seus dois
defeitos críticos (BUG001 e BUG002) identificados **antes** do go-live e corrigidos,
o que valida a estratégia de antecipar esses testes. A taxa de sucesso de **97%** e a
ausência de defeitos críticos/altos em aberto atendem aos critérios de saída do plano
mestre. Recomenda-se manter a suíte de regressão automatizada para os próximos
incrementos.

---

## xv. Avaliação da Segurança

Ferramentas utilizadas: **OWASP ZAP, SonarQube, Dependency Check e Snyk**.

| Categoria | Resultado |
|-----------|-----------|
| Broken Access Control | Aprovado |
| SQL Injection | Aprovado |
| XSS / CSRF | Aprovado |
| Cryptographic Failures (AES-256 / TLS 1.3) | Aprovado |
| Authentication Failures (rate limit / sessão) | Aprovado (após BUG005) |
| Vulnerable Components (SCA) | Aprovado |
| Logging & Monitoring / Auditoria | Aprovado |
| Conformidade LGPD (consentimento, anonimização, exclusão) | Aprovado |

**Conclusão:** sem vulnerabilidades críticas remanescentes. A falha de expiração de
sessão (BUG005) foi corrigida e revalidada.

---

## xvi. Avaliação de Performance

| Cenário | Meta | Resultado | Status |
|---------|------|-----------|:------:|
| Tempo de resposta PDV (p95) | < 1,5 s | 1,1 s | Aprovado |
| Throughput | ≥ 3.000 req/min | 3.600 req/min | Aprovado |
| Carga (2.000 usuários / 1 h) | estável | estável, p95 = 1,3 s | Aprovado |
| Stress (limite operacional) | identificar | ~4.500 usuários antes de degradar | Aprovado |
| Spike (500→3.000) | recuperar | recuperou em < 30 s | Aprovado |
| Sincronização em lote (1.000 vendas) | sem perda/duplicação | íntegra | Aprovado |

O sistema atende folgadamente à demanda projetada de PMEs, com margem até ~4.500
usuários simultâneos antes de degradação significativa.

---

## xvii. Avaliação de Usabilidade

**Participantes:** 12 usuários (donos, gerentes e vendedores de comércios reais).
**Método:** tarefas cronometradas no PDV + questionário **SUS (System Usability
Scale)**.

| Métrica | Meta | Resultado |
|---------|------|-----------|
| Concluir venda simples | < 30 s | 22 s (média) |
| Localizar produto por código de barras | < 10 s | 6 s |
| Fechar caixa | < 90 s | 74 s |
| **Pontuação SUS** | > 80 | **86,5 (Excelente)** |

Principais achados: os vendedores concluíram as vendas com facilidade; sugeriram
apenas aumentar o tamanho dos botões de forma de pagamento no PDV (ajuste de baixo
esforço, agendado).

---

## xviii. Relatório Final de Qualidade

Após a execução de todas as etapas de verificação e validação, o EstocaBem apresentou
resultados **compatíveis com os requisitos de negócio, segurança, desempenho,
confiabilidade e conformidade regulatória**. Foram identificadas 10 não conformidades
durante os testes; **9 foram corrigidas, retestadas e homologadas** e 1 (severidade
baixa, sem impacto operacional) foi planejada para o pós-MVP. Os indicadores de
qualidade ficaram **acima dos limites mínimos** definidos no Plano de Qualidade:
cobertura de requisitos de 100%, cobertura de código ≈ 85%, taxa de sucesso de 97% e
DRE de 90%.

---

## xix. Parecer Técnico de Homologação

### Checklist final
| Item | Status |
|------|:------:|
| Requisitos Funcionais | ✅ OK |
| Requisitos Não Funcionais | ✅ OK |
| Segurança | ✅ OK |
| Performance | ✅ OK |
| Usabilidade | ✅ OK |
| Sincronização offline (crítico) | ✅ OK |
| Conformidade LGPD | ✅ OK |
| Backup e recuperação (RPO/RTO) | ✅ OK |
| Documentação | ✅ OK |
| Treinamento | ✅ OK |

Pendência residual: **BUG010** (validação de custo negativo, severidade baixa, P3),
sem impacto nos fluxos críticos, agendada para o primeiro sprint pós-implantação.

---

## xx. Parecer Go / No-Go

Com base nos resultados:
- Cobertura de requisitos de **100%**;
- Taxa de sucesso dos testes de **97%**;
- **Ausência de vulnerabilidades críticas** e de defeitos críticos/altos em aberto;
- Cobertura de código ≈ **85%**; **DRE de 90%**;
- Aprovação nos testes de segurança, performance, usabilidade e, sobretudo, na
  **sincronização offline** (requisito mais arriscado do produto).

A equipe de Garantia da Qualidade recomenda:

# ✅ GO

para a implantação do **EstocaBem** em produção, iniciando pela **loja piloto**, com a
condição de que a pendência residual **BUG010** seja tratada no primeiro sprint
pós-go-live e de que o monitoramento (disponibilidade, tempo de resposta e conflitos
de sincronização) seja acompanhado de perto nas duas primeiras semanas.
