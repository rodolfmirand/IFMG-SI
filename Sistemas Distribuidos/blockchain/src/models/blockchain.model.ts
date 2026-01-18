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

    isChainValid(chain: any[]): boolean {
        for (let i = 1; i < chain.length; i++) {
            const currentBlock = chain[i];
            const previousBlock = chain[i - 1];

            if (currentBlock.previousHash !== previousBlock.hash) {
                return false;
            }

            if (currentBlock.hash.substring(0, 4) !== "0000") {
                return false;
            }
        }
        return true;
    }
}