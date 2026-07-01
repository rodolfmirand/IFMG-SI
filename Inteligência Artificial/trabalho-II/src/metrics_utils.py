"""Cálculo de métricas e logging dos resultados dos experimentos."""
import csv
from pathlib import Path

import matplotlib.pyplot as plt
import numpy as np
from sklearn.metrics import (
    ConfusionMatrixDisplay,
    accuracy_score,
    confusion_matrix,
    f1_score,
    precision_score,
    recall_score,
)

RESULTS_DIR = Path(__file__).resolve().parent.parent / "results"
RESULTS_CSV = RESULTS_DIR / "results.csv"
CSV_FIELDS = [
    "id", "technique", "description", "params", "epochs_trained", "train_time_s",
    "accuracy", "precision_macro", "recall_macro", "f1_macro",
]


def evaluate(model, test_ds):
    """Roda o modelo no conjunto de teste e calcula accuracy/precision/recall/F1 macro."""
    y_true = np.concatenate([y.numpy() for _, y in test_ds], axis=0)
    y_pred_probs = model.predict(test_ds, verbose=0)
    y_pred = np.argmax(y_pred_probs, axis=1)

    metrics = {
        "accuracy": accuracy_score(y_true, y_pred),
        "precision_macro": precision_score(y_true, y_pred, average="macro", zero_division=0),
        "recall_macro": recall_score(y_true, y_pred, average="macro", zero_division=0),
        "f1_macro": f1_score(y_true, y_pred, average="macro", zero_division=0),
    }
    cm = confusion_matrix(y_true, y_pred)
    return metrics, cm


def save_confusion_matrix(cm, class_names, experiment_id):
    out_dir = RESULTS_DIR / "confusion_matrices"
    out_dir.mkdir(parents=True, exist_ok=True)
    disp = ConfusionMatrixDisplay(confusion_matrix=cm, display_labels=class_names)
    disp.plot(cmap="Blues", xticks_rotation=45)
    plt.title(f"Matriz de confusão — {experiment_id}")
    plt.tight_layout()
    plt.savefig(out_dir / f"{experiment_id}.png")
    plt.close()


def save_training_curves(history, experiment_id):
    out_dir = RESULTS_DIR / "training_curves"
    out_dir.mkdir(parents=True, exist_ok=True)
    fig, axes = plt.subplots(1, 2, figsize=(10, 4))
    axes[0].plot(history.history["loss"], label="treino")
    axes[0].plot(history.history["val_loss"], label="validação")
    axes[0].set_title("Loss")
    axes[0].legend()
    axes[1].plot(history.history["accuracy"], label="treino")
    axes[1].plot(history.history["val_accuracy"], label="validação")
    axes[1].set_title("Acurácia")
    axes[1].legend()
    plt.suptitle(f"Curvas de treino — {experiment_id}")
    plt.tight_layout()
    plt.savefig(out_dir / f"{experiment_id}.png")
    plt.close(fig)


def log_result(experiment_id, technique, description, params, epochs_trained, train_time_s, metrics):
    RESULTS_DIR.mkdir(parents=True, exist_ok=True)
    is_new = not RESULTS_CSV.exists()
    with open(RESULTS_CSV, "a", newline="", encoding="utf-8") as f:
        writer = csv.DictWriter(f, fieldnames=CSV_FIELDS)
        if is_new:
            writer.writeheader()
        writer.writerow({
            "id": experiment_id,
            "technique": technique,
            "description": description,
            "params": params,
            "epochs_trained": epochs_trained,
            "train_time_s": round(train_time_s, 1),
            "accuracy": round(metrics["accuracy"], 4),
            "precision_macro": round(metrics["precision_macro"], 4),
            "recall_macro": round(metrics["recall_macro"], 4),
            "f1_macro": round(metrics["f1_macro"], 4),
        })
