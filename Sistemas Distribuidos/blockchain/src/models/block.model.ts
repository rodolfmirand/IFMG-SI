import * as crypto from 'crypto';

export class Block {
  public index: number;
  public timestamp: number;
  public data: any;
  public previousHash: string;
  public hash: string;
  public nonce: number = 0;

  constructor(index: number, timestamp: number, data: any, previousHash: string = '') {
    this.index = index;
    this.timestamp = timestamp;
    this.data = data;
    this.previousHash = previousHash;
    this.hash = this.mineBlock(4);
  }

  calculateHash(): string {
    const dataString =
      this.index +
      this.previousHash +
      this.timestamp +
      JSON.stringify(this.data) +
      this.nonce;

    return crypto.createHash('sha256').update(dataString).digest('hex');
  }

  mineBlock(difficulty: number): string {
    const target = "0".repeat(difficulty);
    let currentHash = this.calculateHash();

    while (currentHash.substring(0, difficulty) !== target) {
      this.nonce++;
      currentHash = this.calculateHash();
    }

    return currentHash;
  }
}