# Guia da Sessão — Teste de Usabilidade + Entrevista (ListaFácil)

> **Como usar:** este é o guia para seguir **ao vivo, durante a gravação**. Cada
> sessão junta, com a mesma pessoa e em sequência, o **teste de usabilidade** e a
> **entrevista**. São **3 participantes** (P1, P2, P3), cada um faz as duas coisas.
> Duração estimada: **20–30 min** por pessoa.
>
> Consolida e substitui, para execução: TCLE ([03](03-tcle.md)), roteiro de teste
> ([04](04-roteiro-teste-usabilidade.md)), roteiro de entrevista
> ([05](05-roteiro-entrevista.md)) e as fichas de registro ([07](07-registro-testes-usabilidade.md),
> [08](08-registro-entrevistas.md)).
>
> **Observação de escopo:** o enunciado pede 5 testes; aqui serão **3** (mesmas
> pessoas das entrevistas). Declarar isso como limitação de amostra no relatório final.

---

## PARTE A — Preparação (fazer UMA vez, antes de tudo)

- [ ] Definir onde hospedar as mídias (ex.: Google Drive ou YouTube não-listado) e
      deixar a pasta pronta. **Nunca** commitar vídeos/áudios/TCLEs no GitHub.
- [ ] Abrir o software (`software/index.html` ou o link do GitHub Pages) e, no console
      do navegador (F12), rodar `resetSessionLog()` para deixar o **estado inicial
      idêntico** (as 4 tarefas de exemplo).
- [ ] Testar a **gravação de tela + áudio** (voz sua e do participante). Uma gravação
      única de tela+voz cobre o teste (vídeo) e, no trecho da entrevista, o áudio já
      atende o que o enunciado pede.
- [ ] Ter o **TCLE** ([03-tcle.md](03-tcle.md)) impresso ou em formulário digital.
- [ ] Ter este guia aberto e o **bloco de registro** (Parte C) à mão para anotar.

---

## PARTE B — Roteiro da sessão (repetir igual para P1, P2 e P3)

> 🗣️ = o que **falar** (pode ler em voz alta) · ✅ = o que **fazer** · ✍️ = **anotar**
> no bloco de registro do participante.

### Passo 0 — Boas-vindas e consentimento (antes de gravar)
🗣️ *"Oi! Obrigado por participar. Isso faz parte de um trabalho da faculdade de
Interação Humano-Computador. Vou te pedir para usar um app e depois te fazer algumas
perguntas. Quem está sendo avaliado é o **sistema**, não você — não tem resposta certa
ou errada."*
- [ ] ✅ Apresentar o **TCLE**, explicar e coletar a **assinatura**. Marcar **os dois**
      quadros (teste de usabilidade **e** entrevista), já que a pessoa fará ambos.

### Passo 1 — Iniciar a gravação
- [ ] ✅ Começar a **gravação de tela + áudio** agora.
- [ ] ✅ No console (F12), conferir/rodar `resetSessionLog()` para zerar tudo.
🗣️ *"Já estou gravando a tela e o áudio, tudo bem para você? A gravação é só para
análise do trabalho."* (confirmação verbal, além do TCLE)

### Passo 2 — Perfil (pré-teste, ~2 min)
🗣️ *"Antes de começar, só umas perguntas rápidas sobre você:"*
1. Faixa etária? ( ) até 17 ( ) 18–25 ( ) 26–40 ( ) 41+
2. Com que frequência usa apps/sites para organizar tarefas? (nunca / raramente / às vezes / frequentemente)
3. De 1 a 5, sua familiaridade com tecnologia?
4. Já usou algum app de lista de tarefas (Todoist, Google Tasks, Notion...)? Qual?
- [ ] ✍️ Anotar as respostas no bloco de registro.

### Passo 3 — Explicar o "pensar em voz alta"
🗣️ *"Agora você vai fazer uma tarefa no app. Por favor, **pense em voz alta**: vá
falando o que está tentando fazer, o que espera que aconteça e o que te confunde. Eu
**não vou te ajudar** durante a tarefa, só observar. Pode começar quando quiser."*
- [ ] ✅ No console, rodar `startTask('Entregar relatório')` no momento em que der a instrução.

### Passo 4 — A tarefa (ler o cenário e a tarefa)
🗣️ *"Imagine que você começou um novo semestre e vai usar o ListaFácil para se
organizar. Sua tarefa é:"*
> **"Cadastre uma tarefa chamada 'Entregar relatório', na categoria 'Trabalho', com
> prioridade Alta e prazo para amanhã. Depois, usando os filtros, localize essa tarefa
> e marque-a como concluída."**

Caminho ótimo = **6 ações**.

### Passo 5 — Observar (sem intervir)
Fique em silêncio. Só use sondagens neutras se a pessoa travar: *"O que você está
pensando agora?"*, *"O que esperava que acontecesse?"*. Só intervir (e anotar como
"assistência dada") se a pessoa desistir de vez.
- [ ] ✍️ Anotar: hesitações, cliques errados, **se confundiu os ícones** (editar/concluir),
      **se reparou/estranhou a data** (02/07), **se ficou em dúvida se salvou**.

### Passo 6 — Fim da tarefa
- [ ] ✅ Quando marcar a tarefa como concluída, rodar `endTask()` no console
      (imprime **tempo** e **nº de ações**).
- [ ] ✍️ Anotar tempo, nº de ações e se concluiu ( ) sozinho ( ) com ajuda ( ) não concluiu.

### Passo 7 — Reação imediata à tarefa (SEQ + sondas rápidas)
🗣️ *"De 1 a 7, quão fácil foi realizar essa tarefa?"* (1 = muito difícil, 7 = muito fácil)
🗣️ Perguntas rápidas (enquanto está fresco):
1. *"Teve algum momento em que você ficou em dúvida? Qual?"*
2. *"Depois de clicar em Salvar, você teve certeza de que a tarefa foi criada? Por quê?"*
3. *"Os três ícones de cada tarefa (editar/concluir/excluir) ficaram claros para você?"*
- [ ] ✍️ Anotar SEQ e respostas.

### Passo 8 — Entrevista semiestruturada
🗣️ *"Agora, umas perguntas mais abertas sobre sua impressão geral. Pode falar à
vontade."* (deixe a pessoa elaborar; use *"pode dar um exemplo?"*, *"por que acha isso?"*)
1. Você já usou apps de lista de tarefas antes? Como foi o ListaFácil em comparação?
2. O que achou da **interface**? É agradável? A linguagem/mensagens ficaram claras?
3. Conseguiu encontrar o que precisava com **facilidade**? Onde teve dificuldade?
4. As **funcionalidades** eram o que você esperava? Sentiu falta de algo?
5. O que achou da **navegação** entre as telas? Algo pareceu lento, confuso ou incerto?
6. No geral, o que achou do sistema? Alguma **sugestão** de melhoria?
- [ ] ✍️ Anotar padrões e **citações marcantes** (frases literais boas para o relatório).

### Passo 9 — SUS (questionário final, 10 itens)
🗣️ *"Por último, me diga o quanto concorda com cada frase, de 1 (discordo totalmente)
a 5 (concordo totalmente):"*
1. Gostaria de usar este sistema com frequência.
2. Achei o sistema desnecessariamente complexo.
3. Achei o sistema fácil de usar.
4. Precisaria de apoio técnico para conseguir usar.
5. As funções estão bem integradas.
6. Achei o sistema muito inconsistente.
7. A maioria das pessoas aprenderia a usar rapidamente.
8. Achei o sistema atrapalhado/complicado.
9. Senti-me confiante ao usar.
10. Precisei aprender muita coisa antes de conseguir usar.
- [ ] ✍️ Anotar as 10 respostas (cálculo depois).

### Passo 10 — Encerramento
🗣️ *"Era isso, muito obrigado! Sua ajuda foi super importante."*
- [ ] ✅ No console, rodar `exportSessionLog()` (baixa o `.json` com tempo e ações) e
      guardar junto do vídeo.
- [ ] ✅ **Parar a gravação** e salvar o arquivo com nome claro (ex.: `sessao-P1.mp4`).
- [ ] ✅ Subir o vídeo para a hospedagem e pegar o **link**.

### Passo 11 — Depois da sessão (fora da gravação)
- [ ] Transcrever o **trecho da entrevista** (áudio) com software de transcrição
      (ex.: Whisper, Otter.ai, transcrição do Google Docs) e guardar o texto/link.
- [ ] Preencher o **bloco de registro** do participante (Parte C).
- [ ] Rodar `resetSessionLog()` de novo antes do próximo participante.

---

## PARTE C — Bloco de registro (uma cópia por participante: P1, P2, P3)

> Copie este bloco 3 vezes (ou preencha as 3 colunas da tabela-resumo no fim).

### Participante JULIA

**Perfil:** idade 25 · frequência de uso ALTA · familiaridade (1–5) 3 · já usou app? SIM, TRELLO E ASANA

**Teste de usabilidade**
- Sucesso: (X) sozinho ( ) com ajuda ( ) não concluiu
- Tempo na tarefa (s): ____ · Nº de ações (ótimo 6): ____ · Erros: ____
- Confundiu ícones (editar/concluir)? SIM · Estranhou a data? ____ · Dúvida se salvou? ____
- Incidentes críticos / observações:
  -
- **SEQ (1–7):** ____
- Sondas: dúvida → ____ · teve certeza que salvou? → ____ · ícones claros? → ____

**Entrevista** (padrões + citações)
1. Experiência prévia / comparação:
2. Interface e linguagem:
3. Facilidade de encontrar / dificuldades:
4. Funcionalidades / o que faltou:
5. Navegação:
6. Opinião geral / sugestões:
- Citações marcantes: "____"

**SUS:** `1:__ 2:__ 3:__ 4:__ 5:__ 6:__ 7:__ 8:__ 9:__ 10:__`
Cálculo (0–100): ímpares (r−1) + pares (5−r), somar e ×2,5 → **SUS = ____**

**Links:** vídeo → ____ · transcrição da entrevista → ____ · log `.json` → ____

---

## PARTE D — Síntese (depois dos 3)

| | P1 | P2 | P3 | Média |
|---|---|---|---|---|
| Sucesso | | | | — |
| Tempo (s) | | | | |
| Ações (ótimo 6) | | | | |
| SEQ (1–7) | | | | |
| SUS (0–100) | | | | |

**Padrões entre os 3 (quantos tiveram cada problema):**
- Confundiram ícone concluir/editar (heur. #2): ___/3
- Inseguros se salvou (heur. #6): ___/3
- Estranharam a data (heur. #7): ___/3
- Outros achados recorrentes:

**Principais falas da entrevista (por tema):**
-

> Esses padrões alimentam a **triangulação** com a avaliação heurística
> ([06](06-avaliacao-heuristica.md)) no relatório final
> ([09](09-relatorio-final-esqueleto.md)).
