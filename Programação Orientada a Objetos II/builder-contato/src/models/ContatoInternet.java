package models;

public class ContatoInternet extends Contato {

    public ContatoInternet(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contato Internet: \n\tNome: " + nome + "\n\tEmail: " + email + "\n";
    }
}

