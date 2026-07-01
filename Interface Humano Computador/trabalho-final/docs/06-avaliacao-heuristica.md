# Avaliação Heurística — ListaFácil

Método: Avaliação Heurística de Nielsen (1994), 10 heurísticas, aplicado conforme
procedimento descrito em `INF1403_07_avaliacao_heuristica.pdf`:
para cada tela × heurística, quando violada, registrar localização (print),
heurística, justificativa, gravidade (1 cosmético a 4 catastrófico) e sugestão de
solução.

## Avaliadores e consolidação

O enunciado pede que "os dois membros da equipe" apliquem a avaliação. Como este
trabalho é individual, a inspeção foi feita em **duas passadas independentes**, em
momentos distintos, simulando dois avaliadores:

- **Avaliador 1**: passada focada em navegação e fluxo completo das tarefas.
- **Avaliador 2**: passada focada tela a tela, comparando cada elemento à lista
  das 10 heurísticas.

Os achados abaixo já estão **consolidados** (união dos dois, sem duplicatas;
nenhuma divergência de gravidade entre as duas passadas).

## Escala de gravidade

| Grau | Significado |
|---|---|
| 1 | Cosmético — não precisa ser corrigido a menos que sobre tempo |
| 2 | Pequeno — baixa prioridade |
| 3 | Grande — alta prioridade, muitos usuários ficarão insatisfeitos |
| 4 | Catastrófico — imperativo corrigir antes do lançamento |

---

## Problema 1 — Exclusão sem confirmação nem "desfazer"

- **Heurística violada**: 3. Controle e liberdade do usuário.
- **Tela/local**: Lista de tarefas, botão de excluir (ícone de lixeira).
- **Print**: [`prints/06a-antes-excluir.png`](prints/06a-antes-excluir.png) (antes)
  e [`prints/06b-depois-excluir-sem-confirmacao.png`](prints/06b-depois-excluir-sem-confirmacao.png) (depois).
- **Justificativa**: a tarefa "Entregar relatório" desaparece imediatamente ao
  clicar no ícone de lixeira, sem qualquer diálogo de confirmação ou opção de
  desfazer. Um clique acidental resulta em perda de dados permanente.
- **Gravidade**: 3 (grande) — a ação é irreversível e o elemento de clique é
  pequeno, próximo aos outros dois ícones de ação.
- **Sugestão de solução**: adicionar um diálogo de confirmação ("Excluir
  'Entregar relatório'? Esta ação não pode ser desfeita.") ou, preferencialmente,
  uma notificação temporária ("Tarefa excluída — Desfazer") por alguns segundos.

## Problema 2 — Ícones de "editar" e "concluir" pouco distinguíveis

- **Heurística violada**: 6. Reconhecimento em vez de memorização (relacionado
  também à heurística 4, consistência e padronização).
- **Tela/local**: Lista de tarefas, grupo de três ícones à direita de cada item.
- **Print**: [`prints/02b-icones-zoom.png`](prints/02b-icones-zoom.png).
- **Justificativa**: os três ícones de ação (editar ✎, concluir ✓, excluir 🗑)
  têm o mesmo tamanho, cor e peso visual, sem rótulos de texto visíveis, apenas
  `title` (tooltip, que não aparece em telas de toque). O ícone de editar (lápis) e
  o de concluir (check) ficam lado a lado e são fáceis de confundir num clique
  rápido.
- **Gravidade**: 3 (grande) — clicar em "editar" quando a intenção era "concluir"
  (ou vice-versa) é um erro de execução comum e frustrante, especialmente em
  telas pequenas.
- **Sugestão de solução**: diferenciar por cor (ex.: verde para concluir, azul
  para editar, vermelho para excluir) e aumentar o espaçamento entre os ícones;
  considerar adicionar rótulos de texto curtos.

## Problema 3 — Mensagem de erro genérica ao salvar tarefa sem título

- **Heurística violada**: 9. Ajudar os usuários a reconhecer, diagnosticar e se
  recuperar de erros.
- **Tela/local**: Tela "Nova tarefa", ao clicar em "Salvar" com o campo Título
  vazio.
- **Print**: [`prints/03-erro-generico.png`](prints/03-erro-generico.png).
- **Justificativa**: a mensagem exibida é apenas "Erro ao salvar", sem indicar
  qual campo está incorreto ou o que fazer para corrigir. O campo Título também
  não recebe nenhum destaque visual (borda vermelha, foco automático).
- **Gravidade**: 2 (pequeno) — o erro é recuperável, mas obriga o usuário a
  adivinhar a causa por tentativa e erro.
- **Sugestão de solução**: mensagem específica ("O campo Título é obrigatório")
  posicionada perto do campo, com destaque visual (borda vermelha) e foco
  automático no campo problemático.

## Problema 4 — Excluir categoria não avisa sobre tarefas associadas

- **Heurística violada**: 5. Prevenção de erros (e 1. Visibilidade do estado do
  sistema).
- **Tela/local**: Tela "Categorias", ao excluir uma categoria em uso.
- **Print**: [`prints/04-categorias.png`](prints/04-categorias.png).
- **Justificativa**: ao excluir uma categoria, todas as tarefas associadas a ela
  silenciosamente passam a exibir "sem categoria", sem qualquer aviso prévio
  sobre esse efeito colateral. O usuário pode não perceber a mudança até revisar
  a lista de tarefas depois.
- **Gravidade**: 3 (grande) — resulta em perda de informação organizacional sem
  que o usuário tenha sido avisado ou tenha dado consentimento explícito para
  esse efeito específico.
- **Sugestão de solução**: diálogo de confirmação informando quantas tarefas
  serão afetadas ("3 tarefas ficarão sem categoria. Continuar?").

## Problema 5 — Link de Ajuda escondido dentro de Categorias

- **Heurística violada**: 10. Ajuda e documentação.
- **Tela/local**: só existe um link "Ajuda" no rodapé da tela Categorias; não há
  nenhum acesso à ajuda a partir da tela principal (Lista de tarefas).
- **Print**: [`prints/04-categorias.png`](prints/04-categorias.png) (link no
  rodapé) e [`prints/05-ajuda.png`](prints/05-ajuda.png) (tela de destino).
- **Justificativa**: um usuário que precise de ajuda a partir da tela inicial (a
  mais usada) não tem nenhuma pista de que a ajuda existe, pois é preciso
  navegar até uma tela secundária (Categorias) para descobri-la.
- **Gravidade**: 2 (pequeno) — não impede o uso do sistema, mas reduz a
  capacidade de autoatendimento do usuário em caso de dúvida.
- **Sugestão de solução**: adicionar um ícone/link de ajuda visível no cabeçalho,
  presente em todas as telas.

## Problema 6 — Nenhum feedback visual ao salvar

- **Heurística violada**: 1. Visibilidade do estado do sistema.
- **Tela/local**: Tela "Nova tarefa" → botão "Salvar".
- **Print**: [`prints/02-lista-icones-e-data.png`](prints/02-lista-icones-e-data.png)
  (a tela volta direto para a lista, sem nenhuma mensagem de confirmação).
- **Justificativa**: ao clicar em "Salvar" com dados válidos, o sistema apenas
  retorna à lista de tarefas sem nenhuma indicação (toast, mensagem, destaque)
  de que a ação foi concluída com sucesso. O usuário precisa inferir o sucesso
  apenas pela presença do novo item na lista.
- **Gravidade**: 2 (pequeno) — a ação funciona, mas a ausência de feedback gera
  insegurança, especialmente para usuários menos experientes.
- **Sugestão de solução**: exibir uma notificação temporária ("Tarefa salva com
  sucesso") ao retornar para a lista.

## Problema 7 — Formato de data ambíguo

- **Heurística violada**: 2. Correspondência entre o sistema e o mundo real.
- **Tela/local**: Lista de tarefas, campo "prazo" de cada item (ex.: "prazo
  02/07").
- **Print**: [`prints/02-lista-icones-e-data.png`](prints/02-lista-icones-e-data.png).
- **Justificativa**: a data é exibida apenas como `DD/MM`, sem ano nem indicação
  textual, o que pode gerar ambiguidade (especialmente para usuários acostumados
  com o formato `MM/DD`) e não deixa claro se o prazo já passou ou é este ano.
- **Gravidade**: 1 (cosmético) — raramente causa erro grave, mas gera pequenas
  confusões pontuais.
- **Sugestão de solução**: exibir a data por extenso ou em formato inequívoco
  (ex.: "2 de julho" ou "02/07/2026"), e destacar visualmente prazos vencidos.

---

## Resumo consolidado

| # | Problema | Heurística | Gravidade |
|---|---|---|---|
| 1 | Exclusão sem confirmação | Controle e liberdade do usuário | 3 |
| 2 | Ícones editar/concluir parecidos | Reconhecimento em vez de memorização | 3 |
| 3 | Erro genérico ao salvar | Ajuda a reconhecer/diagnosticar erros | 2 |
| 4 | Exclusão de categoria sem aviso | Prevenção de erros | 3 |
| 5 | Ajuda de difícil acesso | Ajuda e documentação | 2 |
| 6 | Sem feedback ao salvar | Visibilidade do estado do sistema | 2 |
| 7 | Formato de data ambíguo | Correspondência com o mundo real | 1 |

**Pontos positivos observados**: navegação principal (Tarefas/Categorias) é
simples e consistente; filtros de categoria e status funcionam de forma
previsível; formulário de nova tarefa é curto e objetivo.
