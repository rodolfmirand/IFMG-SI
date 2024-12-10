package models;

public class ContatoTelefone extends Contato{

    public ContatoTelefone(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Contato Telefone: \n\tNome: " + nome + "\n\tTelefone: " + telefone + "\n";
    }
}
