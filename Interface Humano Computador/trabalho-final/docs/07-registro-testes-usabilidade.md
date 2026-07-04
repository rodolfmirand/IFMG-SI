# Registro dos Testes de Usabilidade

Tarefa única (todos): cadastrar a tarefa "Entregar relatório" (categoria Trabalho,
prioridade Alta, prazo amanhã), localizá-la pelo **filtro de categoria** e marcá-la
como **concluída**. Caminho ótimo = 6 ações.

**Amostra final: 2 participantes** (mesmos das entrevistas). O enunciado pede 5 —
declarado como limitação de amostra no relatório final.

## Tabela-resumo

| Participante | Idade | Sucesso na tarefa | Principal dificuldade | Confundiu ícones | SUS |
|---|---|---|---|---|---|
| Júlia | 25 | ✅ concluiu | Abriu a aba **"Categorias"** (cadastro) ao tentar filtrar | Sim | 82,5 |
| Guilherme | 15 | ✅ concluiu | **Não localizou onde fica o filtro**; "não acostumado com esse tipo de filtro" | (não observado) | 55,0 |

> Métricas automáticas de tempo/ações (logger) e SEQ não foram registradas de forma
> confiável nestas sessões — tratado como limitação.

## Júlia (25 anos)

- **Perfil**: usa apps de organização com frequência; familiaridade tecnológica 3/5;
  já usou **Trello e Asana**.
- **Criação da tarefa**: concluída com sucesso, sem grandes problemas.
- **Etapa de filtrar por categoria**: em vez de usar o seletor de filtro na tela de
  tarefas, **abriu a aba "Categorias"** (que serve para *cadastrar* categorias, não
  para filtrar) — confusão entre "gerenciar categorias" e "filtrar por categoria".
- **Ícones**: confundiu os ícones de ação (editar/concluir) — confirma o Problema 2 da
  avaliação heurística.
- **SUS**: 82,5 (acima da média).

## Guilherme (15 anos)

- **Perfil**: já havia usado outro app de tarefas, que considerou "mais complexo".
- **Criação da tarefa**: concluída com sucesso.
- **Etapa de filtrar por categoria**: teve **muita dificuldade em localizar onde fica o
  filtro**; relatou "não estou acostumado com esse tipo de filtro".
- **SUS**: 55,0 (abaixo da média de 68).

## Padrões observados (2 participantes)

- **Ambos concluíram** a criação da tarefa — a funcionalidade central é usável.
- **Ambos tiveram dificuldade com o filtro de categoria**, de formas diferentes:
  a mais experiente (Júlia, 25) **confundiu o filtro com o cadastro** de categorias;
  o menos experiente (Guilherme, 15) **não encontrou** o filtro. Em conjunto, apontam
  para um problema de **descoberta/affordance** do filtro — não previsto na avaliação
  heurística (achado novo dos testes).
- **SUS médio: 68,75** (limiar do "acima da média"), com forte contraste entre os dois.

> Nota: no momento das gravações, o filtro de categoria tinha um bug (a seleção era
> reiniciada ao renderizar a lista), corrigido posteriormente. Isso pode ter agravado
> a dificuldade observada, mas os relatos foram sobre **localizar/identificar** o
> filtro, não sobre a seleção não surtir efeito.
