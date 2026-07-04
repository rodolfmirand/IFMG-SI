# Script do Vídeo — Classificação de Tumores Cerebrais em RM

> **Como usar:** leia em voz alta o texto normal. Trechos em *itálico* são instruções de tela — o que mostrar, não o que falar.

---

## PARTE 1 — Tema e dataset (≈ 1 min)

*[Abrir a pasta `data/` ou mostrar o Kaggle no navegador]*

Olá. Neste vídeo vou apresentar o Trabalho Prático II da disciplina de Inteligência Artificial.

O objetivo do trabalho é classificar imagens de ressonância magnética cerebral em quatro classes:
**glioma**, **meningioma**, **tumor hipofisário** — também chamado de pituitary — e **sem tumor**.

O dataset usado é o **Brain Tumor MRI Dataset**, disponível no Kaggle, com um total de **7.200 imagens**.
Ele já vem dividido em duas pastas: `Training`, com 5.600 imagens de treino, e `Testing`, com 1.600 imagens de teste,
sendo **400 imagens por classe** em cada divisão.

*[Mostrar as pastas `data/Training/glioma`, `data/Training/meningioma` etc. no explorador de arquivos]*

As imagens estão organizadas em subpastas por classe, o que permite carregá-las diretamente com o Keras.

---

## PARTE 2 — Ambiente e decisões técnicas (≈ 1 min)

*[Abrir `requirements.txt` no editor]*

Antes de falar do código, preciso explicar duas decisões de ambiente.

A primeira: o Python instalado no sistema é a versão 3.14, que é muito recente e ainda não tem suporte do TensorFlow.
Por isso, criei um ambiente virtual dedicado com **Python 3.12**, onde o TensorFlow funciona normalmente.

*[Mostrar o terminal com `.venv` ou o comando `py -3.12 -m venv .venv`]*

A segunda: o TensorFlow nativo no Windows perdeu suporte a aceleração por GPU a partir da versão 2.11.
Como o projeto usa TensorFlow 2.21 no Windows, **todo o treinamento rodou em CPU**.
Isso limitou o número de épocas que foi possível treinar em tempo razoável — detalho isso mais adiante.

As dependências principais são: `tensorflow`, `scikit-learn`, `numpy`, `pandas`, `matplotlib` e `pillow`.

---

## PARTE 3 — Pipeline de dados (≈ 1 min)

*[Abrir `src/data_pipeline.py`]*

O carregamento dos dados está em `src/data_pipeline.py`.

*[Mostrar a função `load_datasets`]*

Uso a função `image_dataset_from_directory` do Keras, que lê automaticamente as subpastas como classes.

Para o conjunto de treino, aplico um `validation_split` de 15% — ou seja, de 5.600 imagens, cerca de
4.760 vão para treino efetivo e 840 para validação durante o treinamento.
O conjunto de teste, com 1.600 imagens, fica completamente separado e só é usado na avaliação final.

Todas as imagens são convertidas para **escala de cinza** — ressonância magnética não tem informação de cor relevante —
redimensionadas para **128 por 128 pixels**, e os valores de pixel são normalizados para o intervalo de 0 a 1.

*[Mostrar a camada de augmentation no código]*

Para os experimentos que usam data augmentation, há uma camada opcional que aplica espelhamento horizontal,
rotação leve e zoom — técnica para aumentar a variedade efetiva dos dados de treino e reduzir overfitting.

---

## PARTE 4 — Os dois modelos (≈ 2–3 min)

### CNN

*[Abrir `src/models/cnn.py`]*

O primeiro modelo é uma **CNN — Rede Neural Convolucional**.

*[Destacar o loop `for filters in conv_filters`]*

A arquitetura tem **4 blocos convolucionais**. Cada bloco aplica uma camada `Conv2D` com kernel 3×3,
seguida de `BatchNormalization` para estabilizar o treinamento, `MaxPooling2D` para reduzir a dimensão espacial,
e opcionalmente `Dropout` para regularização.

*[Destacar `GlobalAveragePooling2D` e a camada `Dense` final]*

Depois dos quatro blocos, um `GlobalAveragePooling2D` faz a transição para a parte densa,
seguido de uma camada `Dense` e a saída `softmax` com 4 neurônios — um por classe.

O modelo é parametrizado: posso passar o número de filtros de cada bloco, o número de neurônios da camada densa,
a taxa de dropout e o coeficiente de regularização L2. Isso me permite criar variações do mesmo código
para os 4 experimentos CNN sem duplicar nada.

---

### ViT

*[Abrir `src/models/vit.py`]*

O segundo modelo é um **Vision Transformer — ViT**.

A ideia é diferente da CNN: em vez de usar janelas deslizantes para extrair features locais,
o ViT divide a imagem em patches fixos e trata cada patch como um "token", parecido com palavras em NLP.

*[Mostrar a classe `PatchEncoder`]*

A classe `PatchEncoder` extrai patches de 16×16 pixels usando uma `Conv2D` com stride igual ao tamanho do patch.
Com imagens de 128×128 e patches de 16×16, temos **64 patches por imagem**.
Cada patch é projetado em um vetor de 128 dimensões, e a isso somamos um **embedding posicional** —
sem ele, o modelo não saberia a ordem dos patches.

*[Mostrar a função `transformer_block`]*

Cada bloco Transformer aplica `MultiHeadAttention` — atenção com 8 cabeças — seguida de uma MLP,
ambas com conexões residuais e `LayerNormalization`. Isso é a arquitetura Transformer clássica,
aplicada aqui a patches de imagem em vez de palavras.

*[Mostrar `GlobalAveragePooling1D` e saída]*

No final, um `GlobalAveragePooling1D` agrega os 64 tokens em um único vetor, que vai para a saída `softmax`.

A diferença conceitual central é: **a CNN tem um viés indutivo embutido** — ela sabe que pixels próximos
se relacionam, e isso está "hard-coded" na operação de convolução. O ViT não tem esse viés: ele precisa
aprender essas relações espaciais a partir dos dados. Por isso, ViTs geralmente precisam de muito mais
dados ou de pré-treinamento em larga escala para competir com CNNs.

---

## PARTE 5 — Os 8 experimentos (≈ 2 min)

*[Abrir `src/experiments.py`]*

Os experimentos estão centralizados em `src/experiments.py`, em uma lista de configurações.

*[Mostrar a lista de dicts com os experimentos]*

São 8 experimentos no total — 4 com CNN e 4 com ViT — cada um variando um aspecto diferente:

Para a **CNN**:
- **C1** é o baseline: sem nenhuma regularização.
- **C2** adiciona Dropout de 0.5 — técnica de regularização que desativa neurônios aleatoriamente durante o treino.
- **C3** adiciona regularização L2 nos pesos e data augmentation nas imagens.
- **C4** combina tudo — dropout, L2 e augmentation — e ainda aumenta a capacidade do modelo,
  com mais filtros convolucionais e mais neurônios na camada densa.

Para o **ViT**:
- **V1** é o baseline, sem dropout.
- **V2** adiciona Dropout de 0.3 nas camadas de atenção e MLP.
- **V3** usa o otimizador AdamW com weight decay de 1e-4, mais data augmentation.
- **V4** combina dropout e weight decay e ainda aumenta a capacidade — mais dimensões de embedding,
  mais cabeças de atenção e mais camadas Transformer.

*[Abrir `src/run_experiment.py`]*

O script `run_experiment.py` orquestra tudo: recebe o ID de um experimento ou a flag `--all`,
treina o modelo com `EarlyStopping` de paciência 4 monitorando `val_loss`, avalia no conjunto de teste,
e salva as métricas, a matriz de confusão e as curvas de treino.

---

## PARTE 6 — Resultados (≈ 2 min)

*[Abrir `results/results.csv` ou mostrar a tabela do relatório]*

Esses foram os resultados dos 8 experimentos, avaliados no conjunto de teste held-out de 1.600 imagens.

As métricas usadas são acurácia, precisão, recall e F1-Score. Como o problema tem 4 classes,
todas foram calculadas como **média macro** — ou seja, calculo a métrica para cada classe separadamente
e tiro a média sem ponderar pelo tamanho da classe.

O melhor resultado foi do **C4 — CNN com mais capacidade e todas as técnicas de regularização combinadas**,
com 82,8% de acurácia e F1 de 0,820.

*[Mostrar a imagem `results/confusion_matrices/C4.png`]*

Aqui está a matriz de confusão do C4. Podemos ver que a maioria dos erros está entre meningioma
e as outras classes — essa é a classe mais difícil de classificar no dataset, o que é consistente
com a literatura médica, já que meningiomas têm aparência mais variável em RM.

Em todos os 4 pares comparáveis, a CNN superou o ViT — às vezes por margem pequena, às vezes por
20 pontos percentuais de acurácia. Isso era esperado: com apenas 4.760 imagens de treino e 10 épocas,
o ViT não teve dados nem tempo suficientes para superar o viés indutivo da CNN.

Outro dado importante: nenhum dos 8 experimentos disparou o `EarlyStopping` — todos usaram as 10 épocas
completas sem convergir. Isso indica que, com mais épocas disponíveis, os modelos ainda melhorariam.

---

## PARTE 7 — Conclusão (≈ 30 s)

A melhor abordagem foi a **C4** — CNN com dropout, regularização L2, data augmentation e maior capacidade,
com **82,8% de acurácia** no conjunto de teste.

A principal conclusão é que Vision Transformers precisam de mais dados ou de pré-treinamento
para competir com CNNs quando treinados do zero em datasets de tamanho moderado.
Também ficou claro que aumentar a capacidade do modelo só ajuda quando há orçamento de treinamento
suficiente para o modelo convergir — com poucas épocas, mais parâmetros podem atrasar a aprendizagem
em vez de acelerar.

Obrigado.

---

*[Fim do vídeo]*
