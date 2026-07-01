"""Configuração dos 8 experimentos: C1-C4 (CNN) e V1-V4 (Vision Transformer)."""

EXPERIMENTS = [
    {
        "id": "C1",
        "technique": "CNN",
        "description": "CNN baseline, sem regularização",
        "model": "cnn",
        "model_params": {"conv_filters": (32, 64, 128, 256), "dense_units": 256, "dropout_rate": 0.0, "l2_reg": 0.0},
        "use_augmentation": False,
        "optimizer": "adam",
        "weight_decay": 0.0,
    },
    {
        "id": "C2",
        "technique": "CNN",
        "description": "CNN + Dropout (0.5)",
        "model": "cnn",
        "model_params": {"conv_filters": (32, 64, 128, 256), "dense_units": 256, "dropout_rate": 0.5, "l2_reg": 0.0},
        "use_augmentation": False,
        "optimizer": "adam",
        "weight_decay": 0.0,
    },
    {
        "id": "C3",
        "technique": "CNN",
        "description": "CNN + L2 (1e-4) + Data Augmentation",
        "model": "cnn",
        "model_params": {"conv_filters": (32, 64, 128, 256), "dense_units": 256, "dropout_rate": 0.0, "l2_reg": 1e-4},
        "use_augmentation": True,
        "optimizer": "adam",
        "weight_decay": 0.0,
    },
    {
        "id": "C4",
        "technique": "CNN",
        "description": "CNN tuned: dropout + L2 + augmentation + mais filtros/neurônios",
        "model": "cnn",
        "model_params": {"conv_filters": (48, 96, 192, 384), "dense_units": 384, "dropout_rate": 0.3, "l2_reg": 1e-4},
        "use_augmentation": True,
        "optimizer": "adam",
        "weight_decay": 0.0,
    },
    {
        "id": "V1",
        "technique": "ViT",
        "description": "ViT baseline, sem dropout",
        "model": "vit",
        "model_params": {"patch_size": 16, "embed_dim": 128, "num_heads": 8, "num_layers": 8, "mlp_dim": 256, "dropout_rate": 0.0},
        "use_augmentation": False,
        "optimizer": "adam",
        "weight_decay": 0.0,
    },
    {
        "id": "V2",
        "technique": "ViT",
        "description": "ViT + Dropout (0.3) em atenção e MLP",
        "model": "vit",
        "model_params": {"patch_size": 16, "embed_dim": 128, "num_heads": 8, "num_layers": 8, "mlp_dim": 256, "dropout_rate": 0.3},
        "use_augmentation": False,
        "optimizer": "adam",
        "weight_decay": 0.0,
    },
    {
        "id": "V3",
        "technique": "ViT",
        "description": "ViT + weight decay (AdamW) + Data Augmentation",
        "model": "vit",
        "model_params": {"patch_size": 16, "embed_dim": 128, "num_heads": 8, "num_layers": 8, "mlp_dim": 256, "dropout_rate": 0.0},
        "use_augmentation": True,
        "optimizer": "adamw",
        "weight_decay": 1e-4,
    },
    {
        "id": "V4",
        "technique": "ViT",
        "description": "ViT tuned: dropout + weight decay + mais heads/layers",
        "model": "vit",
        "model_params": {"patch_size": 16, "embed_dim": 160, "num_heads": 10, "num_layers": 10, "mlp_dim": 320, "dropout_rate": 0.2},
        "use_augmentation": True,
        "optimizer": "adamw",
        "weight_decay": 1e-4,
    },
]


def get_experiment(experiment_id):
    for exp in EXPERIMENTS:
        if exp["id"] == experiment_id:
            return exp
    raise ValueError(f"Experimento não encontrado: {experiment_id}")
