# Índice — Trabalho Final de IHC

Ordem sugerida de leitura/uso, seguindo o cronograma do plano:

| Arquivo | O que é | Status |
|---|---|---|
| [00-escopo-software.md](00-escopo-software.md) | Descrição do software ListaFácil e suas falhas propositais | Pronto |
| [../software/](../software/) | Código-fonte do app (`index.html`, `style.css`, `app.js`) | Pronto |
| [02-decide-framework.md](02-decide-framework.md) | As 6 etapas do framework DECIDE aplicadas | Pronto |
| [03-tcle.md](03-tcle.md) | Modelo do Termo de Consentimento (TCLE) | Pronto — usar em cada sessão |
| [04-roteiro-teste-usabilidade.md](04-roteiro-teste-usabilidade.md) | Roteiro dos 5 testes de usabilidade | Pronto |
| [05-roteiro-entrevista.md](05-roteiro-entrevista.md) | Roteiro das 3 entrevistas semiestruturadas | Pronto |
| [06-avaliacao-heuristica.md](06-avaliacao-heuristica.md) | Avaliação heurística completa (10 heurísticas de Nielsen) com prints reais | Pronto |
| [prints/](prints/) | Capturas de tela reais do software usadas na avaliação heurística | Pronto |
| [07-registro-testes-usabilidade.md](07-registro-testes-usabilidade.md) | Template para registrar os 5 testes reais | **A preencher com participantes reais** |
| [08-registro-entrevistas.md](08-registro-entrevistas.md) | Template para registrar as 3 entrevistas reais | **A preencher com participantes reais** |
| [09-relatorio-final-esqueleto.md](09-relatorio-final-esqueleto.md) | Esqueleto do relatório final, com checklist de entrega | **A finalizar após dados reais → exportar em PDF** |

## O que já está pronto (não depende de pessoas)

- Software funcional (`software/`).
- Framework DECIDE documentado.
- Avaliação heurística completa, com prints reais e sugestões de solução.
- TCLE e roteiros de teste/entrevista prontos para uso.

## O que falta (depende de recrutar pessoas reais — ver plano)

- Rodar os 5 testes de usabilidade gravados em vídeo e preencher
  [07-registro-testes-usabilidade.md](07-registro-testes-usabilidade.md).
- Rodar as 3 entrevistas gravadas em áudio, transcrever e preencher
  [08-registro-entrevistas.md](08-registro-entrevistas.md).
- Preencher a triangulação e exportar o
  [relatório final](09-relatorio-final-esqueleto.md) em PDF.
- Enviar pelo Moodle.

## Como abrir o software

Abra `software/index.html` diretamente no navegador (não precisa de servidor),
ou sirva a pasta com qualquer servidor estático (ex.: `npx http-server software`)
para gravar a tela durante os testes de usabilidade.
