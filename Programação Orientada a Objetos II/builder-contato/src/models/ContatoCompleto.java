package models;

public class ContatoCompleto extends Contato{

    public ContatoCompleto(String nome, String endereco, String telefone, String email) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Contato Completo: \n\tNome: " + nome + "\n\tEmail: " + email + "\n\tTelefone: " + telefone + "\n\tEndereco: " + endereco + "\n";
    }
}
