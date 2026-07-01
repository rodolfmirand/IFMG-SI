# Trabalho Prático II — IA: Classificação de Tumores Cerebrais em RM

Classificação de imagens de ressonância magnética em 4 classes (glioma, meningioma, tumor
hipofisário, sem tumor) usando CNN e Vision Transformer (ViT), com 8 experimentos comparando
técnicas e hiperparâmetros. Ver [Trabalho II 2026.txt](Trabalho%20II%202026.txt) para o enunciado
completo e [report/relatorio.md](report/relatorio.md) para o relatório final.

## Ambiente

Projeto usa **Python 3.12** dedicado (TensorFlow não suporta o Python 3.14 do sistema) com
TensorFlow/Keras rodando em **CPU** (TensorFlow nativo no Windows perdeu suporte a GPU a partir
da 2.11).

```powershell
py -3.12 -m venv .venv
.\.venv\Scripts\python.exe -m pip install -r requirements.txt
```

## Dataset

[Brain Tumor MRI Dataset (Kaggle)](https://www.kaggle.com/datasets/masoudnickparvar/brain-tumor-mri-dataset/data) —
baixe o `.zip`, extraia e organize como:

```
data/
├── Training/{glioma,meningioma,notumor,pituitary}/*.jpg
└── Testing/{glioma,meningioma,notumor,pituitary}/*.jpg
```

## Execução

```powershell
# roda 1 experimento específico
.\.venv\Scripts\python.exe src\run_experiment.py --id C1

# roda todos os 8 experimentos
.\.venv\Scripts\python.exe src\run_experiment.py --all
```

Resultados (métricas, matrizes de confusão, curvas de treino) são salvos em `results/`.
