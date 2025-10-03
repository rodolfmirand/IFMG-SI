import { Tabuleiro } from "./tabuleiro";

export class Robo {
    id: number;
    linha: number;
    coluna: number;
    encontrou: boolean;
    tabuleiro: Tabuleiro;

    constructor(id: number, linha: number, coluna: number, tabuleiro: Tabuleiro) {
        this.id = id;
        this.linha = linha;
        this.coluna = coluna;
        this.encontrou = false;
        this.tabuleiro = tabuleiro;
    }

    async percorrerSubArea(startCol: number, endCol: number) {
        for (let i = this.tabuleiro.linhas - 1; i >= 0; i--) {
            for (let j = startCol; j <= endCol; j++) {
                if (this.tabuleiro.area[i]![j] === "O") {
                    this.encontrou = true;
                    console.log(`Robô ${this.id} encontrou o objeto em [${i},${j}]`);
                    return;
                }
            }
        }
    }
}