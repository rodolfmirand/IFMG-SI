package builder;

import models.Contato;
import models.ContatoInternet;

public class BuilderContatoInternet implements Builder{

    private ContatoInternet contatoInternet;

    @Override
    public void construirContato(String nome, String endereco, String telefone, String email) {
        contatoInternet = new ContatoInternet(nome, email);
    }

    @Override
    public Contato getContato() {
        return contatoInternet;
    }
}
