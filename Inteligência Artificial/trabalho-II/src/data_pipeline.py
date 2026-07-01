"""Carregamento e pré-processamento do dataset Brain Tumor MRI."""
from pathlib import Path

import tensorflow as tf

DATA_DIR = Path(__file__).resolve().parent.parent / "data"
IMG_SIZE = (128, 128)
CLASS_NAMES = ["glioma", "meningioma", "notumor", "pituitary"]


def load_datasets(batch_size=32, validation_split=0.15, seed=42, use_augmentation=False):
    """Retorna (train_ds, val_ds, test_ds) normalizados e prontos para .fit()/.predict()."""
    train_ds = tf.keras.utils.image_dataset_from_directory(
        DATA_DIR / "Training",
        validation_split=validation_split,
        subset="training",
        seed=seed,
        image_size=IMG_SIZE,
        color_mode="grayscale",
        batch_size=batch_size,
        class_names=CLASS_NAMES,
    )
    val_ds = tf.keras.utils.image_dataset_from_directory(
        DATA_DIR / "Training",
        validation_split=validation_split,
        subset="validation",
        seed=seed,
        image_size=IMG_SIZE,
        color_mode="grayscale",
        batch_size=batch_size,
        class_names=CLASS_NAMES,
    )
    test_ds = tf.keras.utils.image_dataset_from_directory(
        DATA_DIR / "Testing",
        image_size=IMG_SIZE,
        color_mode="grayscale",
        batch_size=batch_size,
        shuffle=False,
        class_names=CLASS_NAMES,
    )

    normalize = tf.keras.layers.Rescaling(1.0 / 255)
    train_ds = train_ds.map(lambda x, y: (normalize(x), y))
    val_ds = val_ds.map(lambda x, y: (normalize(x), y))
    test_ds = test_ds.map(lambda x, y: (normalize(x), y))

    if use_augmentation:
        augment = tf.keras.Sequential([
            tf.keras.layers.RandomFlip("horizontal"),
            tf.keras.layers.RandomRotation(0.05),
            tf.keras.layers.RandomZoom(0.1),
        ])
        train_ds = train_ds.map(lambda x, y: (augment(x, training=True), y))

    train_ds = train_ds.prefetch(tf.data.AUTOTUNE)
    val_ds = val_ds.prefetch(tf.data.AUTOTUNE)
    test_ds = test_ds.prefetch(tf.data.AUTOTUNE)

    return train_ds, val_ds, test_ds
