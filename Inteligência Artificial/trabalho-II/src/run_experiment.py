"""CLI para treinar e avaliar os experimentos definidos em experiments.py."""
import argparse
import time

import tensorflow as tf

from data_pipeline import CLASS_NAMES, load_datasets
from experiments import EXPERIMENTS, get_experiment
from metrics_utils import evaluate, log_result, save_confusion_matrix, save_training_curves
from models.cnn import build_cnn
from models.vit import build_vit

EPOCHS = 10
PATIENCE = 4


def build_model(config):
    if config["model"] == "cnn":
        return build_cnn(**config["model_params"])
    if config["model"] == "vit":
        return build_vit(**config["model_params"])
    raise ValueError(f"Modelo desconhecido: {config['model']}")


def build_optimizer(config):
    if config["optimizer"] == "adamw":
        return tf.keras.optimizers.AdamW(learning_rate=1e-3, weight_decay=config["weight_decay"])
    return tf.keras.optimizers.Adam(learning_rate=1e-3)


def run_experiment(experiment_id, epochs=EPOCHS):
    config = get_experiment(experiment_id)
    print(f"\n=== Experimento {experiment_id}: {config['description']} ===")

    train_ds, val_ds, test_ds = load_datasets(use_augmentation=config["use_augmentation"])

    model = build_model(config)
    model.compile(
        optimizer=build_optimizer(config),
        loss="sparse_categorical_crossentropy",
        metrics=["accuracy"],
    )

    early_stop = tf.keras.callbacks.EarlyStopping(
        monitor="val_loss", patience=PATIENCE, restore_best_weights=True
    )

    start = time.time()
    history = model.fit(
        train_ds, validation_data=val_ds, epochs=epochs, callbacks=[early_stop], verbose=2
    )
    train_time_s = time.time() - start

    metrics, cm = evaluate(model, test_ds)
    print(f"Resultado {experiment_id}: {metrics}")

    save_confusion_matrix(cm, CLASS_NAMES, experiment_id)
    save_training_curves(history, experiment_id)
    log_result(
        experiment_id=experiment_id,
        technique=config["technique"],
        description=config["description"],
        params=config["model_params"],
        epochs_trained=len(history.history["loss"]),
        train_time_s=train_time_s,
        metrics=metrics,
    )
    return metrics


def main():
    parser = argparse.ArgumentParser()
    group = parser.add_mutually_exclusive_group(required=True)
    group.add_argument("--id", help="ID do experimento a rodar (ex: C1)")
    group.add_argument("--all", action="store_true", help="Roda todos os 8 experimentos")
    parser.add_argument("--epochs", type=int, default=EPOCHS)
    args = parser.parse_args()

    if args.all:
        for exp in EXPERIMENTS:
            run_experiment(exp["id"], epochs=args.epochs)
    else:
        run_experiment(args.id, epochs=args.epochs)


if __name__ == "__main__":
    main()
