const botaoAdicionar = document.getElementById('add');
const botaoRemover = document.getElementById('remove');
const lista = document.getElementById('list');

function adicionarLinha() {
    lista.appendChild(document.createElement('li'));
}

function removerLinha() {
    lista.appendChild(lista.lastChild.remove());
}
