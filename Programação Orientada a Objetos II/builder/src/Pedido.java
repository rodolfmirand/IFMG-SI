import java.util.HashSet;
import java.util.Set;

public class Pedido {
    private Set<String> dentroDaCaixa = new HashSet<>();
    private Set<String> foraDaCaixa = new HashSet<>();

    public void adicionarDentroDaCaixa(String item) {
        dentroDaCaixa.add(item);
    }

    public void adicionarForaDaCaixa(String item) {
        foraDaCaixa.add(item);
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("Seu pedido:\n");
        buffer.append("Dentro da caixa:\n");
        for (String item : dentroDaCaixa) {
            buffer.append("\t" + item + "\n");
        }
        buffer.append("Fora da caixa:\n");
        for (String item : foraDaCaixa) {
            buffer.append("\t" + item + "\n");
        }
        buffer.append("\nTenha um bom dia!\n\n");
        return buffer.toString();
    }
}
