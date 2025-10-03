export class Tabuleiro {
    linhas: number;
    colunas: number;
    area: string[][];

    constructor(linhas: number, colunas: number) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.area = Array.from({ length: linhas }, () => new Array(colunas).fill("_"));
    }

    colocarObjeto(linha: number, coluna: number) {
        this.area[linha]![coluna] = "O";
    }

    imprimir() {
        console.table(this.area);
    }
}