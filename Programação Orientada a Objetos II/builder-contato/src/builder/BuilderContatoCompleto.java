package builder;

import models.Contato;
import models.ContatoCompleto;

public class BuilderContatoCompleto implements Builder{

    private ContatoCompleto contatoCompleto;

    @Override
    public void construirContato(String nome, String endereco, String telefone, String email) {
        contatoCompleto = new ContatoCompleto(nome, endereco, telefone, email);
    }

    @Override
    public Contato getContato() {
        return contatoCompleto;
    }
}
