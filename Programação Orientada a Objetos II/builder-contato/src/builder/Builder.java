package builder;

import models.Contato;

public interface Builder {
    void construirContato(String nome, String endereco, String telefone, String email);
    Contato getContato();
}
