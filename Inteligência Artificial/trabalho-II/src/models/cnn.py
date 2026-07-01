"""CNN parametrizada para classificação de tumores cerebrais."""
import tensorflow as tf
from tensorflow.keras import layers, regularizers


def build_cnn(
    input_shape=(128, 128, 1),
    num_classes=4,
    conv_filters=(32, 64, 128, 256),
    dense_units=256,
    dropout_rate=0.0,
    l2_reg=0.0,
):
    reg = regularizers.l2(l2_reg) if l2_reg > 0 else None

    inputs = layers.Input(shape=input_shape)
    x = inputs
    for filters in conv_filters:
        x = layers.Conv2D(filters, 3, padding="same", activation="relu", kernel_regularizer=reg)(x)
        x = layers.BatchNormalization()(x)
        x = layers.MaxPooling2D()(x)
        if dropout_rate > 0:
            x = layers.Dropout(dropout_rate / 2)(x)

    x = layers.GlobalAveragePooling2D()(x)
    x = layers.Dense(dense_units, activation="relu", kernel_regularizer=reg)(x)
    if dropout_rate > 0:
        x = layers.Dropout(dropout_rate)(x)
    outputs = layers.Dense(num_classes, activation="softmax")(x)

    return tf.keras.Model(inputs, outputs, name="cnn")
