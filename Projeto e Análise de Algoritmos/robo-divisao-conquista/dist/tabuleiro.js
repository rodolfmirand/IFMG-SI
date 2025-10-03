"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Tabuleiro = void 0;
class Tabuleiro {
    linhas;
    colunas;
    area;
    constructor(linhas, colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.area = Array.from({ length: linhas }, () => new Array(colunas).fill("_"));
    }
    colocarObjeto(linha, coluna) {
        this.area[linha][coluna] = "O";
    }
    imprimir() {
        console.table(this.area);
    }
}
exports.Tabuleiro = Tabuleiro;
//# sourceMappingURL=tabuleiro.js.map