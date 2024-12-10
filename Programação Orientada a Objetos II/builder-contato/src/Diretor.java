import builder.Builder;

public class Diretor {
    protected Builder builder;

    public Diretor(Builder builder) {
        this.builder = builder;
    }

    public void construirContato(String nome, String endereco, String telefone, String email) {
        builder.construirContato(nome, endereco, telefone, email);
    }
}
