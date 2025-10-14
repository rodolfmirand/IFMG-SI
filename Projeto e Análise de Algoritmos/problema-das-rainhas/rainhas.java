import java.util.Scanner;

void main() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Digite o tamanho do tabuleiro (n x n): ");
    int n = scanner.nextInt();

    System.out.print("Quantas rainhas deseja colocar no tabuleiro?: ");
    int nRainhas = scanner.nextInt();

    String[][] tabuleiro = criarTabuleiroComRainhas(n, nRainhas);


    scanner.close();
}

String[][] criarTabuleiroComRainhas(int nTabuleiro, int nRainhas) {
    String[][] tabuleiro = inicializarTabuleiro(nTabuleiro);
    imprimirTabuleiro(tabuleiro);
    for (int i = 0; i < nRainhas; i++) {
        tabuleiro = colocarRainha(tabuleiro);
    }
    imprimirTabuleiro(tabuleiro);
    return tabuleiro;
}

String[][] inicializarTabuleiro(int n) {
    String[][] tabuleiro = new String[n][n];
    for (int linha = 0; linha < n; linha++) {
        for (int coluna = 0; coluna < n; coluna++) {
            tabuleiro[linha][coluna] = ".";
        }
    }
    return tabuleiro;
}

String[][] colocarRainha(String[][] tabuleiro) {
    int linha = gerarNumeroAleatorio(tabuleiro.length);
    int coluna = gerarNumeroAleatorio(tabuleiro.length);
    if (tabuleiro[linha][coluna].equals("R")) {
        return colocarRainha(tabuleiro);
    }
    tabuleiro[linha][coluna] = "R";
    return tabuleiro;
}

void imprimirTabuleiro(String[][] tabuleiro) {
    for (String[] linha : tabuleiro) {
        for (String celula : linha) {
            System.out.print(celula + " ");
        }
        System.out.println();
    }
}

int gerarNumeroAleatorio(int max) {
    return (int) (Math.random() * max);
}