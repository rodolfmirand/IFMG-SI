import { Tabuleiro } from "./tabuleiro";
export declare class Robo {
    id: number;
    linha: number;
    coluna: number;
    encontrou: boolean;
    tabuleiro: Tabuleiro;
    constructor(id: number, linha: number, coluna: number, tabuleiro: Tabuleiro);
    percorrerSubArea(startCol: number, endCol: number): Promise<void>;
}
//# sourceMappingURL=robo.d.ts.map