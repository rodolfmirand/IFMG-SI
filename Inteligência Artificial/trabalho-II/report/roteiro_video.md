# Roteiro sugerido para o vídeo

Pontos a cobrir, na ordem (tempo total estimado: 6-10 min):

1. **Tema e dataset (1 min)** — Classificação de tumores cerebrais em RM, 4 classes, dataset do
   Kaggle (7.200 imagens, `data/Training`/`data/Testing`).

2. **Ambiente e decisão técnica (1 min)** — Por que Python 3.12 dedicado (Python 3.14 do sistema
   não tem TensorFlow ainda) e por que o treino roda em CPU (TensorFlow nativo no Windows perdeu
   suporte a GPU a partir da 2.11). Mostrar `requirements.txt` e a venv.

3. **Pipeline de dados (1 min)** — Mostrar [`src/data_pipeline.py`](../src/data_pipeline.py):
   `image_dataset_from_directory`, grayscale 96×96, normalização, split treino/validação/teste,
   camada de augmentation opcional.

4. **Os dois modelos (2-3 min)** — Mostrar [`src/models/cnn.py`](../src/models/cnn.py) (blocos
   Conv2D+MaxPooling, Dropout, L2) e [`src/models/vit.py`](../src/models/vit.py) (patch embedding,
   `MultiHeadAttention`, blocos residuais). Explicar a diferença conceitual entre as duas
   abordagens.

5. **Os 8 experimentos (2 min)** — Mostrar a tabela de [`src/experiments.py`](../src/experiments.py)
   e explicar o que cada um varia (técnica, dropout, L2/weight decay, augmentation, capacidade).

6. **Resultados (2 min)** — Mostrar a tabela de [`results/results.csv`](../results/results.csv) e
   a matriz de confusão do melhor experimento (`results/confusion_matrices/C4.png`). Destacar:
   CNN > ViT neste dataset, e por quê (ver seção 6 do [relatório](relatorio.md)).

7. **Conclusão (30s)** — Melhor abordagem (C4 — CNN tuned com dropout+L2+augmentation+mais
   capacidade) e a principal conjectura (ViT precisa de mais dados/épocas para superar CNN
   treinada do zero; mais capacidade na CNN só ajudou porque havia orçamento de épocas suficiente
   para convergir).
