async function fetchChain(port) {
    try {
        const res = await fetch(`http://localhost:${port}/blockchain`);
        const data = await res.json();
        const container = document.getElementById(`chain-${port}`);
        
        container.innerHTML = data.map(block => {
            const isGenesis = block.index === 0;
            const conteudo = block.data.texto || (isGenesis ? "ROOT" : JSON.stringify(block.data));
            
        return `
                <div class="block ${isGenesis ? 'genesis' : ''}">
                    <small class="label">Bloco #${block.index}</small><br>
                    <b>Conteúdo:</b> ${conteudo}<br>
                    
                    <div style="margin-top:10px">
                        <small class="label">Hash Anterior:</small>
                        <span class="hash-prev">${block.previousHash}</span>
                    </div>

                    <div style="margin-top:5px">
                        <small class="label">Hash Atual:</small>
                        <span class="hash">${block.hash}</span>
                    </div>
                    
                    <small class="label">Nonce:</small> <b>${block.nonce}</b>
                </div>
            `;
        }).reverse().join('');
    } catch (e) {
        document.getElementById(`chain-${port}`).innerHTML = "<p style='color:red'>Offline</p>";
    }
}

async function sendTransaction() {
    const input = document.getElementById('txData');
    const btn = document.getElementById('btnMine');
    const selectedPort = document.getElementById('nodeSelect').value; // Captura o nó selecionado

    if(!input.value) {
        alert("Digite uma mensagem antes de minerar.");
        return;
    }

    btn.disabled = true;
    const originalText = btn.innerText;
    btn.innerText = `Minerando no Nó ${selectedPort}...`;

    try {
        const response = await fetch(`http://localhost:${selectedPort}/transaction`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ texto: input.value })
        });

        if (!response.ok) throw new Error("Erro na mineração");

        input.value = '';
    } catch (e) {
        console.error(e);
        alert(`Erro ao enviar para o Nó ${selectedPort}. O servidor está rodando?`);
    } finally {
        btn.disabled = false;
        btn.innerText = originalText;
        updateAll();
    }
}

function updateAll() {
    [3000, 3001, 3002].forEach(fetchChain);
}

setInterval(updateAll, 5000);
updateAll();