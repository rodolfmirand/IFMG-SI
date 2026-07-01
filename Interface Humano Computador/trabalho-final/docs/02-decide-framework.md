# Aplicação do Framework DECIDE — ListaFácil

> Framework conceitual de avaliação proposto por Preece et al. (2005), citado no
> artigo de referência `10559-28790-1-SM.pdf` (seção 3). Fornece uma checklist de
> seis etapas para planejar avaliações de IHC dirigidas por metas claras.

## 1. Determinar as metas (Determine goals)

A avaliação do **ListaFácil** busca:

- Verificar se a interface do software permite que usuários concluam a tarefa
  central (criar e concluir uma tarefa) de forma rápida e sem erros.
- Identificar violações às heurísticas de usabilidade de Nielsen presentes na
  interface atual.
- Levantar a percepção subjetiva de usuários reais sobre clareza, navegação e
  utilidade do sistema, via entrevistas.

## 2. Explorar as questões específicas (Explore the questions)

- Os usuários conseguem encontrar o botão de criar uma nova tarefa sem ajuda?
- Os ícones de "editar" e "concluir" são distinguíveis o suficiente?
- O usuário percebe que uma ação (salvar, excluir) teve efeito, mesmo sem
  feedback visual explícito?
- O formato de data exibido (`DD/MM`) é interpretado corretamente pelos usuários?
- Os usuários sentem falta de confirmação ao excluir uma tarefa ou categoria?
- Qual a opinião geral dos usuários sobre a utilidade e a navegação do sistema?

## 3. Escolher o paradigma de avaliação e as técnicas (Choose the evaluation paradigm)

Três técnicas complementares, todas envolvendo usuários ou especialistas:

| Técnica | Paradigma | O que revela |
|---|---|---|
| Avaliação Heurística (inspeção) | Inspeção por especialista | Problemas estruturais de design, sem precisar de usuários |
| Teste de usabilidade (observação direta) | Observação | Problemas reais enfrentados ao executar uma tarefa concreta |
| Entrevista semiestruturada | Investigação | Percepção subjetiva, expectativas e opiniões dos usuários |

## 4. Identificar as questões práticas (Identify practical issues)

- **Avaliador**: uma única pessoa (autor deste trabalho), assumindo o papel de
  Engenheiro de Usabilidade — a avaliação heurística será feita em duas passadas
  independentes para compensar a ausência de um segundo avaliador (ver
  [docs/06-avaliacao-heuristica.md](06-avaliacao-heuristica.md)).
- **Participantes**: 5 pessoas para os testes de usabilidade e 3 pessoas para as
  entrevistas (podem ser parcialmente sobrepostas ou não, conforme disponibilidade).
- **Recursos**: computador pessoal com navegador, software de gravação de tela/vídeo
  (testes) e de áudio (entrevistas), ferramenta de transcrição automática.
- **Prazo**: menos de uma semana — recrutamento de participantes deve começar no
  primeiro dia para não travar o cronograma.
- **Local**: sessões podem ser remotas (chamada de vídeo com compartilhamento de
  tela) ou presenciais, dependendo da disponibilidade dos participantes.

## 5. Decidir como lidar com as questões éticas (Decide how to deal with ethical issues)

- Todo participante (testes e entrevistas) assina o **TCLE — Termo de Consentimento
  Livre e Esclarecido** antes da sessão (ver
  [docs/03-tcle.md](03-tcle.md)), autorizando a gravação e o uso dos dados
  exclusivamente para fins acadêmicos deste trabalho.
- Nomes reais só aparecem no relatório com autorização explícita; por padrão,
  participantes são identificados como "Usuário 1", "Usuário 2" etc.
- Os vídeos e áudios ficam armazenados em local de acesso restrito (link
  compartilhado apenas com o professor da disciplina).
- Participantes podem interromper a sessão ou pedir exclusão dos seus dados a
  qualquer momento, sem prejuízo.

## 6. Avaliar, interpretar e apresentar os dados (Evaluate, interpret and present data)

- **Avaliação heurística**: dados qualitativos — heurística violada, local, gravidade
  (1–4), sugestão de solução — consolidados em uma tabela única.
- **Testes de usabilidade**: dados qualitativos e quantitativos simples — tempo até
  concluir a tarefa, número de erros/hesitações, sucesso ou não na conclusão —
  registrados por usuário e depois agregados por padrão recorrente.
- **Entrevistas**: transcrição completa, seguida de análise de conteúdo por
  identificação de padrões de resposta entre os 3 entrevistados (mesmo modelo usado
  na seção 4.2 do artigo de referência).
- **Triangulação**: ao final, os achados das três técnicas são cruzados — um
  problema identificado na inspeção heurística que também aparece nos testes e é
  mencionado nas entrevistas tem evidência mais forte do que um achado isolado.
  Essa correlação será apresentada em uma tabela-síntese no relatório final (ver
  [docs/09-relatorio-final-esqueleto.md](09-relatorio-final-esqueleto.md)), no
  mesmo espírito da seção 4.3 do artigo de referência.
- Limitações a declarar: amostra pequena (5+3 participantes), avaliador único nas
  heurísticas, possível viés se parte dos participantes for próxima do avaliador.
