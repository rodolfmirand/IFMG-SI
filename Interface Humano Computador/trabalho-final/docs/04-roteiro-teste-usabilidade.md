# Roteiro — Teste de Usabilidade (5 usuários)

Teste de usabilidade moderado, presencial ou remoto (com compartilhamento de tela),
seguindo boas práticas de IHC. O enunciado exige **uma única atividade** — por isso
o teste é organizado em torno de **uma tarefa-cenário coesa**, porém devidamente
instrumentada com métricas objetivas e subjetivas.

---

## 1. Objetivo do teste

Avaliar se um usuário representativo consegue, sem treinamento prévio, cadastrar e
concluir uma tarefa no ListaFácil, medindo **eficácia** (conclui?), **eficiência**
(quão rápido / com quantos passos?) e **satisfação** (como se sentiu?). Em paralelo,
observar se os problemas levantados na avaliação heurística
([docs/06](06-avaliacao-heuristica.md)) se manifestam com usuários reais.

## 2. Perfil desejado dos participantes (recrutamento)

- 5 participantes que representem o público-alvo (pessoas que organizam tarefas/
  estudos/trabalho no dia a dia).
- Variar familiaridade com tecnologia (ao menos 1 pouco familiarizado).
- Nenhum deve ter usado o ListaFácil antes.
- Registrar perfil no pré-teste (ver seção 4).

> Nota (Nielsen): 5 usuários já revelam ~85% dos problemas de usabilidade — por isso
> o número pedido é adequado.

## 3. Materiais e preparação (checklist do facilitador)

- [ ] [TCLE](03-tcle.md) impresso/digital pronto para assinatura.
- [ ] Software aberto no navegador no **estado inicial padrão** — rodar
      `resetSessionLog()` no console antes de cada participante para restaurar as
      4 tarefas de exemplo idênticas e zerar o log (ver seção 9). **Todos começam do
      mesmo estado**, senão as métricas ficam incomparáveis.
- [ ] Gravação de tela + áudio configurada e testada.
- [ ] Cronômetro (ou usar o logger de sessão automático — seção 9).
- [ ] Ficha de registro aberta ([docs/07](07-registro-testes-usabilidade.md)).
- [ ] Roteiro de fala (seção 6) em mãos.

## 4. Pré-teste — questionário de perfil (≈2 min)

1. Faixa etária: ( ) até 17 ( ) 18–25 ( ) 26–40 ( ) 41+
2. Com que frequência você usa apps/sites para organizar tarefas?
   ( ) nunca ( ) raramente ( ) às vezes ( ) frequentemente
3. Como você avalia sua familiaridade com tecnologia em geral?
   (1 nada familiar … 5 muito familiar)
4. Já usou algum app de lista de tarefas (Todoist, Google Tasks, Notion etc.)?
   ( ) não ( ) sim — qual? __________

## 5. Cenário e tarefa (a atividade única)

**Contextualização (ler para o participante):**
> "Imagine que você começou um novo semestre e decidiu usar o ListaFácil para se
> organizar. Você acabou de abrir o aplicativo pela primeira vez."

**Tarefa (objetivo único a cumprir):**
> "Cadastre uma tarefa chamada **'Entregar relatório'**, na categoria **'Trabalho'**,
> com **prioridade Alta** e **prazo para amanhã**. Em seguida, usando os filtros da
> tela de tarefas, **localize essa tarefa** e **marque-a como concluída**."

Essa tarefa única percorre o formulário completo (título, categoria, prioridade,
prazo), o uso de filtros e a ação de concluir — expondo naturalmente os problemas
propositais #2 (ícones parecidos), #6 (sem feedback ao salvar) e #7 (data ambígua).

**Caminho ótimo (para comparar eficiência):** 6 ações
`Nova tarefa → preencher 4 campos → Salvar → (filtrar) → concluir`.
Contar quantas ações a mais o participante executou.

> Se o professor exigir uma atividade estritamente atômica, use apenas a primeira
> metade ("cadastrar a tarefa") — o restante da instrumentação continua válido.

## 6. Roteiro de fala do facilitador (script)

**Abertura:**
> "Obrigado por participar. Quem está sendo avaliado é o *sistema*, não você — não
> existe resposta certa ou errada. Se algo for confuso, ótimo: é isso que queremos
> descobrir. Peço que **pense em voz alta**: fale o que está tentando fazer, o que
> espera que aconteça e o que te confunde. Não vou te ajudar durante a tarefa, só
> observar. Podemos começar?"

**Durante:** manter silêncio; se o participante travar por muito tempo, usar sondagens
neutras: *"O que você está pensando agora?"*, *"O que você esperava que acontecesse?"*.
Só intervir (e registrar como "assistência dada") se ele desistir por completo.

**Encerramento:** agradecer e passar às perguntas pós-tarefa (seção 7).

## 7. Instrumentos de medição

### 7.1 Métricas objetivas (o facilitador/observador anota)

| Métrica | Como medir |
|---|---|
| Sucesso na tarefa | Concluiu sozinho / com assistência / não concluiu |
| Tempo na tarefa (time-on-task) | Do início da tarefa até marcar como concluída (usar logger, seção 9) |
| Nº de ações / desvios | Ações executadas vs. caminho ótimo (6) |
| Erros | Cliques errados, campos preenchidos incorretamente, uso do ícone errado |
| Incidentes críticos | Momentos de confusão, hesitação longa, frustração explícita |

### 7.2 SEQ — Single Ease Question (logo após a tarefa)

> "De modo geral, quão fácil ou difícil foi realizar essa tarefa?"
> (1 = muito difícil … 7 = muito fácil)

### 7.3 Perguntas abertas de fechamento

1. Teve algum momento em que você ficou em dúvida sobre o que fazer? Qual?
2. Depois de clicar em "Salvar", você teve certeza de que a tarefa foi criada? Por quê?
3. Os botões de cada tarefa (editar/concluir/excluir) ficaram claros para você?
4. Algo te surpreendeu, positiva ou negativamente?

### 7.4 SUS — System Usability Scale (pós-sessão, 10 itens)

Responder de 1 (discordo totalmente) a 5 (concordo totalmente):

1. Acho que gostaria de usar este sistema com frequência.
2. Achei o sistema desnecessariamente complexo.
3. Achei o sistema fácil de usar.
4. Precisaria de apoio de um técnico para conseguir usar este sistema.
5. As funções do sistema estão bem integradas.
6. Achei o sistema muito inconsistente.
7. A maioria das pessoas aprenderia a usar este sistema rapidamente.
8. Achei o sistema atrapalhado/complicado de usar.
9. Senti-me confiante ao usar o sistema.
10. Precisei aprender muitas coisas antes de conseguir usar o sistema.

**Cálculo do SUS** (0–100): itens ímpares → (resposta − 1); itens pares →
(5 − resposta); some tudo e multiplique por 2,5. Referência: **≥ 68 = acima da média**.
(Tabela de cálculo pronta em [docs/07](07-registro-testes-usabilidade.md).)

## 8. Análise (após as 5 sessões)

- **Agregar métricas**: taxa média de sucesso, tempo médio, média de desvios, SEQ
  médio, SUS médio.
- **Padrões qualitativos**: agrupar incidentes críticos recorrentes entre os 5
  usuários (ex.: "3 de 5 confundiram o ícone de concluir com o de editar").
- **Cruzar com a heurística**: marcar quais problemas previstos na inspeção
  realmente apareceram nos testes — isso alimenta a triangulação
  ([docs/09](09-relatorio-final-esqueleto.md), seção 6).

## 9. Logger de sessão automático (opcional, recomendado)

O `app.js` inclui um registro invisível de eventos, que gera **tempo objetivo** e
**contagem de ações** sem enviesar o participante (nada muda na tela). No console do
navegador (F12):

- `startTask('Entregar relatório')` — marca o início da tarefa (chame ao dar a
  instrução ao participante).
- `endTask()` — marca o fim; imprime o tempo total e o nº de ações da tarefa.
- `exportSessionLog()` — imprime/baixa o log completo (eventos com timestamp) para
  anexar à ficha do participante.
- `resetSessionLog()` — zera o log **e restaura o estado inicial padrão** (as 4
  tarefas de exemplo idênticas); **rodar antes de cada participante**.
- `seedDemo()` — só restaura as 4 tarefas de exemplo (sem mexer no log), caso precise.

> **Estado inicial (mesmo para todos):** o app já abre com 4 tarefas de exemplo fixas
> (Reunião do grupo de TCC · Ler capítulo 3 de IHC · Enviar exercício de Cálculo ·
> Renovar livro na biblioteca — esta última concluída). Elas dão contexto realista e
> tornam significativo o passo de **localizar pelo filtro** (ao filtrar por "Trabalho",
> além da tarefa recém-criada aparece "Reunião do grupo de TCC"). Nenhuma delas é a
> tarefa que o participante deve criar.

Todos os dados por participante devem ser transcritos em
[docs/07-registro-testes-usabilidade.md](07-registro-testes-usabilidade.md) logo após
a sessão, junto do link do vídeo.
