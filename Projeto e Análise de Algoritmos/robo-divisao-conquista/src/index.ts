import { Robo } from "./robo";
import { Tabuleiro } from "./tabuleiro";

const linhas = 5;
const colunas = 10;
const numRobos = 5;

const tabuleiro = new Tabuleiro(linhas, colunas);
tabuleiro.colocarObjeto(2, 9);
tabuleiro.imprimir();

const robos: Robo[] = [];
for (let i = 0; i < numRobos; i++) {
    const coluna = Math.floor((colunas / numRobos) * i);
    robos.push(new Robo(i + 1, linhas - 1, coluna, tabuleiro));
}

(async () => {
    const colunasPorRobo = Math.floor(colunas / numRobos);

    await Promise.all(
        robos.map((robo, index) => {
            const startCol = index * colunasPorRobo;
            const endCol = (index + 1) * colunasPorRobo - 1;
            return robo.percorrerSubArea(startCol, endCol);
        })
    );

    console.log("Busca finalizada!");
})();
