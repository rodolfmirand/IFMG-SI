
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.HashSet;

public class gerarVetor {

    public static void main(String[] args) throws IOException {
        int tamanho = 10000; // Tamanho do vetor desejado
        int limite = 100000; // Limite superior para os valores aleatórios
        int i, n;


        FileWriter arq = new FileWriter("C:\\Users\\rodol\\Área de Trabalho\\vetores.txt");
        PrintWriter gravarArq = new PrintWriter(arq);


        
        Random random = new Random();
        HashSet<Integer> valoresDiferentes = new HashSet<>();

        while (valoresDiferentes.size() < tamanho) {
            int valor = random.nextInt(limite); // Gera um valor aleatório de 0 a limite - 1
            valoresDiferentes.add(valor);
        }

        int[] vetor = new int[tamanho];
        int j = 0;

        for (int valor : valoresDiferentes) {
            vetor[j++] = valor;
        }

        // Imprimir o vetor
        for (int elemento : vetor) {
            gravarArq.printf(elemento + ", ");
        }
        arq.close();
    }
}
