import { Block } from "./block.model.ts";

export class Blockchain {
    public chain: Block[];

    constructor() {
        this.chain = [this.createGenesisBlock()];
    }

    private createGenesisBlock(): Block {
        return new Block(0, 1736945000000, { info: "Genesis Block - Root" }, "0");
    }

    getLatestBlock(): Block {
        return this.chain[this.chain.length - 1];
    }

    addBlock(newData: any): void {
        const previousBlock = this.getLatestBlock();
        const newBlock = new Block(
            previousBlock.index + 1,
            Date.now(),
            newData,
            previousBlock.hash
        );
        this.chain.push(newBlock);
    }

    isChainValid(): boolean {
        for (let i = 1; i < this.chain.length; i++) {
            const currentBlock = this.chain[i];
            const previousBlock = this.chain[i - 1];

            // Verifica se o hash do bloco atual é válido
            if (currentBlock.hash !== currentBlock.calculateHash()) return false;

            // Verifica se o bloco aponta corretamente para o anterior
            if (currentBlock.previousHash !== previousBlock.hash) return false;
        }
        return true;
    }
}