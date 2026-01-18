import express from 'express';
import path from 'path';
import { fileURLToPath } from 'url';

const app = express();
const PORT_FRONT = 8080;

// Configuração para encontrar o caminho da pasta no modo ESM
const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

// Serve todos os arquivos da pasta atual (index.html, script.js)
app.use(express.static(__dirname));

app.listen(PORT_FRONT, () => {
    console.log(`
    SISTEMA DE MONITORAMENTO BLOCKCHAIN ONLINE
    Acesse: http://localhost:${PORT_FRONT}
    `);
});