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
                    <small>Bloco #${block.index}</small><br>
                    <b>Conteúdo:</b> ${conteudo}<br>
                    <small style="display:block; margin-top:5px">Hash:</small>
                    <span class="hash">${block.hash}</span>
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
    if(!input.value) return;

    btn.disabled = true;
    btn.innerText = "Minerando...";

    try {
        await fetch('http://localhost:3000/transaction', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ texto: input.value })
        });
        input.value = '';
    } catch (e) {
        alert("Erro ao enviar");
    } finally {
        btn.disabled = false;
        btn.innerText = "Minerar no Nó 3000";
        updateAll();
    }
}

function updateAll() {
    [3000, 3001, 3002].forEach(fetchChain);
}

setInterval(updateAll, 5000);
updateAll();