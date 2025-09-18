"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Robo = void 0;
class Robo {
    id;
    linha;
    coluna;
    encontrou;
    tabuleiro;
    constructor(id, linha, coluna, tabuleiro) {
        this.id = id;
        this.linha = linha;
        this.coluna = coluna;
        this.encontrou = false;
        this.tabuleiro = tabuleiro;
    }
    async percorrerSubArea(startCol, endCol) {
        for (let i = this.tabuleiro.linhas - 1; i >= 0; i--) {
            for (let j = startCol; j <= endCol; j++) {
                if (this.tabuleiro.area[i][j] === "O") {
                    this.encontrou = true;
                    console.log(`Robô ${this.id} encontrou o objeto em [${i},${j}]`);
                    return;
                }
            }
        }
    }
}
exports.Robo = Robo;
//# sourceMappingURL=robo.js.map