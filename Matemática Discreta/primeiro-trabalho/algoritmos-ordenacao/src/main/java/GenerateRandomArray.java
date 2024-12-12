import java.util.Random;

public class GenerateRandomArray {
    public static int[] generate(int size){
        int[] vet = new int[size];

        // define que sempre será gerado o mesmo vetor
        Random rnd = new Random(17);

        for (int i = 0; i < vet.length; i++) {
            // gera um número aleátorio entre 0 (inclusive) e 1.000.000 (exclusive)
            vet[i] = rnd.nextInt(100);
        }

        return vet;
    }
}
