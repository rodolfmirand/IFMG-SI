"use strict";
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    var desc = Object.getOwnPropertyDescriptor(m, k);
    if (!desc || ("get" in desc ? !m.__esModule : desc.writable || desc.configurable)) {
      desc = { enumerable: true, get: function() { return m[k]; } };
    }
    Object.defineProperty(o, k2, desc);
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
var __setModuleDefault = (this && this.__setModuleDefault) || (Object.create ? (function(o, v) {
    Object.defineProperty(o, "default", { enumerable: true, value: v });
}) : function(o, v) {
    o["default"] = v;
});
var __importStar = (this && this.__importStar) || (function () {
    var ownKeys = function(o) {
        ownKeys = Object.getOwnPropertyNames || function (o) {
            var ar = [];
            for (var k in o) if (Object.prototype.hasOwnProperty.call(o, k)) ar[ar.length] = k;
            return ar;
        };
        return ownKeys(o);
    };
    return function (mod) {
        if (mod && mod.__esModule) return mod;
        var result = {};
        if (mod != null) for (var k = ownKeys(mod), i = 0; i < k.length; i++) if (k[i] !== "default") __createBinding(result, mod, k[i]);
        __setModuleDefault(result, mod);
        return result;
    };
})();
Object.defineProperty(exports, "__esModule", { value: true });
const robo_1 = require("./robo");
const tabuleiro_1 = require("./tabuleiro");
const readline = __importStar(require("readline"));
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
function perguntar(question) {
    return new Promise((resolve) => {
        rl.question(question, (answer) => {
            const num = parseInt(answer, 10);
            resolve(num);
        });
    });
}
(async () => {
    const linhas = await perguntar("Digite o número de linhas do tabuleiro: ");
    const colunas = await perguntar("Digite o número de colunas do tabuleiro: ");
    const numRobos = await perguntar("Digite o número de robôs: ");
    rl.close();
    if (isNaN(linhas) || isNaN(colunas) || isNaN(numRobos)) {
        throw new Error("Todos os valores devem ser números válidos.");
    }
    const tabuleiro = new tabuleiro_1.Tabuleiro(linhas, colunas);
    tabuleiro.colocarObjeto(2, 9);
    tabuleiro.imprimir();
    const robos = [];
    for (let i = 0; i < numRobos; i++) {
        const coluna = Math.floor((colunas / numRobos) * i);
        robos.push(new robo_1.Robo(i + 1, linhas - 1, coluna, tabuleiro));
    }
    const colunasPorRobo = Math.floor(colunas / numRobos);
    await Promise.all(robos.map((robo, index) => {
        const startCol = index * colunasPorRobo;
        const endCol = (index + 1) * colunasPorRobo - 1;
        return robo.percorrerSubArea(startCol, endCol);
    }));
    console.log("Busca finalizada!");
})();
//# sourceMappingURL=index.js.map