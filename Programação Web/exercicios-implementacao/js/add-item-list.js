const addItemBtn = document.getElementById('addItemBtn');
const popup = document.getElementById('popup');
const insert = document.getElementById('insert');
const cancel = document.getElementById('cancel');
const input = document.getElementById('input');
const list = document.getElementById('list');

function abrirInput() {
    popup.classList.remove('hidden');
    input.value = ''; 
    input.focus();
}

function cancelar() {
    popup.classList.add('hidden');
}

function inserirTexto() {
    const text = input.value.trim();
    if (text) {
        const line = document.createElement('li');
        line.textContent = text;
        list.appendChild(line);
        popup.classList.add('hidden');
    } else {
        alert('Digite algo antes de confirmar!');
    }
}
