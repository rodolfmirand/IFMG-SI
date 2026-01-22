import * as http from 'http';
import { Blockchain } from './models/blockchain.model.ts';

const PORT = parseInt(process.argv[2]) || 3000;

const ALL_NODES = [3000, 3001, 3002];
const OTHER_NODES = ALL_NODES.filter(p => p !== PORT);

const myBlockchain = new Blockchain();

const server = http.createServer((req, res) => {
    res.setHeader('Access-Control-Allow-Origin', '*');
    res.setHeader('Access-Control-Allow-Methods', 'GET, POST, OPTIONS');
    res.setHeader('Access-Control-Allow-Headers', 'Content-Type');

    if (req.method === 'OPTIONS') {
        res.writeHead(204);
        return res.end();
    }

    const { method, url } = req;
    
    // Rota JSON da Blockchain
    if (method === 'GET' && url === '/blockchain') {
        res.writeHead(200, { 'Content-Type': 'application/json' });
        return res.end(JSON.stringify(myBlockchain.chain, null, 2));
    }

    // INSERIR: Adiciona transação e propaga para o consenso
    if (method === 'POST' && url === '/transaction') {
        let body = '';

        req.on('data', chunk => {
            body += chunk.toString();
        });

        req.on('end', async () => {
            try {
            const data = JSON.parse(body);
            
            console.log(`[Nó ${PORT}] Minerando novo bloco...`);
            
            // Adiciona o bloco à corrente
            myBlockchain.addBlock(data);
            
            console.log(`[Nó ${PORT}] Bloco ${myBlockchain.getLatestBlock().index} adicionado com sucesso!`);

            res.writeHead(201, { 'Content-Type': 'application/json' });
            res.end(JSON.stringify({ 
                message: "Bloco minerado e adicionado", 
                index: myBlockchain.getLatestBlock().index 
            }));

            runConsensus(); 

            } catch (error) {
            res.writeHead(400);
            res.end(JSON.stringify({ error: "JSON inválido ou erro na mineração" }));
            }
        });
        }
    }); 

// LÓGICA DE CONSENSO (Democracia 50% + 1)
async function runConsensus() {
    const remoteChains: any[][] = [];

    for (const port of OTHER_NODES) {
        try {
            const response = await fetch(`http://localhost:${port}/blockchain`);
            if (response.ok) {
                const chain = await response.json();
                remoteChains.push(chain);
            }
        } catch (e) {
            console.log(`[Nó ${PORT}] Vizinho na porta ${port} está offline.`);
        }
    }

    if (remoteChains.length === 0) return;

    // Encontrar a maior corrente válida entre os vizinhos
    let bestRemoteChain = myBlockchain.chain;

    for (const remoteChain of remoteChains) {
        // Regra: Deve ser maior que a atual E passar no teste matemático de validade
        if (remoteChain.length > bestRemoteChain.length) {
            
            if (myBlockchain.isChainValid(remoteChain)) {
                bestRemoteChain = remoteChain;
            } else {
                console.log(`[Nó ${PORT}] Alerta: Recebida corrente maior, porém INVÁLIDA de um vizinho.`);
            }
        }
    }

    // Se a melhor corrente encontrada for maior, atualiza
    if (bestRemoteChain.length > myBlockchain.chain.length) {
        console.log(`[Nó ${PORT}] Encontrada corrente mais longa. Sincronizando...`);
        myBlockchain.chain = bestRemoteChain;
        return; 
    }

    // Democracia (Empate de tamanho): Se as correntes têm o mesmo tamanho mas hashes diferentes
    const allChains = [...remoteChains, myBlockchain.chain].filter(c => c.length === myBlockchain.chain.length);
    const votes: Record<string, number> = {};
    const chainMap: Record<string, any[]> = {};

    allChains.forEach(chain => {
        const chainId = chain[chain.length - 1].hash;
        votes[chainId] = (votes[chainId] || 0) + 1;
        chainMap[chainId] = chain;
    });

    const majorityNeeded = Math.floor(ALL_NODES.length / 2) + 1;
    const winningHash = Object.keys(votes).find(hash => votes[hash] >= majorityNeeded);

    if (winningHash && winningHash !== myBlockchain.getLatestBlock().hash) {
        console.log(`[Nó ${PORT}] Consenso de maioria: substituindo por versão divergente de mesmo tamanho.`);
        myBlockchain.chain = chainMap[winningHash];
    }
}

server.listen(PORT, () => {
    console.log(`Blockchain Node rodando na porta ${PORT}`);
});

const INTERVALO_VALIDACAO = 5000; // 5 segundos

setInterval(async () => {
    console.log(`[Nó ${PORT}] Executando validação periódica de rotina...`);
    await runConsensus();
}, INTERVALO_VALIDACAO);