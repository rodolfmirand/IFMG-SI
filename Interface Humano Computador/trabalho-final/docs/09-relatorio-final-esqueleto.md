# Relatório Final — Avaliação de Usabilidade do ListaFácil

> Esqueleto pronto para exportação em PDF. Preencher os campos marcados com
> `[PREENCHER]` após concluir os testes e entrevistas reais. As seções já escritas
> (DECIDE e Avaliação Heurística) podem ser copiadas diretamente dos arquivos
> indicados.

## 1. Introdução

[PREENCHER: nome dos autores, disciplina, professor, e um parágrafo
descrevendo o ListaFácil e o objetivo da avaliação — ver
[docs/00-escopo-software.md](00-escopo-software.md)]

## 2. Aplicação do Framework DECIDE

Copiar o conteúdo de [docs/02-decide-framework.md](02-decide-framework.md).

## 3. Avaliação Heurística

Copiar o conteúdo de [docs/06-avaliacao-heuristica.md](06-avaliacao-heuristica.md),
incluindo os prints da pasta [docs/prints/](prints/).

## 4. Testes de Usabilidade

- Metodologia, cenário e instrumentos (think-aloud, SEQ, SUS, métricas objetivas):
  ver [docs/04-roteiro-teste-usabilidade.md](04-roteiro-teste-usabilidade.md).
- Resultados por usuário, métricas agregadas (taxa de sucesso, tempo médio, ações vs.
  caminho ótimo, SEQ médio, **SUS médio**) e padrões de incidentes críticos: copiar de
  [docs/07-registro-testes-usabilidade.md](07-registro-testes-usabilidade.md)
  (preencher antes com os dados reais).
- Anexar os logs de sessão (`.json` exportados pelo logger) e o link dos 5 vídeos.

## 5. Entrevistas Semiestruturadas

- Roteiro: ver [docs/05-roteiro-entrevista.md](05-roteiro-entrevista.md).
- Análise por pergunta: copiar de
  [docs/08-registro-entrevistas.md](08-registro-entrevistas.md) (preencher antes).
- Incluir links das 3 transcrições.

## 6. Triangulação dos Dados

[PREENCHER — após ter os dados reais de testes e entrevistas]

Cruzar os achados das três técnicas numa tabela como a abaixo (modelo inspirado
na seção 4.3 do artigo de referência `10559-28790-1-SM.pdf`, que correlaciona
pontuação de questionário com relatos de entrevista):

| Problema | Heurística (achado da inspeção) | Confirmado nos testes? | Mencionado nas entrevistas? | Evidência |
|---|---|---|---|---|
| Exclusão sem confirmação | Sim (grau 3) | [PREENCHER] | [PREENCHER] | [PREENCHER] |
| Ícones editar/concluir parecidos | Sim (grau 3) | [PREENCHER] | [PREENCHER] | [PREENCHER] |
| Erro genérico ao salvar | Sim (grau 2) | [PREENCHER] | [PREENCHER] | [PREENCHER] |
| Exclusão de categoria sem aviso | Sim (grau 3) | [PREENCHER] | [PREENCHER] | [PREENCHER] |
| Ajuda pouco acessível | Sim (grau 2) | [PREENCHER] | [PREENCHER] | [PREENCHER] |
| Sem feedback ao salvar | Sim (grau 2) | [PREENCHER] | [PREENCHER] | [PREENCHER] |
| Formato de data ambíguo | Sim (grau 1) | [PREENCHER] | [PREENCHER] | [PREENCHER] |

Discutir: problemas confirmados pelas três técnicas têm evidência mais forte;
problemas encontrados só na inspeção podem ser falsos positivos (o especialista
viu um risco que na prática não incomodou os usuários); problemas relatados só
nas entrevistas/testes e não previstos na inspeção heurística revelam limitações
do checklist de heurísticas.

## 7. Conclusão e Recomendações

[PREENCHER — sintetizar os principais problemas por prioridade (gravidade ×
confirmação cruzada) e as soluções sugeridas. Declarar limitações do estudo:
amostra pequena (5 testes + 3 entrevistas), avaliador único na inspeção
heurística (compensado com duas passadas), possível viés se participantes forem
próximos do avaliador.]

## 8. Anexos

- TCLEs assinados (anonimizados ou não, conforme autorização de cada
  participante) — ver modelo em [docs/03-tcle.md](03-tcle.md).
- Links para os 5 vídeos dos testes de usabilidade.
- Links para as 3 transcrições das entrevistas.
- Código-fonte do software avaliado: pasta [software/](../software/).

---

## Checklist de entrega (Moodle)

- [ ] Relatório completo exportado em PDF (a partir deste arquivo).
- [ ] Links de vídeo (testes) — verificar que estão acessíveis (não apenas "só eu
      tenho acesso").
- [ ] Links de transcrição (entrevistas) — verificar acesso.
- [ ] TCLEs de todos os 8 participantes (5 testes + 3 entrevistas) coletados.
- [ ] Enviado pelo sistema Moodle dentro do prazo.
