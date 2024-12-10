package builder;

import models.Contato;
import models.ContatoTelefone;

public class BuilderContatoTelefone implements Builder{

    private ContatoTelefone contatoTelefone;

    @Override
    public void construirContato(String nome, String endereco, String telefone, String email) {
        contatoTelefone = new ContatoTelefone(nome, telefone);
    }

    @Override
    public Contato getContato() {
        return contatoTelefone;
    }
}
