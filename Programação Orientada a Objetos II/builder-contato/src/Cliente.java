import builder.BuilderContatoCompleto;
import builder.BuilderContatoInternet;
import builder.BuilderContatoTelefone;

public class Cliente {
    public static void main(String[] args) {
        String nome = "Rodolfo Miranda";
        String endereco = "Rua E, 4XX";
        String telefone = "1234-5678";
        String email = "rodolfo@email.com";

        Diretor diretorInternet = new Diretor(new BuilderContatoInternet());
        Diretor diretorTelefone = new Diretor(new BuilderContatoTelefone());
        Diretor diretorCompleto = new Diretor(new BuilderContatoCompleto());

        diretorInternet.construirContato(nome, endereco, telefone, email);
        diretorTelefone.construirContato(nome, endereco, telefone, email);
        diretorCompleto.construirContato(nome, endereco, telefone, email);

        System.out.println(diretorInternet.builder.getContato());
        System.out.println(diretorTelefone.builder.getContato());
        System.out.println(diretorCompleto.builder.getContato());
    }
}
