"""Vision Transformer (ViT) parametrizado para classificação de tumores cerebrais."""
import tensorflow as tf
from tensorflow.keras import layers


class PatchEncoder(layers.Layer):
    """Extrai patches da imagem via Conv2D, projeta em embed_dim e soma embedding posicional."""

    def __init__(self, patch_size, embed_dim, num_patches, **kwargs):
        super().__init__(**kwargs)
        self.projection = layers.Conv2D(embed_dim, kernel_size=patch_size, strides=patch_size)
        self.position_embedding = layers.Embedding(input_dim=num_patches, output_dim=embed_dim)

    def call(self, images):
        patches = self.projection(images)
        batch_size = tf.shape(patches)[0]
        patches = tf.reshape(patches, (batch_size, -1, patches.shape[-1]))
        positions = tf.range(start=0, limit=tf.shape(patches)[1], delta=1)
        return patches + self.position_embedding(positions)


def transformer_block(x, embed_dim, num_heads, mlp_dim, dropout_rate):
    attn_input = layers.LayerNormalization(epsilon=1e-6)(x)
    attn_output = layers.MultiHeadAttention(
        num_heads=num_heads, key_dim=embed_dim // num_heads, dropout=dropout_rate
    )(attn_input, attn_input)
    x = layers.Add()([x, attn_output])

    mlp_input = layers.LayerNormalization(epsilon=1e-6)(x)
    mlp_output = layers.Dense(mlp_dim, activation="gelu")(mlp_input)
    mlp_output = layers.Dropout(dropout_rate)(mlp_output)
    mlp_output = layers.Dense(embed_dim)(mlp_output)
    mlp_output = layers.Dropout(dropout_rate)(mlp_output)
    return layers.Add()([x, mlp_output])


def build_vit(
    input_shape=(128, 128, 1),
    num_classes=4,
    patch_size=16,
    embed_dim=128,
    num_heads=8,
    num_layers=8,
    mlp_dim=256,
    dropout_rate=0.0,
):
    num_patches = (input_shape[0] // patch_size) * (input_shape[1] // patch_size)

    inputs = layers.Input(shape=input_shape)
    x = PatchEncoder(patch_size, embed_dim, num_patches)(inputs)

    for _ in range(num_layers):
        x = transformer_block(x, embed_dim, num_heads, mlp_dim, dropout_rate)

    x = layers.LayerNormalization(epsilon=1e-6)(x)
    x = layers.GlobalAveragePooling1D()(x)
    if dropout_rate > 0:
        x = layers.Dropout(dropout_rate)(x)
    outputs = layers.Dense(num_classes, activation="softmax")(x)

    return tf.keras.Model(inputs, outputs, name="vit")
