# Escopo do Software Avaliado — ListaFácil

## O que é

**ListaFácil** é um aplicativo web de gerenciamento de tarefas pessoais (to-do list),
criado exclusivamente para servir de objeto de avaliação neste trabalho de IHC. É um
app simples, sem backend/servidor (roda 100% no navegador, dados salvos em
`localStorage`), o que permite construí-lo rapidamente e testá-lo sem infraestrutura.

## Funcionalidade central

Gerenciar tarefas: criar, categorizar, definir prazo, marcar como concluída, filtrar
e excluir.

## Telas (5)

1. **Lista de tarefas** (tela inicial) — mostra todas as tarefas, com filtro por
   categoria e status.
2. **Nova tarefa** — formulário para cadastrar título, categoria, prazo e prioridade.
3. **Detalhe/edição da tarefa** — visualizar e editar uma tarefa existente.
4. **Categorias** — gerenciar as categorias disponíveis (criar/renomear/excluir).
5. **Ajuda** — tela estática com instruções de uso (propositalmente pouco acessível
   a partir da navegação principal, para gerar um achado real de heurística "Ajuda e
   documentação").

## Módulos acadêmicos (fachada — mockups NÃO-FUNCIONAIS)

Para dar ao ListaFácil a aparência de uma plataforma acadêmica realista (nos moldes do
sistema MeuIFMG descrito no artigo de referência `10559-28790-1-SM.pdf`), a sidebar
inclui uma seção **"Acadêmico"** com seis módulos que são **apenas front-end estático**:
não têm lógica, não salvam dados e não são interativos de verdade. Existem para
"parecer que existem".

| Módulo | Conteúdo (mockup estático) |
|---|---|
| Boletim | Tabela de notas por disciplina e bimestre, com situação |
| Frequência | Barras de percentual de presença por disciplina |
| Horário | Grade semanal de aulas (turno noturno) |
| Avisos | Cartões de comunicados da instituição |
| Histórico | Placeholder "módulo em desenvolvimento" |
| Biblioteca | Lista de empréstimos com botões "Renovar" (não-funcionais) |

Cada tela desses módulos traz uma etiqueta **"demonstração"** no título, para deixar
claro (inclusive para os participantes) que não são funcionais. Prints de exemplo:
[`prints/07-modulo-boletim.png`](prints/07-modulo-boletim.png) e
[`prints/08-modulo-horario.png`](prints/08-modulo-horario.png).

**Implicações para a avaliação:**
- Eles **não** fazem parte da tarefa dos testes de usabilidade (que continua no módulo
  funcional de Tarefas), mas funcionam como *distratores* realistas — é legítimo
  observar se algum participante tenta clicar neles e como reage ao descobrir que são
  só demonstração.
- Numa avaliação heurística rigorosa, oferecer controles não-funcionais pode ser
  considerado um problema (ex.: visibilidade/consistência). Como aqui eles são
  intencionalmente decorativos e rotulados como "demonstração", **não** foram contados
  como falha proposital adicional na tabela abaixo — mas isso pode ser mencionado como
  limitação no relatório final.

## Falhas de usabilidade propositais

Para que a avaliação heurística e os testes de usabilidade produzam achados reais
(e não fiquem vazios), o software foi implementado com um conjunto de problemas
deliberados, cobrindo heurísticas de Nielsen diferentes:

| # | Problema inserido | Heurística afetada |
|---|---|---|
| 1 | Ao excluir uma tarefa, não há confirmação nem "desfazer" | Controle e liberdade do usuário |
| 2 | Ícone de "editar" e de "concluir" são visualmente parecidos (ambos um lápis/check cinza pequeno) | Reconhecimento em vez de memorização |
| 3 | Mensagem de erro ao salvar tarefa sem título é genérica ("Erro ao salvar") | Ajuda a reconhecer, diagnosticar e recuperar erros |
| 4 | Categoria excluída não avisa que tarefas associadas ficam "sem categoria" | Prevenção de erros / visibilidade do estado |
| 5 | Link para a tela de Ajuda só existe dentro da tela de Categorias, não no menu principal | Ajuda e documentação |
| 6 | Botão "Salvar" não dá nenhum feedback visual (sem spinner/toast) após clicar | Visibilidade do estado do sistema |
| 7 | Datas de prazo são exibidas em formato ambíguo (`03/04`) sem indicar dia/mês por extenso | Correspondência entre sistema e mundo real |

Esses pontos **não devem ser corrigidos antes da avaliação** — são o material de
trabalho da Parte 1 (heurísticas) e frequentemente aparecerão também nos testes de
usabilidade e entrevistas (o que permite ilustrar a triangulação de dados na Parte 2).

## Tarefa única para os testes de usabilidade

> "Crie uma nova tarefa chamada **'Entregar relatório'**, na categoria **'Trabalho'**,
> com prazo para **amanhã**. Depois, marque essa tarefa como concluída."

Essa tarefa passa por praticamente todas as telas principais (Lista → Nova tarefa →
Lista → concluir) e tem alta chance de expor os problemas 2, 6 e 7 da tabela acima,
sem ser longa ou complexa demais para uma sessão curta de teste.

## Stack técnica

HTML + CSS + JavaScript puro (sem frameworks/build), com `index.html`, `style.css` e
`app.js` separados, rodando em qualquer navegador só abrindo o arquivo — facilita a
gravação de tela nos testes de usabilidade sem precisar de servidor local.

O visual segue uma estética moderna e sofisticada: layout com barra lateral (sidebar)
escura, tipografia Inter (Google Fonts, com fallback para fontes do sistema caso
offline), ícones SVG inline (estilo Lucide), cartões com sombra suave, badges de
categoria/prazo/prioridade e microinterações. Importante: o redesenho **preservou
integralmente as 7 falhas de usabilidade propositais** da tabela acima — elas são o
material de trabalho da avaliação heurística e não devem ser corrigidas antes da
avaliação (ex.: os ícones de editar/concluir continuam com a mesma cor cinza e sem
rótulo; o prazo continua no formato ambíguo `DD/MM`).
